package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.Client;
import com.mycompany.mystore.exceptions.NoClientsException;
import com.mycompany.mystore.repository.ClientRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@Service
public class DefaultClientService implements ClientsService {

    private final ClientRepository clientRepository;
    private final Set<Client> clients;

    @Inject
    public DefaultClientService(@Nonnull ClientRepository clientRepository) {
        requireNonNull(clientRepository);
        this.clientRepository = clientRepository;

        Set<Client> clients = new HashSet<>();
        clients.add(new Client(1, "German"));
        this.clients = clients;

    }

    @Override
    public Client getById(@Nonnull Long clientId) {
        requireNonNull(clientId);

        Client client = null;
        client = clients.stream()
                .filter(cl -> cl.getId() == clientId)
                .findFirst()
                .orElseThrow(() -> new NoClientsException());

        return client;
    }

    @Override
    public Set<Client> getAll() {
        return clients;
    }

    @Override
    public Set<Client> getByFilter(@Nonnull String filter) {
        requireNonNull(filter);

        clients.stream()
                .findAny()
                .orElseThrow(() -> new NoClientsException());

        return clients;
    }

}
