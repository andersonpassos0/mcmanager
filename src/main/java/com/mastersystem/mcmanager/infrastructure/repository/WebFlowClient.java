package com.mastersystem.mcmanager.infrastructure.repository;

import com.mastersystem.mcmanager.application.dto.WebFlowResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "webflow", url = "https://api.webflow.com/v2/sites")
public interface WebFlowClient {

    @GetMapping
    List<WebFlowResponse> getKeywords(@RequestHeader("Authorization") String authorization);
}
