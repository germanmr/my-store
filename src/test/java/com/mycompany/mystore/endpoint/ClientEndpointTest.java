package com.mycompany.mystore.endpoint;

import com.mycompany.mystore.dto.ClientDto;
import com.mycompany.mystore.service.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientEndpointTest {

    private static final long CLIENT_ID = 1;

    @InjectMocks
    private ClientEndpoint clientEndpoint;

    @Mock
    private ClientService clientService;

    @Test
    public void get() {

        ClientDto expected = new ClientDto(1, "German");

        when(clientService.getById(CLIENT_ID)).thenReturn(expected);

        ClientDto actual = clientEndpoint.get(CLIENT_ID);

        assertEquals(expected, actual);
    }

    @Test
    public void getAll() {

        Set<ClientDto> clientDtos = new HashSet<>();
        clientDtos.add(new ClientDto(CLIENT_ID, "German"));

        when(clientService.getAll()).thenReturn(clientDtos);

        Set<ClientDto> actuals = clientEndpoint.getAll();

        Set<ClientDto> expected = new HashSet<>();
        expected.add(new ClientDto(CLIENT_ID, "German"));

        assertEquals(expected, actuals);

    }

    //    @Test(expected = NullPointerException.class)
    public void getByNameException() {
// FIXME when we change the service implementation we should have change the Test!!!
//        String filter = null;
//
//        when(clientService.getByFilter(filter)).thenThrow(new NullPointerException());
//
//        Set<ClientDto> actual = clientEndpoint.getByName(filter);

    }


}
