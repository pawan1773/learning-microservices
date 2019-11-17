package com.learning.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.microservices.bean.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	ExchangeValue findByFromAndTo(String from, String to);
}
