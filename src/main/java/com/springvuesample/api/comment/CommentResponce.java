package com.springvuesample.api.comment;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import com.springvuesample.domain.Comment;

@Getter
@Builder
public class CommentResponce {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Comment comment;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Comment> comments;

}