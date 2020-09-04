package com.springvuesample.api.message;

import javax.persistence.EntityNotFoundException;

import com.springvuesample.api.EmptyJsonBody;
import com.springvuesample.domain.Message;
import com.springvuesample.service.MessageService;
import com.springvuesample.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.val;
import ma.glasnost.orika.MapperFactory;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final UserService userService;
    private final MapperFactory mapperFactory;

    @GetMapping
    public ResponseEntity<?> findAll() {
        val messages = messageService.findAll();

        if(messages.isEmpty()){
            return new ResponseEntity<>(new EmptyJsonBody(), HttpStatus.OK);
        }

        val messageResponce = MessageResponce.builder().messages(messages).build();
        return new ResponseEntity<>(messageResponce, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable final Long id) {
        try {
            val message = messageService.findById(id);
            val messageResponce = MessageResponce.builder().message(message).build();
            return new ResponseEntity<>(messageResponce, HttpStatus.OK);
        } catch (final IllegalArgumentException e) {
            return new ResponseEntity<>(new EmptyJsonBody(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody final MessageForm form) {
        val mapper = mapperFactory.getMapperFacade(MessageForm.class, Message.class);
        val message = mapper.map(form);
        val user = userService.getOne(form.getUserId());
        message.setUser(user);

        this.messageService.create(message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable final Long id, @RequestBody final MessageForm form) {

        try {
            val mapper = mapperFactory.getMapperFacade(MessageForm.class, Message.class);
            this.messageService.update(id, mapper.map(form));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (final EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (final IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable final Long id) {
        this.messageService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
