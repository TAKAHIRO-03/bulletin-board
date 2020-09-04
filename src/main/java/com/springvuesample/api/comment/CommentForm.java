package com.springvuesample.api.comment;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class CommentForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String text;

	@Getter
	private final long userId = 3;

	@Getter
	@Setter
	private Integer messageId;

	@Getter
	private final Timestamp createdDate = new Timestamp(System.currentTimeMillis());

	@Getter
	private final Timestamp updatedDate = new Timestamp(System.currentTimeMillis());

}