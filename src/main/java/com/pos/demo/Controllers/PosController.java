package com.pos.demo.Controllers;


import com.pos.demo.Entities.pos;
import com.pos.demo.Repositories.PosRepository;
import com.pos.demo.Services.TerminalService;
import com.pos.demo.models.RegisterTerminalRequest;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
public class PosController {
    @Autowired
    private TerminalService terminalService;
    @Autowired
    private PosRepository posRepository;

    /*................. registerpos endpoint..............*/
    @RequestMapping(value = "/registerPos", method = RequestMethod.POST)
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterTerminalRequest terminalRequest) {
        Map<String, Object> response = new HashMap<>();
        response = terminalService.registerPos(terminalRequest);
        return new ResponseEntity(response, HttpStatus.OK);

    }

    /*....................retrieving all pos..................*/
    @GetMapping(value = "/pos")
    public Iterable list() {
        return posRepository.findAll();
    }

    /*.........................deleting a specific pos................*/
    @DeleteMapping(value = "/pos/{id}")
    public void deletepos(@PathVariable Long id) {
        posRepository.deleteById(id);

    }

    /*...................updating a specific pos........................*/
    @PostMapping(value = "/update/{id}")
    public ResponseEntity<Object> updatepos(@RequestBody pos pk, @PathVariable long id) {
        Optional<pos> posk = posRepository.findById(id);
        if(!posk.isPresent())
            return ResponseEntity.notFound().build();
        pk.setId(id);
        posRepository.save(pk);
        return ResponseEntity.noContent().build();
    }
}
