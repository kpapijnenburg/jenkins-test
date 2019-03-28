package testapp.api.controllers;

import testapp.model.Message;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import testapp.service.MessageService;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MessageControllerTest {

    private MessageService service = mock(MessageService.class);
    private MessageController controller;

    @Before
    public void init() {
        controller = new MessageController(service);
    }

    @Test
    public void get_Returns200() {
        when(service.getAll()).thenReturn(Arrays.asList(new Message(), new Message()));

        ResponseEntity response = controller.get();

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void getById_noMessageFoundWithGivenId_returns404() {
        when(service.getById(any(Long.class))).thenReturn(null);

        ResponseEntity response = controller.getById(1);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void getById_messageFound_returns200() {
        when(service.getById(any(Long.class))).thenReturn(new Message());

        ResponseEntity response = controller.getById(1);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(Message.class, response.getBody().getClass());
    }
}