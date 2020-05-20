package com.mycompany.mystore.endpoint;

import com.mycompany.mystore.dto.ClientDto;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

public interface Client {

    ClientDto get(@Nonnull long clientId);

    Set<ClientDto> getAll();

    Set<ClientDto> getByName(@NotEmpty String filter);

}
