package com.promauto.wes.services.reports;

import com.promauto.wes.services.CMainService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Belyaev Alexei (lebllex) on 07.12.18.
 */
@Service
public class JasperReportService {
    private final CMainService  mainService;

    public JasperReportService(CMainService mainService){
        this.mainService = mainService;
    }

    public byte[] getMainReportPdfAsBytes(String repoSitoryPath) throws JRException {
        byte[] bytes = null;
        final JasperReport report = loadTemplate(repoSitoryPath);
        final Map<String, Object> parameters = new HashMap();
        parameters.put("pageTittle","Отчет за смену");
        JRBeanCollectionDataSource collectionDataSource = new JRBeanCollectionDataSource(mainService.findAll());
        JasperPrint jasperPrint = JasperFillManager.fillReport(report,parameters, collectionDataSource);
        bytes = JasperExportManager.exportReportToPdf(jasperPrint);
        return bytes;
    };

    private JasperReport loadTemplate(String template_path) throws JRException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        final InputStream reportInputStream = classloader.getResourceAsStream(template_path);
        final JasperDesign jasperDesign = JRXmlLoader.load(reportInputStream);
        return JasperCompileManager.compileReport(jasperDesign);
    }
}
