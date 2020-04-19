package com.hendisantika.moviereservation.controller;

import com.hendisantika.moviereservation.dto.CustomerDto;
import com.hendisantika.moviereservation.entity.Customer;
import com.hendisantika.moviereservation.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : movie-reservation
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 13/07/18
 * Time: 06.33
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public CustomerDto.Customer getCustomer(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return modelMapper.map(customer, CustomerDto.Customer.class);
    }
}