package com.springvuesample.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class UserBranchDepartment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String account;

	private String password;

	private String name;

	private String branch;

	private String department;

	private Integer branchId;

	private Integer departmentId;

	private Integer isStopped;

	private Timestamp createdDate;

	private Timestamp updatedDate;

}
