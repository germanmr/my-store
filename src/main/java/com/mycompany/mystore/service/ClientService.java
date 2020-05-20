package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.ClientDto;

import java.util.Set;

public interface ClientService {

    ClientDto getById(Long clientId);

    Set<ClientDto> getAll();

    Set<ClientDto> getByFilter(String filter);
}
