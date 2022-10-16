package com.irisaco.shop.modules.repository;

import com.irisaco.shop.modules.model.Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartsRepository extends JpaRepository<Carts,Integer> {

}
