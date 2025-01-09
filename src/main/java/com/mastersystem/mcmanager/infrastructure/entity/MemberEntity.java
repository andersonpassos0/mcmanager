package com.mastersystem.mcmanager.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mastersystem.mcmanager.application.dto.request.MemberUpdateRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CAD_MEMBRO")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOME", nullable = false)
    private String nome;
    @Column(name = "DT_NASC", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dtNasc;
    @Column(name = "TIPO_SANGUINEO", nullable = false)
    private String tipoSanguineo;
    @Column(name = "CEP", nullable = false)
    private Long cep;
    @Column(name = "ENDERECO", nullable = false)
    private String endereco;
    @Column(name = "BAIRRO", nullable = false)
    private String bairro;
    @Column(name = "CIDADE", nullable = false)
    private String cidade;
    @Column(name = "UF", nullable = false)
    private String uf;
    @Column(name = "PAIS", nullable = false)
    private String pais;
    @Column(name = "TELEFONE1", nullable = false)
    private Long telefone1;
    @Column(name = "TELEFONE2")
    private Long telefone2;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CPF", nullable = false)
    private Long cpf;
    @Column(name = "NUM_HABILITACAO")
    private Long numHabilitacao;
    @Column(name = "TIPO_HABILITACAO")
    private String tipoHabilitacao;
    @Column(name = "VAL_HABILITACAO")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate valHabilitacao;
    @Column(name = "EST_CIVIL", nullable = false)
    private Long estCivil;

    public MemberEntity updateEntity(MemberEntity updated){
        return new MemberEntity(
                this.id,
                updated.nome != null ? updated.nome : this.nome,
                updated.dtNasc != null ? updated.dtNasc : this.dtNasc,
                updated.tipoSanguineo != null ? updated.tipoSanguineo : this.tipoSanguineo,
                updated.cep != null ? updated.cep : this.cep,
                updated.endereco != null ? updated.endereco : this.endereco,
                updated.bairro != null ? updated.bairro : this.bairro,
                updated.cidade != null ? updated.cidade : this.cidade,
                updated.uf != null ? updated.uf : this.uf,
                updated.pais != null ? updated.pais : this.pais,
                updated.telefone1 != null ? updated.telefone1 : this.telefone1,
                updated.telefone2 != null ? updated.telefone2 : this.telefone2,
                updated.email != null ? updated.email : this.email,
                updated.cpf != null ? updated.cpf : this.cpf,
                updated.numHabilitacao != null ? updated.numHabilitacao : this.numHabilitacao,
                updated.tipoHabilitacao != null ? updated.tipoHabilitacao : this.tipoHabilitacao,
                updated.valHabilitacao != null ? updated.valHabilitacao : this.valHabilitacao,
                updated.estCivil != null ? updated.estCivil : this.estCivil
        );
    }
}

