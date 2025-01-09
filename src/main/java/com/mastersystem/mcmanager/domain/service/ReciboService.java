package com.mastersystem.mcmanager.domain.service;

import com.mastersystem.mcmanager.application.dto.response.ReciboResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface ReciboService {
    ResponseEntity<ReciboResponse> verificaPdf(MultipartFile file);
}
