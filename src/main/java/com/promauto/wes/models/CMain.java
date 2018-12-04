package com.promauto.wes.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@NamedQuery(name = "CMain.findByModuleName", query = "SELECT  idm, \n" +
        "    pertype\n" +
        "    FROM CMain p WHERE idm = (select idm from CModule where name = ?1)")
@Table(name = "main")
public class CMain {
    @Id
    int idm;
    int pertype;
//    Date    dtbeg;
//    int wes;
//    int swbeg;
//    int swend;
//    int wnum;
}
