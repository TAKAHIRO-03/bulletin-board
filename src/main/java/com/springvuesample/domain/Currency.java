package com.springvuesample.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.val;

@Entity
@Data
public class Currency implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** 仮想通貨名 */
	private String name;

	/** シンボル */
	private String symbol;

	/** 数量 */
	private BigDecimal amount;

	public static Currency newCurrency(String name, String symbol) {
		val currency = new Currency();
		currency.name = name;
		currency.symbol = symbol;
		currency.amount = BigDecimal.ZERO;
		return currency;
	}
}
