package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.ClientDto;
import com.mycompany.mystore.exceptions.NoClientsFoundException;
import com.mycompany.mystore.repository.ClientRepository;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@Service
public class DefaultClientService implements ClientService {

    private final ClientRepository clientRepository;
    private final Set<ClientDto> clientDtos;
    private final MyClientApi myClientApi;

    @Inject
    public DefaultClientService(
            @Nonnull MyClientApi myClientApi,
            @Nonnull ClientRepository clientRepository) {


        requireNonNull(clientRepository);
        this.clientRepository = clientRepository;

        requireNonNull(myClientApi);
        this.myClientApi = myClientApi;

        Set<ClientDto> clientDtos = new HashSet<>();
        clientDtos.add(new ClientDto(1, "German"));
        this.clientDtos = clientDtos;

    }

    @Override
    public ClientDto getById(@Nonnull Long clientId) {
        requireNonNull(clientId);


//        if (clientRepository != null) {
//            // We call redis!!!
//            Client client = clientRepository.findById(clientId).orElseThrow(NoClientFoundException::new);
//        }

        Call<ClientDto> call = myClientApi.get(clientId);
        try {
            Response<ClientDto> response = call.execute();
            ClientDto dto = response.body();

            System.out.println("response.isSuccessful(): " + response.isSuccessful());
            System.out.println("response.code(): " + response.code());
            System.out.println("dtoList: " + dto);

            return dto;

        } catch (IOException e) {
            e.printStackTrace();
        }

//        If the call fails we could bring info from the dummy Collection
        ClientDto dto = clientDtos.stream()
                .filter(cl -> cl.getId() == clientId)
                .findFirst()
                .orElseThrow(() -> new NoClientsFoundException());

        return dto;
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
