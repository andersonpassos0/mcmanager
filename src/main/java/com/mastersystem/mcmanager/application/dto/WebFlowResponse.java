package com.mastersystem.mcmanager.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WebFlowResponse {
    private Long id;
    private String description;
    private String url;
}
