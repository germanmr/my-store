package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.ClientDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.util.AssertionErrors.assertEquals;

//@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringRunner.class)
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultClientServiceTest {

    private static final long CLIENT_ID = 1;

    //    @InjectMocks
    @Autowired
    private DefaultClientService clientService;

    //    @Mock
    @Autowired
    private EmployeeApiRetrofit employeeRetrofitApi;

    @Test
    public void get() {

        ClientDto expected = new ClientDto(1, "German");

//        when(clientService.getById(CLIENT_ID)).thenReturn(expected);

        ClientDto actual = clientService.getById(CLIENT_ID);

        assertEquals("They don´t match!", expected, actual);
    }


}
