package com.mastersystem.mcmanager.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Member {

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
