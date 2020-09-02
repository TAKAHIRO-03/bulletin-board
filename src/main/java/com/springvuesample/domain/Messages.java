package com.springvuesample.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Messages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    private String title;

    private String text;
    
    private String category;
    
    private Integer userId;
    
    private Timestamp createdDate;

    private Timestamp updatedDate;
}
