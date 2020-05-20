package com.mycompany.mystore.endpoint;

import com.mycompany.mystore.dto.Client;
import com.mycompany.mystore.service.ClientsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("clients")
public class ClientsEndpoint implements Clients {

    private final ClientsService clientsService;

    @Inject
    public ClientsEndpoint(@Nonnull ClientsService clientsService) {
        this.clientsService = requireNonNull(clientsService);
    }

    @Override
    @GetMapping("/{clientId}")
    public Client get(@Nonnull @PathVariable("clientId") long clientId) {
        return clientsService.getById(requireNonNull(clientId));
    }

    @Override
    @GetMapping("/all")
    public Set<Client> getAll() {
        return clientsService.getAll();
    }

    @Override
    @GetMapping("/{filter}")
    public Set<Client> getByName(@NotEmpty @PathVariable("filter") String filter) {
        return clientsService.getByFilter(requireNonNull(filter));
    }

}
