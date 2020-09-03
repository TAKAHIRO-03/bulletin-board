package com.springvuesample.api.user;

import java.io.Serializable;
import java.sql.Timestamp;

import com.springvuesample.domain.Branch;
import com.springvuesample.domain.Department;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String account;

	private String password;

	private String name;

	private Branch branch;

	private Department department;

	private Integer isStopped;

	private Timestamp createdDate;

	private Timestamp updatedDate;

}