package com.coffeever.coffeever.repository;

import com.coffeever.coffeever.model.CoffeeBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeBeanRepository extends JpaRepository<CoffeeBean,String> {
}
