package com.mastersystem.mcmanager.application.controller;

import com.mastersystem.mcmanager.application.dto.response.ReciboResponse;
import com.mastersystem.mcmanager.domain.service.ReciboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping(value = "/api/v1/recibo")
public class ReciboController {

    @Autowired
    private ReciboService reciboService;

    @PostMapping (consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReciboResponse> verificaPdf(@RequestParam("file") MultipartFile file){
        return reciboService.verificaPdf(file);
    }

}
