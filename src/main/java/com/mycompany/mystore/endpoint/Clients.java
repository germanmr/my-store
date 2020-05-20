package com.mycompany.mystore.endpoint;

import com.mycompany.mystore.dto.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

public interface Clients {

    @GetMapping("/{clientId}")
    Client get(@Nonnull @PathVariable("clientId") long clientId);

    @GetMapping("/all")
    Set<Client> getAll();

    @GetMapping("/{filter}")
    Set<Client> getByName(@NotEmpty @PathVariable("filter") String filter);

}
