package com.promauto.wes.repositories;

import com.promauto.wes.models.CMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CMainRepository extends JpaRepository<CMain,String> {

    @Query("SELECT  idm, \n" +
            "    pertype, wes \n" +
            "   FROM CMain p WHERE idm = (select idm from CModule where name = :modName)")
    public CMain findByModuleName(@Param("modName") String modName);

//    List<CMain> findAllById(String name);
//    List<CMain> findByNameIgnoreCaseStartingWith(String name);
}
