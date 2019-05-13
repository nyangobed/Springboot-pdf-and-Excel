package com.pos.demo.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pos.demo.Entities.Admin;
import com.pos.demo.Repositories.AdminRepository;
import com.pos.demo.models.AdminLoginRequest;
import com.pos.demo.models.AdminRegisterRequest;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeMultipart;
import org.apache.coyote.http11.filters.VoidInputFilter;
import org.exolab.castor.types.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.PasswordAuthentication;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    /*..................registration of an admin...............................*/
    public Map<String,Object> register(AdminRegisterRequest adminRegisterRequest){
        Map<String,Object> map= new HashMap<>();
        ObjectMapper mapper=new ObjectMapper();
        Admin adm= new Admin();
        adm.setFirstname(adminRegisterRequest.getFirstname());
        adm.setLastname(adminRegisterRequest.getLastname());
        adm.setPassword(adminRegisterRequest.getPassword());
        adm.setUsername(adminRegisterRequest.getUsername());
        adminRepository.save(adm);
        map.put("message","saved successfully");
            return map;

    }
    /*..........................login..............................*/
    public Map<String,Object>login(AdminLoginRequest adminLoginRequest)
    {
        Map<String,Object> map= new HashMap<>();
        ObjectMapper mapper=new ObjectMapper();
        Optional<Admin> admn=adminRepository.findAdminByUsernameAndPassword(adminLoginRequest.getUsername(),adminLoginRequest.getPassword());
        if(!admn.isPresent()){
            map.put("message","login sucessful");
                    }
        Admin admn2=admn.get();
        map.put("Firstname",admn2.getFirstname());
        map.put("Lastname",admn2.getLastname());
        map.put("Username",admn2.getUsername());
        return map;



    }
    /*......................date increment....................*/

public static String add9Months(String date){
    return LocalDate.parse(date).plusMonths(9).toString();
}



}
