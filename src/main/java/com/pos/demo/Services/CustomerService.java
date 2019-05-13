package com.pos.demo.Services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pos.demo.Entities.customer;
import com.pos.demo.Repositories.CustomerRepository;
import com.pos.demo.models.RegisterCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

/*.......................registration of customers..............................*/
    public Map<String,Object> register(RegisterCustomerRequest customerRequest){
        Map<String,Object> map= new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        customer cust= new customer();
        cust.setCode(customerRequest.getCode());
        cust.setCompany(customerRequest.getCompany());
        cust.setContactPerson(customerRequest.getContactPerson());
        cust.setEmail(customerRequest.getEmail());
        cust.setName(customerRequest.getName());
        cust.setPhone(customerRequest.getPhone());
        cust.setRegion(customerRequest.getRegion());

        customerRepository.save(cust);
        map.put("message","registration sucessful");
        return  map;
}

    /*.......................pdf report.............................*/


    public  byte[]  getReportPdf(final JasperPrint jp) throws JRException{
        return  JasperExportManager.exportReportToPdf(jp);
    }
    /*.......................excel report.............................*/


    public byte[]getReportXlsx(final  JasperPrint jp)throws JRException, IOException{
        JRXlsxExporter xlsxExporter= new JRXlsxExporter();
        final byte[] rawBytes;
        try(ByteArrayOutputStream xlsReport = new ByteArrayOutputStream()){
            xlsxExporter.setExporterInput(new SimpleExporterInput(jp));
            xlsxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsReport));
            xlsxExporter.exportReport();

            rawBytes = xlsReport.toByteArray();
        }

        return rawBytes;
        }
    }

