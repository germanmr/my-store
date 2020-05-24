package com.mycompany.mystore.endpoint;

import com.mycompany.mystore.dto.ItemDto;
import com.mycompany.mystore.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemEndpointTest {

    private static final Integer ITEM_ID = Integer.parseInt("1");
    private static ItemDto itemDto = new ItemDto(ITEM_ID, "KEYBOARD", BigInteger.ZERO);

    @InjectMocks
    private ItemEndpoint itemsEndpoint;

    @Mock
    private ItemService itemService;

    @Test
    public void get() {

        ItemDto expected = itemDto;

        when(itemService.getById(ITEM_ID)).thenReturn(expected);

        ItemDto actual = itemsEndpoint.get(ITEM_ID);

        assertEquals(expected, actual);
    }

    @Test
    public void getAll() {

        Set<ItemDto> itemDtos = new HashSet<>();
        itemDtos.add(itemDto);

        when(itemService.getAll()).thenReturn(itemDtos);

        Set<ItemDto> actuals = itemsEndpoint.getAll();

        Set<ItemDto> expected = new HashSet<>();
        expected.add(itemDto);

        assertEquals(expected, actuals);

    }

    @Test(expected = NullPointerException.class)
    public void getByNameException() {

        String filter = null;

        when(requireNonNull(filter)).thenThrow(new NullPointerException());

        Set<ItemDto> actual = itemsEndpoint.getByName(filter);

    }

    //    @Test(expected = NoItemFoundException.class)
    public void getByNameNoItemFoundException() {
        // FIXME when we change the service implementation we should have change the Test!!!

//        when(itemService.getById(ITEM_ID)).thenThrow(new NoItemFoundException());
//
//        itemsEndpoint.get(ITEM_ID);

    }


}
