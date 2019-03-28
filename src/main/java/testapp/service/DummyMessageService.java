package testapp.service;

import testapp.model.Message;

import java.util.*;

public class DummyMessageService implements MessageService {

    private static Map<Long, Message> messages;

    public DummyMessageService() {
        messages = new HashMap<Long, Message>();
        messages.put(1L, createMessage(1, "Hello, World!"));
        messages.put(2L, createMessage(2, "Dit is een mooie message!!"));
        messages.put(3L, createMessage(3, "PRAAAANK"));
    }

    public List<Message> getAll() {
        return new ArrayList<Message>(messages.values());
    }

    public Message getById(long id) {
        return messages.get(id);
    }

    private Message createMessage(long id, String content) {
        Message message = new Message();
        message.setId(id);
        message.setContent(content);

        return message;
    }
}
