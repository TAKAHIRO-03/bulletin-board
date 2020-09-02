package com.springvuesample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springvuesample.domain.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}