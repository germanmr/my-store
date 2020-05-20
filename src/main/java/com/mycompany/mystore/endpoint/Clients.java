package com.mycompany.mystore.endpoint;

import com.mycompany.mystore.dto.Client;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

public interface Clients {

    Client get(@Nonnull long clientId);

    Set<Client> getAll();

    Set<Client> getByName(@NotEmpty String filter);

}
