package com.springvuesample.service;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.springvuesample.domain.Message;
import com.springvuesample.repository.MessageRepository;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import lombok.RequiredArgsConstructor;
import lombok.val;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public List<Message> findAll() {
        val messages = messageRepository.findAll();

        if (CollectionUtils.isEmpty(messages)) {
            return Collections.emptyList();
        }

        return messages;
    }

    public Message findById(final String id) {
        return messageRepository.findById(StringToLongConverter.parseIdParam(id))
                .orElseThrow(IllegalArgumentException::new);
    }

    public void create(final Message message) {
        this.messageRepository.save(message);
    }

    public void update(final String id, final Message message)
            throws EntityNotFoundException, IllegalArgumentException {
        val registedMessage = this.messageRepository.getOne(StringToLongConverter.parseIdParam(id));
        registedMessage.setTitle(message.getTitle());
        registedMessage.setText(message.getText());
        registedMessage.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        this.messageRepository.save(registedMessage);
    }

    public void deleteById(final String id) {
        this.messageRepository.deleteById(StringToLongConverter.parseIdParam(id));
    }

}
