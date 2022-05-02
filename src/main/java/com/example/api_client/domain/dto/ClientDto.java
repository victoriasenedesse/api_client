package com.example.api_client.domain.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    Long id;
    String cpf;
    String nome;
    String sexo;
    Date nascimento;  
}
