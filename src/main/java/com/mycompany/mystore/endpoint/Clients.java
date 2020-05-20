package com.mycompany.mystore.endpoint;

import com.mycompany.mystore.dto.Client;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

public interface Clients {

    Client get(@Nonnull @PathVariable("clientId") long clientId);

    Set<Client> getAll();

    Set<Client> getByName(@NotEmpty @PathVariable("filter") String filter);

}
