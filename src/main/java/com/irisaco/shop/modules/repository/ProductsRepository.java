package com.irisaco.shop.modules.repository;

import com.irisaco.shop.modules.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer> {

}
