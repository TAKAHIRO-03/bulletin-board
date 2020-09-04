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
public class CommentService extends TemplateService<Comment> {

    private final CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        val comments = commentRepository.findAll();

        if (CollectionUtils.isEmpty(comments)) {
            return Collections.emptyList();
        }

        return comments;
    }

    @Override
    public Comment findById(final Long id) {
        return commentRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void create(final Comment comment) {
        this.commentRepository.save(comment);
    }

    @Override
    public void update(final Long id, final Comment comment) throws EntityNotFoundException {
        val registedComment = this.commentRepository.getOne(id);
        registedComment.setText(comment.getText());
        registedComment.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        this.commentRepository.save(registedComment);
    }

    @Override
    public void deleteById(final Long id) {
        this.commentRepository.deleteById(id);
    }

    @Override
    public Comment getOne(final Long id) {
        return this.commentRepository.getOne(id);
    }

}
