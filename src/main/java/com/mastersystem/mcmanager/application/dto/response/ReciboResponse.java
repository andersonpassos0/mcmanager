package com.mastersystem.mcmanager.application.dto.response;

import lombok.*;
import org.mapstruct.Mapping;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReciboResponse {
    private String name;
    private String url;
}
