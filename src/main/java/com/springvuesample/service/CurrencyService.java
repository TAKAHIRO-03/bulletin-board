package com.springvuesample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springvuesample.domain.Currency;
import com.springvuesample.repository.CurrencyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public List<Currency> findAll() {
        return this.currencyRepository.findAll();
    }

    public Currency save(String name, String symbol) {
        return this.currencyRepository.save(Currency.newCurrency(name, symbol));
    }

    public void delete(Long id) {
        this.currencyRepository.findById(id).ifPresent(currency -> currencyRepository.delete(currency));
    }

}