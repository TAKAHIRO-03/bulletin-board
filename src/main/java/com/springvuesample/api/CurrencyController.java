package com.springvuesample.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springvuesample.domain.CurrencyAddRequest;
import com.springvuesample.service.CurrencyService;

import lombok.RequiredArgsConstructor;
import lombok.val;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

	private final CurrencyService currencyService;

	@GetMapping("/")
	public ResponseEntity<CurrencyResponse> findAll() {

		val currencies = currencyService.findAll();
		val currencyResponse = CurrencyResponse.builder()
				.currencies(currencies)
				.build();
		return new ResponseEntity<>(currencyResponse, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<HttpStatus> save(@RequestBody CurrencyAddRequest request) {
		this.currencyService.save(request.getName(), request.getSymbol());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		this.currencyService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
