package testapp.api.controllers;

import testapp.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import testapp.service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private MessageService service;

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable long id) {
        Message message = service.getById(id);

        if (message == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(message);
    }
}
