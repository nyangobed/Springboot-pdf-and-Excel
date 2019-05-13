package com.pos.demo.Controllers;


import com.pos.demo.Entities.customer;
import com.pos.demo.Repositories.CustomerRepository;
import com.pos.demo.Services.CustomerService;
import com.pos.demo.models.CustomerReport;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class ReportController {
     @Autowired
    private  CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;

   /*...................................pdf controller .............................*/
    @GetMapping(value = "/employeeReport.pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public HttpEntity<byte[]> getCustomerReportPdf(final HttpServletResponse response) throws JRException, IOException, ClassNotFoundException {
        final CustomerReport report = new CustomerReport(customerRepository.findAll());
        final byte[] data = customerService.getReportPdf(report.getReport());

//        HttpHeaders header = new HttpHeaders();
//        header.setContentType(MediaType.APPLICATION_PDF);
//        header.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=employeeReport.pdf");
//        header.setContentLength(data.length);

        return new HttpEntity<byte[]>(data);
    }
    /*...................................xlxs controller .............................*/
    @GetMapping(value = "/customers.xlsx" , produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    @ResponseBody
    public HttpEntity<byte[]>getCustomerXlsx(final HttpServletResponse response) throws  JRException,IOException,ClassNotFoundException{
     final  CustomerReport report= new CustomerReport(customerRepository.findAll());
     final  byte[] data =customerService.getReportXlsx(report.getReport());
   HttpHeaders headers=new HttpHeaders();
//     headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
//     headers.set(HttpHeaders.CONTENT_DISPOSITION,"inline; filename=employeeReport.xlsx");
//     headers.setContentLength(data.length);
     return  new HttpEntity<byte[]>(data,headers);
    }



    /*.........................creating pdf reports part 2................*/

}
