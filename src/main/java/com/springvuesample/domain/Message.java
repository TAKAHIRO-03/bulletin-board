package com.springvuesample.domain;

import java.sql.Timestamp;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

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
