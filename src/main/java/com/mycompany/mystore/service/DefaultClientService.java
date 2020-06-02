package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.ClientDto;
import com.mycompany.mystore.dto.StatusDto;
import com.mycompany.mystore.exceptions.NoClientFoundException;
import com.mycompany.mystore.exceptions.NoClientsFoundException;
import com.mycompany.mystore.model.Client;
import com.mycompany.mystore.repository.ClientRepository;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@Service
public class DefaultClientService implements ClientService {

    private final ClientRepository clientRepository;
    private final Set<ClientDto> clientDtos;
    //    private final ClientApi clientApi;
    //    @Autowired
//    private final EmployeeApi employeeApi;
    private final EmployeeApiRetrofit employeeApiRetrofit;


//    private final ResteasyConfiguration resteasyConfiguration;

    @Inject
    public DefaultClientService(@Nonnull EmployeeApiRetrofit employeeApiRetrofit, @Nonnull ClientRepository clientRepository) {

        requireNonNull(employeeApiRetrofit);
        this.employeeApiRetrofit = employeeApiRetrofit;
//        employeeApi = EmployeeServiceGenerator.createService(EmployeeApi.class);

        requireNonNull(clientRepository);
        this.clientRepository = clientRepository;

//        @Nonnull ClientApi clientApi,
//        requireNonNull(clientApi);
//        this.clientApi = clientApi;

//        requireNonNull(resteasyConfiguration);
//        this.resteasyConfiguration = resteasyConfiguration;

        Set<ClientDto> clientDtos = new HashSet<>();
        clientDtos.add(new ClientDto(1, "German"));
        this.clientDtos = clientDtos;

    }

    @Override
    public ClientDto getById(@Nonnull Long clientId) {
        requireNonNull(clientId);

//        ClientDto clientDto = null;
//        clientDto = clientDtos.stream()
//                .filter(cl -> cl.getId() == clientId)
//                .findFirst()
//                .orElseThrow(() -> new NoClientsFoundException());

//        ClientDto clientDto = clientApi.get(clientId);

        if (clientRepository != null) {
            // We call redis!!!
            Client client = clientRepository.findById(clientId).orElseThrow(NoClientFoundException::new);
        }

        Call<List<StatusDto>> listCall = employeeApiRetrofit.get("1");
        try {
            Response<List<StatusDto>> response = listCall.execute();
            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        }


        ClientDto clientDto = new ClientDto(1, "German");
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
