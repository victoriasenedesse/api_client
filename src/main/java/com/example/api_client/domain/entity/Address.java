package com.example.api_client.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "endereco")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private Client cliente;

    @Column(name="cep")
    @NotBlank(message = "CEP é obrigatório.")
    @Length(message="CEP inválido.",max=8, min=8)
    Long cep;

    @Column(name="rua")
    @NotBlank(message = "Rua é obrigatório")
    @Length(message="Ultapassou o limite máximo de 50 caracteres.",max=50)
    String rua;

    @Column(name="bairro")
    @NotBlank(message = "Bairo é obrigatório.")
    @Length(message="Ultapassou o limite máximo de 50 caracteres.",max=50)
    String bairro;

    @Column(name="numero")
    @NotBlank(message = "Número é obrigatório.")
    Long numero;

    @Column(name="cidade")
    @NotBlank(message = "Cidade é obrigatório.")
    @Length(message="Cidade inválido.",max=2, min=2)
    String cidade;

    @Column(name="uf")
    @NotBlank(message = "UF é obrigatório.")
    @Length(message="UF inválido.",max=2, min=2)
    String uf;

    public void setCliente(Client client) {
        this.cliente = client;
    }
}
