package com.mycompany.mystore.endpoint;

import com.mycompany.mystore.dto.Client;
import com.mycompany.mystore.service.ClientsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AssociatedGuestsEndpointTest {

    private static final long CLIENT_ID = 1;

    @InjectMocks
    private ClientsEndpoint clientsEndpoint;

    @Mock
    private ClientsService clientsService;

    @Test
    public void get() {

        Client expected = new Client(1, "German");

        when(clientsService.getById(CLIENT_ID)).thenReturn(expected);

        Client actual = clientsEndpoint.get(CLIENT_ID);

        assertEquals(expected, actual);
    }

    @Test
    public void getAll() {

        Set<Client> clients = new HashSet<>();
        clients.add(new Client(CLIENT_ID, "German"));

        when(clientsService.getAll()).thenReturn(clients);

        Set<Client> actuals = clientsEndpoint.getAll();

        Set<Client> expected = new HashSet<>();
        expected.add(new Client(CLIENT_ID, "German"));

        assertEquals(expected, actuals);

    }

    @Test(expected = NullPointerException.class)
    public void getByNameException() {

        String filter = null;

        when(clientsService.getByFilter(filter)).thenThrow(new NullPointerException());

        Set<Client> actual = clientsEndpoint.getByName(filter);

    }


}
