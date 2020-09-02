package com.springvuesample.domain;

import lombok.Data;
import java.io.Serializable;

@Data
public class CurrencyAddRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String symbol;
	
}