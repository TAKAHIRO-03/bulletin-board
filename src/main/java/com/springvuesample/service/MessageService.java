package com.springvuesample.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.springvuesample.domain.Message;
import com.springvuesample.repository.MessageRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.val;

@Service
@RequiredArgsConstructor
public class MessageService extends TemplateService<Message> {

    private final MessageRepository messageRepository;

    @Override
    public List<Message> findAll() {
        return this.messageRepository.findAll();
    }

    @Override
    public Message findById(final Long id) {
        return this.messageRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void create(final Message message) {
        this.messageRepository.save(message);
    }

    @Override
    public void update(final Long id, final Message message) throws EntityNotFoundException {
        val registedMessage = this.messageRepository.getOne(id);
        registedMessage.setTitle(message.getTitle());
        registedMessage.setText(message.getText());
        registedMessage.setUpdatedDate(message.getUpdatedDate());
        this.messageRepository.save(registedMessage);
    }

    @Override
    public void deleteById(final Long id) {
        this.messageRepository.deleteById(id);
    }

    @Override
    public Message getOne(final Long id) throws EntityNotFoundException {
        return this.messageRepository.getOne(id);
    }

}
