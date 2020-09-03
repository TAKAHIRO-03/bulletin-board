package com.springvuesample.api.currency;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyAddRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String symbol;

}