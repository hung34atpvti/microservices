package com.declan.customer.domain.customer.service;

import com.declan.customer.domain.customer.dto.CustomerRegistrationRequest;

public interface CustomerService {
    public void registerCustomer(CustomerRegistrationRequest request);
}
