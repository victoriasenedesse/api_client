package com.example.api_client.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    Long id;
    String cep;
    String rua;
    String bairro;
    Long numero;
    String cidade;
    String uf;
}