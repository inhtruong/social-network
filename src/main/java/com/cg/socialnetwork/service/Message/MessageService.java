package com.cg.socialnetwork.service.message;//package com.cg.service.Message;
//

import com.cg.socialnetwork.model.Message;
import com.cg.socialnetwork.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService implements IMessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Iterable<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Optional<Message> findById(long id) {
        return messageRepository.findById(id);
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void deleteById(long id) {
        messageRepository.deleteById(id);
    }
}
