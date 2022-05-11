package com.example.api_client.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "endereco")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy="endereco")
    private Client cliente;

    @Column(name="cep")
    @NotBlank(message="CEP é obrigatório.")
    @Length(message="CEP inválido.",max=8, min=8)
    String cep;

    @Column(name="rua")
    @NotBlank(message="Rua é obrigatório")
    @Length(message="Ultapassou o limite máximo de 50 caracteres.",max=50)
    String rua;

    @Column(name="bairro")
    @NotBlank(message="Bairo é obrigatório.")
    @Length(message="Ultapassou o limite máximo de 50 caracteres.",max=50)
    String bairro;

    @Column(name="numero")
    //@NotBlank(message="Número é obrigatório.")
    Long numero;

    @Column(name="cidade")
    @NotBlank(message="Cidade é obrigatório.")
    @Length(message="Cidade inválido.")
    String cidade;

    @Column(name="uf")
    @NotBlank(message="UF é obrigatório.")
    @Length(message="UF inválido.",max=2, min=2)
    String uf;
}
