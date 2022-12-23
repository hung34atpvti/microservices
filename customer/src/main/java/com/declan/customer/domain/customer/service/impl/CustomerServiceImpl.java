package com.declan.customer.domain.customer.service.impl;

import com.declan.customer.domain.customer.dto.CustomerRegistrationRequest;
import com.declan.customer.domain.customer.dto.FraudCheckResponse;
import com.declan.customer.domain.customer.model.Customer;
import com.declan.customer.domain.customer.repository.CustomerRepository;
import com.declan.customer.domain.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    @Override
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        customerRepository.saveAndFlush(customer);
        // todo: check if fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
        if(fraudCheckResponse.getIsFraudster()) {
            throw new IllegalStateException("fraudster");
        }
        // todo: send notification
    }
}
