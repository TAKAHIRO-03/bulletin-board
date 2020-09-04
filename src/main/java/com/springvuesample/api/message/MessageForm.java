package com.springvuesample.api.message;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class MessageForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String title;

	@Getter
	@Setter
	private String text;

	@Getter
	@Setter
	private String category;


	/**
	 * 
	 * セキュリティが未実装のため、一時的に3を詰める
	 * セキュリティ実装したら、ログイン情報をここに詰める
	 * 
	 */
	@Getter
	private final Integer userId = 3;

	@Getter
	private final Timestamp createdDate = new Timestamp(System.currentTimeMillis());

	@Getter
	private final Timestamp updatedDate = new Timestamp(System.currentTimeMillis());

}