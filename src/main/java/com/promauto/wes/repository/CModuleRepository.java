package com.promauto.wes.repository;

import com.promauto.wes.models.CModule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Belyaev Alexei (lebllex) on 30.11.18.
 */
public interface CModuleRepository extends JpaRepository<CModule,String> {
    List<CModule> findByName(String name);
    List<CModule> findByNameIgnoreCaseStartingWith(String name);
}
