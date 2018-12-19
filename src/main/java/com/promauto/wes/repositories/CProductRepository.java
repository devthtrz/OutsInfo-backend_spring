package com.promauto.wes.repositories;


import com.promauto.wes.models.CProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CProductRepository extends JpaRepository<CProduct,String> {
    List<CProduct> findByName(String name);
    List<CProduct> findByNameIgnoreCaseStartingWith(String name);
}
