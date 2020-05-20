package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.Client;
import com.mycompany.mystore.exceptions.NoClientsException;

import java.util.Set;

public interface ClientsService {

    Client getById(Long clientId);

    Set<Client> getAll();

    Set<Client> getByFilter(String filter);
}
