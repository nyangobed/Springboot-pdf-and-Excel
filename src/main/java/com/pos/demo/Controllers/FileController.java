package com.pos.demo.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;

@RestController

public class FileController {
    /*..............................file upload.................*/
   @RequestMapping(value = "/upload", method = RequestMethod.POST,
           consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

   public String fileUpload(@RequestParam("file") MultipartFile file) throws Exception {
           if (file!=null)
           {throw new  MultipartException("Failed to store empty file");
           }
       File convertFile = new File("uploads"+file.getOriginalFilename());
       convertFile.createNewFile();
       FileOutputStream fout = new FileOutputStream(convertFile);
       fout.write(file.getBytes());
       fout.close();
       return "File is upload successfully";
   }


       /*..............................file download...................................... */
    public ResponseEntity<Object>downloadFile(){
        return  new ResponseEntity<>("status", HttpStatus.OK);
    }
}
