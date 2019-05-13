package com.pos.demo.Services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pos.demo.Entities.pos;
import com.pos.demo.Repositories.PosRepository;
import com.pos.demo.models.RegisterClientRequest;
import com.pos.demo.models.RegisterTerminalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class TerminalService{
    @Autowired
    private PosRepository posRepository;

    /*................. register pos details..............*/

    public Map<String,Object> registerPos(RegisterTerminalRequest terminalrequest){
        Map<String,Object> map= new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        pos reg=new pos();
        reg.setCreatedOn(terminalrequest.getCreatedOn());
        reg.setMake(terminalrequest.getMake());
        reg.setManufacturer(terminalrequest.getManufacturer());
        reg.setOwner(terminalrequest.getOwner());
        reg.setSerialnumber(terminalrequest.getSerialnumber());
        reg.setPartnumber(terminalrequest.getPartnumber());
         map.put("message","registration sucessful");
         posRepository.save(reg);
         return  map;
    }


}
