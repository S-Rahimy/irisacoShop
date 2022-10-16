package com.irisaco.shop.modules.service;

import com.irisaco.shop.modules.model.Customers;
import com.irisaco.shop.modules.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {
    private CustomersRepository customersRepository;

    @Autowired
    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public List<Customers> getAllCustomers(){
        return this.customersRepository.findAll();
    }

    @Transactional
    public Integer addCustomer(Customers customers){
        return this.customersRepository.save(customers).getId();
    }

    public Customers getCustomer(Integer id){
        Optional<Customers> customers=customersRepository.findById(id);
        if(customers.isPresent())
            return customers.get();
        else
            return new Customers();
    }

    public void deleteCustomer(Integer id){
        customersRepository.deleteById(id);
    }
}
