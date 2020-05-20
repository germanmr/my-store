package com.mycompany.mystore.endpoint;

import com.mycompany.mystore.dto.ClientDto;
import com.mycompany.mystore.service.ClientService;
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
@RequestMapping("item")
public class ItemsEndpoint implements Client {

    private final ClientService clientService;

    @Inject
    public ItemsEndpoint(@Nonnull ClientService clientService) {
        this.clientService = requireNonNull(clientService);
    }

    @Override
    @GetMapping("/{clientId}")
    public ClientDto get(@Nonnull @PathVariable("clientId") long clientId) {
        return clientService.getById(requireNonNull(clientId));
    }

    @Override
    @GetMapping("/all")
    public Set<ClientDto> getAll() {
        return clientService.getAll();
    }

    @Override
    @GetMapping("/filter/{filter}")
    public Set<ClientDto> getByName(@NotEmpty @PathVariable("filter") String filter) {
        return clientService.getByFilter(requireNonNull(filter));
    }

}
