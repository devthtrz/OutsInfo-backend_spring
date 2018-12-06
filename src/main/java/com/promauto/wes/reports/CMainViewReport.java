package com.promauto.wes.reports;

import com.promauto.wes.exceptions.CMainNotFoundException;
import com.promauto.wes.exceptions.CModuleNotFoundException;
import com.promauto.wes.models.CMain;
import com.promauto.wes.repository.CMainRepository;
import com.promauto.wes.resources.CMainResources;
import com.promauto.wes.services.CMainService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Belyaev Alexei (lebllex) on 06.12.18.
 */
@RestController
@RequestMapping("/pdf/main")
public class CMainViewReport {
    private final CMainService mainService;
    private final CMainRepository mainRepository;
    private final String main_template_path = "reports/MainReport.jrxml";

    public CMainViewReport(CMainService mainService,CMainRepository repository){
        this.mainService = mainService;
        this.mainRepository=repository;
    }

    @GetMapping
    public ResponseEntity<byte[]> report(String moduleName) throws JRException {
        byte[] bytes = null;
        final JasperReport report = loadTemplate();

        // return the PDF in bytes


        try {
            final Map<String, Object> parameters = parameters(mainService.findOne("W319"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(report,parameters, (JRDataSource) mainRepository);
            bytes = JasperExportManager.exportReportToPdf(jasperPrint);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/pdf; charset=UTF-8")
                    .header("Content-Disposition", "inline; filename=\"" + moduleName + ".pdf\"")
                    .body(bytes);
        } catch (CMainNotFoundException e) {
            e.printStackTrace();
        } catch (CModuleNotFoundException e) {
            e.printStackTrace();
        }

//        JRPdfExporter exporter = new JRPdfExporter();

//        JasperReportsPdfView view = new JasperReportsPdfView();
//        view.setUrl("classpath:report2.jrxml");
//        view.setApplicationContext(appContext);
//
//        Map<String, Object> params = new HashMap<>();
//        params.put("datasource", carService.getCars());
//
//        return new ModelAndView(view, params);
        return null;
    }

    private JasperReport loadTemplate() throws JRException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        final InputStream reportInputStream = classloader.getResourceAsStream(main_template_path);
        System.out.println(reportInputStream.toString());
        final JasperDesign jasperDesign = JRXmlLoader.load(reportInputStream);
        return JasperCompileManager.compileReport(jasperDesign);
    }

    private Map<String, Object> parameters(CMain cmain) {
        final Map<String, Object> parameters = new HashMap<>();

//        parameters.put("logo", getClass().getResourceAsStream(logo_path));
        parameters.put("cmain",  cmain);
//        parameters.put("REPORT_LOCALE", locale);

        return parameters;
    }



}
