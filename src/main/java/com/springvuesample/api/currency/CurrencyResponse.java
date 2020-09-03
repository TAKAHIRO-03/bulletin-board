package com.springvuesample.api.currency;

import java.util.List;

import com.springvuesample.domain.Currency;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CurrencyResponse {

    private final List<Currency> currencies;

}