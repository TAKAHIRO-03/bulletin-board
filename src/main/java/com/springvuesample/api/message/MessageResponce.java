package com.springvuesample.api.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import com.springvuesample.domain.Message;

@Getter
@Builder
public class MessageResponce {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Message message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Message> messages;

}