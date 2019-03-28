package testapp.service;

import testapp.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> getAll();
    Message getById(long id);
}
