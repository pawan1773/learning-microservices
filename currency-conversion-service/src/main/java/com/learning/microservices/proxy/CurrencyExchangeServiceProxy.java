package com.learning.microservices.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.microservices.bean.CurrencyConversionBean;

// Before Ribbon Load balancer, we explicitly need to give url
// @FeignClient(name="currency-exchange-service", url="localhost:8000")
// After Ribbon Load balancer, we need not to give the url
// @FeignClient(name = "currency-exchange-service")
// Request will go through Zuul gateway
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	// @GetMapping("/currency-exchange/from/{from}/to/{to}")
	// The request will go through zuul gateway now
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to);

}
