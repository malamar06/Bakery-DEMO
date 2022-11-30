package com.shops.bakery.BakeryProducts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BakeryProductsRepository extends JpaRepository<BakeryProducts,Integer> {

    //@Query ("SELECT s FROM BakeryProducts s WHERE s.name = ?1")
    // this is what the down written functions is doing. Not exactly but so says AMIGOS.
    Optional<BakeryProducts> findBakeryProductsByName(String name);

    @Query(nativeQuery = true, value="SELECT * FROM BakeryProducts b WHERE b.price > ?1")
    List<BakeryProducts> findByPricemorethan(Double price);

}
