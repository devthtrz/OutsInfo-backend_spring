package com.promauto.wes.repository;

import com.promauto.wes.models.CMain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CMainRepository extends JpaRepository<CMain,String> {
//    @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
//    public List<Person> find(@Param("lastName") String lastName);
    List<CMain> findByName(String name);
    List<CMain> findByNameIgnoreCaseStartingWith(String name);
}
