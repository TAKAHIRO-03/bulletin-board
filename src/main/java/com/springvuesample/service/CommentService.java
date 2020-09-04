package com.springvuesample.service;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.springvuesample.domain.Comment;
import com.springvuesample.repository.CommentRepository;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import lombok.RequiredArgsConstructor;
import lombok.val;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> findAll() {
        val comments = commentRepository.findAll();

        if (CollectionUtils.isEmpty(comments)) {
            return Collections.emptyList();
        }

        return comments;
    }

    public Comment findById(final String id) {
        return commentRepository.findById(StringToLongConverter.parseIdParam(id))
                .orElseThrow(IllegalArgumentException::new);
    }

    public void create(final Comment comment) {
        this.commentRepository.save(comment);
    }

    public void update(final String id, final Comment comment)
            throws EntityNotFoundException, IllegalArgumentException {
        val registedComment = this.commentRepository.getOne(StringToLongConverter.parseIdParam(id));
        registedComment.setText(comment.getText());
        registedComment.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        this.commentRepository.save(registedComment);
    }

    public void deleteById(final String id) {
        this.commentRepository.deleteById(StringToLongConverter.parseIdParam(id));
    }

}
