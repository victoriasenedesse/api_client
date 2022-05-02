package com.example.api_client.controller;

import java.util.List;
import javax.validation.Valid;

import com.example.api_client.domain.dto.ClientDto;
import com.example.api_client.domain.dto.ResponseDto;
import com.example.api_client.domain.entity.Client;
import com.example.api_client.domain.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {

  @Autowired
  private ClientService clientService;


  @PostMapping //http://localhost:8080/client/
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseDto saveClient(@Valid @RequestBody Client client) {
    return clientService.saveClient(client);
  }

  @GetMapping(value = "/list") // http://localhost:8080/client/list
  public List<ClientDto> getAllClient() {
    return clientService.getAllClientOrderByName();
  }

  @GetMapping(value = "/{id}")
  public ClientDto getClientById(@Valid @PathVariable Long id) {
    return clientService.getClientById(id);
  }

  @PutMapping(value = "/{id}")
  public ResponseDto updateClient(@PathVariable Long id , @Valid @RequestBody Client client) {
      return clientService.updateClient(id, client);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseDto deleteClient(@Valid @PathVariable Long id) {
    return clientService.deleteClient(id);
  }

  @PostMapping(value = "/validar/{nome}/{cpf}")
  public ClientDto validate(@Valid @PathVariable String nome, @PathVariable String cpf) {
    return clientService.validate(nome, cpf);
  }
}