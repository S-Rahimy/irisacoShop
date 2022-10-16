package com.irisaco.shop.modules.controller;

import com.irisaco.shop.modules.model.Customers;
import com.irisaco.shop.modules.service.CustomersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {
    private CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @RequestMapping(value={"/",""},method = RequestMethod.GET)
    public List<Customers> getAllCustomers(){
        return customersService.getAllCustomers();
    }

    @RequestMapping(value = {"/",""},method = RequestMethod.POST)
    public Integer addCustomer(@RequestBody Customers customers){
        return  customersService.addCustomer(customers);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Customers getCustomer(@PathVariable("id") Integer id){
        return  customersService.getCustomer(id);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public Integer editCustomer(@RequestBody Customers customers,@PathVariable("id") Integer id){
        Customers currentCustomer= customersService.getCustomer(id);
        if(currentCustomer.getId()==null)
            return 404;
        else{
            customersService.addCustomer(customers);
            return 200;
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Integer deleteCustomer(@PathVariable("id") Integer id){
        Customers currentCustomer=customersService.getCustomer(id);
        if(currentCustomer.getId()==null)
            return 404;
        else {
            customersService.deleteCustomer(id);
            return 200;
        }
    }
}