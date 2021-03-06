package com.springvuesample.api.user;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import com.springvuesample.domain.Branch;
import com.springvuesample.domain.Department;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class UserForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String account;

	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private Branch branch;

	@Getter
	@Setter
	private Department department;

	private Integer isStopped;

	@Getter
	private final Timestamp createdDate = new Timestamp(System.currentTimeMillis());

	@Getter
	private final Timestamp updatedDate = new Timestamp(System.currentTimeMillis());

	public Integer getIsStopped() {
		if (Objects.isNull(this.isStopped)) {
			this.isStopped = 0;
		}
		return this.isStopped;
	}

	public void setStopped(Integer isStopped) {
		if (Objects.isNull(isStopped)) {
			this.isStopped = 0;
		}
		this.isStopped = isStopped;
	}

}