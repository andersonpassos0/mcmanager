package com.mastersystem.mcmanager.application.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberUpdateRequest {
    private Long id;
    private String nome;
    private LocalDate dtNasc;
    private String tipoSanguineo;
    private Long cep;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String pais;
    private Long telefone1;
    private Long telefone2;
    private String email;
    private Long cpf;
    private Long numHabilitacao;
    private String tipoHabilitacao;
    private LocalDate valHabilitacao;
    private Long estCivil;
}
