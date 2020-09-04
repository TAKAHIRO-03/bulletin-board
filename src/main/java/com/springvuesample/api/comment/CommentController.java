package com.springvuesample.api.comment;

import javax.persistence.EntityNotFoundException;

import com.springvuesample.api.EmptyJsonBody;
import com.springvuesample.domain.Comment;
import com.springvuesample.service.CommentService;
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
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final UserService userService;
    private final MapperFactory mapperFactory;

    @GetMapping
    public ResponseEntity<?> findAll() {
        val comments = commentService.findAll();

        if(comments.isEmpty()){
            return new ResponseEntity<>(new EmptyJsonBody(), HttpStatus.OK);
        }

        val commentResponce = CommentResponce.builder().comments(comments).build();
        return new ResponseEntity<>(commentResponce, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable final Long id) {
        try {
            val comment = commentService.findById(id);
            val commentResponce = CommentResponce.builder().comment(comment).build();
            return new ResponseEntity<>(commentResponce, HttpStatus.OK);
        } catch (final IllegalArgumentException e) {
            return new ResponseEntity<>(new EmptyJsonBody(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody final CommentForm form) {
        val mapper = mapperFactory.getMapperFacade(CommentForm.class, Comment.class);
        val comment = mapper.map(form);
        val user = userService.getOne(form.getUserId());
        comment.setUser(user);
        this.commentService.create(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable final Long id, @RequestBody final CommentForm form) {

        try {
            val mapper = mapperFactory.getMapperFacade(CommentForm.class, Comment.class);
            this.commentService.update(id, mapper.map(form));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (final EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable final Long id) {
        this.commentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
