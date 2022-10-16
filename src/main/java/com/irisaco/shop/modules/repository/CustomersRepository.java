package com.irisaco.shop.modules.repository;

import com.irisaco.shop.modules.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers,Integer> {

}
