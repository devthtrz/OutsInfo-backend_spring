package com.promauto.wes.controllers.reports;


import com.promauto.wes.services.reports.JasperReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Belyaev Alexei (lebllex) on 06.12.18.
 */
@RestController
@RequestMapping("/pdf/main")
public class CMViewRepResource {
    private final JasperReportService jreportService;

    private final String main_template_path = "reports/MainReport.jrxml";

    public CMViewRepResource(JasperReportService jreportService){
        this.jreportService = jreportService;
    }

    @GetMapping
    public ResponseEntity<byte[]> report(String moduleName){
        byte[] bytes = null;
        try {
            bytes = jreportService.getMainReportPdfAsBytes(main_template_path);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/pdf; charset=UTF-8")
                    .header("Content-Disposition", "inline; filename=\"" + moduleName + ".pdf\"")
                    .body(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }





}
