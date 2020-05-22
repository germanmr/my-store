package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.ClientDto;
import com.mycompany.mystore.exceptions.NoClientsFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@Service
public class DefaultClientService implements ClientService {

    //private final ClientRepository clientRepository;
    private final Set<ClientDto> clientDtos;

    @Inject
    public DefaultClientService() {
        //@Nonnull ClientRepository clientRepository
//        requireNonNull(clientRepository);
        //this.clientRepository = clientRepository;

        Set<ClientDto> clientDtos = new HashSet<>();
        clientDtos.add(new ClientDto(1, "German"));
        this.clientDtos = clientDtos;

    }

    @Override
    public ClientDto getById(@Nonnull Long clientId) {
        requireNonNull(clientId);

        ClientDto clientDto = null;
        clientDto = clientDtos.stream()
                .filter(cl -> cl.getId() == clientId)
                .findFirst()
                .orElseThrow(() -> new NoClientsFoundException());

        return clientDto;
    }

    @Override
    public Set<ClientDto> getAll() {
        return clientDtos;
    }

    @Override
    public Set<ClientDto> getByFilter(@Nonnull String filter) {
        requireNonNull(filter);

        clientDtos.stream()
                .findAny()
                .orElseThrow(() -> new NoClientsFoundException());

        return clientDtos;
    }

}
