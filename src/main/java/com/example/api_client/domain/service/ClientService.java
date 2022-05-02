package com.example.api_client.domain.service;

import java.util.List;
import java.util.stream.Collectors;
import com.example.api_client.domain.dto.ResponseDto;
import com.example.api_client.domain.dto.ClientDto;
import com.example.api_client.domain.entity.Client;
import com.example.api_client.domain.enumeration.Status;
import com.example.api_client.domain.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDto responseDto;

    ClientRepository clientRepository;

    public ResponseDto saveClient(Client client) {
        responseDto.setId(clientRepository.save(client).getId());
        responseDto.setMenssage("Cliente incluído com sucesso...");
        responseDto.setStatus(Status.SUCCESS.value());
        return responseDto;
    }

    public List<ClientDto> getAllClient() {
        List<ClientDto> listAllClientDto = clientRepository.findAll().stream()
                .map(Client -> modelMapper.map(Client, ClientDto.class))
                .collect(Collectors.toList());
        return listAllClientDto;
    }

    public List<ClientDto> getAllClientOrderByName() {
        List<ClientDto> listAllClientDto = clientRepository.findAll(Sort.by(Sort.Direction.ASC, "nome")).stream()
                .map(Client -> modelMapper.map(Client, ClientDto.class))
                .collect(Collectors.toList());
        return listAllClientDto;
    }

    public ClientDto getClientById(Long id) {
        return modelMapper.map(clientRepository.findById(id).get(), ClientDto.class);
    }

    public ResponseDto updateClient(Long id, Client client) {
        
        Optional<Client> optional = clientRepository.findById(id);
        
        if (optional.isEmpty()) {
            responseDto.setMenssage("Cliente inexistente...");
            responseDto.setStatus(Status.NOT_FOUND.value());
        } else {
            responseDto.setId(clientRepository.save(client).getId());
            if (client.getId() > 0) {
                clientRepository.save(client);
                responseDto.setMenssage("Cliente alterado com sucesso...");
                responseDto.setStatus(Status.SUCCESS.value());
            } else {
                responseDto.setMenssage("ID do Cliente inválido...");
                responseDto.setStatus(Status.ERROR.value());
            }
        }
        return responseDto;
    }

    public ResponseDto deleteClient(Long id) {
        responseDto.setId(id);
        if (id > 0) {
            clientRepository.deleteById(id);
            responseDto.setMenssage("Cliente deletado com sucesso...");
            responseDto.setStatus(Status.SUCCESS.value());
        } else {
            responseDto.setMenssage("ID do Cliente inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }

    public ClientDto validate(String nome, String cpf) {
        return modelMapper.map(clientRepository.findClientByNameAndCpf(nome, cpf), ClientDto.class);
    }

}
