package com.mastersystem.mcmanager.infrastructure.service;

import com.mastersystem.mcmanager.application.dto.WebFlowResponse;
import com.mastersystem.mcmanager.application.dto.response.ReciboResponse;
import com.mastersystem.mcmanager.domain.service.ReciboService;
import com.mastersystem.mcmanager.infrastructure.repository.WebFlowClient;
import lombok.extern.log4j.Log4j2;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ReciboServiceImpl implements ReciboService {

    @Autowired
    private WebFlowClient webFlowClient;

    @Override
    public ResponseEntity<ReciboResponse> verificaPdf(MultipartFile file) {
        log.info("[start] ReciboServiceImpl - verificaPdf");
        String pdfText = this.extractPdfText(file);
//        List<WebFlowResponse> keywords = webFlowClient.getKeywords();
        List<WebFlowResponse> keywords = this.tempGetKeywordsAndLinks(); //TODO Trocar a chamada para o webFlowClient -> FeignClient para API do WebFlow
        String matchedKeyword = this.findMatchingKeywords(pdfText, keywords);
        ReciboResponse response = getUrlByKeyword(matchedKeyword, keywords);
        log.info("[finish] ReciboServiceImpl - verificaPdf");
        return ResponseEntity.ok(response);
    }

    private ReciboResponse getUrlByKeyword(String matchedKeyword, List<WebFlowResponse> keywords) {
        log.info("[start] ReciboServiceImpl - getUrlByKeyword");
        ReciboResponse response = new ReciboResponse();

        response.setName(matchedKeyword);
        keywords.stream()
                .filter(keyword -> keyword.getDescription().equals(matchedKeyword))
                .findFirst()
                .ifPresent(keyword -> response.setUrl(keyword.getUrl()));
        log.info("[finish] ReciboServiceImpl - getUrlByKeyword");
        return response;
    }

    private List<WebFlowResponse> tempGetKeywordsAndLinks() {
        List<WebFlowResponse> webFlowResponseList = new ArrayList<>();

        WebFlowResponse item1 = new WebFlowResponse(1L, "AgencyMKT","http://www.sitedorudolph.com/baixe-seu-template-agencymkt");
        WebFlowResponse item2 = new WebFlowResponse(2L, "SalesPipeline","http://www.sitedorudolph.com/baixe-seu-template-salespipeline");
        WebFlowResponse item3 = new WebFlowResponse(3L, "LeadGeneration","http://www.sitedorudolph.com/baixe-seu-template-leadgeneration");
        WebFlowResponse item4 = new WebFlowResponse(4L, "ContentApproval","http://www.sitedorudolph.com/baixe-seu-template-contentapproval");
        WebFlowResponse item5 = new WebFlowResponse(5L, "CampaignLaunch","http://www.sitedorudolph.com/baixe-seu-template-campaignlaunch");

        webFlowResponseList.add(item1);
        webFlowResponseList.add(item2);
        webFlowResponseList.add(item3);
        webFlowResponseList.add(item4);
        webFlowResponseList.add(item5);

        webFlowResponseList.stream()
                .map(n -> n.getDescription())
                .forEach(System.out::println);

        return webFlowResponseList;
    }

    private String findMatchingKeywords(String pdfText, List<WebFlowResponse> keywords) {
        log.info("[start] ReciboServiceImpl = findMatchingKeywords");

        keywords.stream()
                .map(WebFlowResponse::getDescription)
                .forEach(System.out::println);

        System.out.println("================= INICIO TEXTO PDF ===================");
        System.out.println("String pdfText: " + pdfText);
        System.out.println("================= FIM TEXTO PDF ===================");


        System.out.println("================= INICIO FOUND MATCH ===================");
        String matchedItem = keywords.stream()
                .map(WebFlowResponse::getDescription)
                .filter(description -> pdfText.toLowerCase().contains(description.toLowerCase()))
                .peek(matched -> log.info("Found match: " + matched))
                .findFirst()
                .orElse("");
        System.out.println("================= FIM FOUND MATCH ===================");

        System.out.println("matchedItem: " + matchedItem);

        log.info("[finish] ReciboServiceImpl = findMatchingKeywords");
        return matchedItem;
    }

    private String extractPdfText(MultipartFile file){
        log.info("[start] ReciboServiceImpl - extractPdfText");
        String pdfText = "";
        try (PDDocument document = PDDocument.load(file.getInputStream())) {
            if(!document.isEncrypted()){
                PDFTextStripper textStripper = new PDFTextStripper();
                pdfText = textStripper.getText(document);
            } else {
                System.out.println("O arquivo está criptografado.");
            }
            document.close();
        } catch (IOException e) {
            System.err.println("Erro ao processar o PDF: " + e.getMessage());
        }
        log.info("[finish] ReciboServiceImpl - extractPdfText");
        return pdfText;
    }
}
