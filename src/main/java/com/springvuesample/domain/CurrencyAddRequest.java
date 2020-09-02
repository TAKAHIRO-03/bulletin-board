package com.springvuesample.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class CurrencyAddRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String symbol;

}