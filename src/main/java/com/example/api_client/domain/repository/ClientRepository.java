package com.example.api_client.domain.repository;

import com.example.api_client.domain.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client,Long>  {

    @Query("SELECT u FROM Client u WHERE u.nome = ?1 and u.cpf = ?2")
    Client findClientByNameAndCpf(String nome, String cpf);

}
