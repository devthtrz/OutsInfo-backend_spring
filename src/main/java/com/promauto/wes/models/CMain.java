package com.promauto.wes.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
//@NamedQuery(name = "CMain.findByModuleName", query = "SELECT  idm, \n" +
//        "    pertype, wes \n" +
//        "    FROM CMain p WHERE idm = (select idm from CModule where name = ?1)")
@Table(name = "main")
public class CMain {

    @Id
    int idm;
    int pertype;
    Timestamp dtbeg;
    long wes;
    long swbeg;
    long swend;
    long wnum;
}
