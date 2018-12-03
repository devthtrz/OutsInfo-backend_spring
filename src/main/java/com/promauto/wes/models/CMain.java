package com.promauto.wes.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "main")
public class CMain {
    @Id
    int idm;
    int pertype;
    Date    dtbeg;
    int wes;
    int swbeg;
    int swend;
    int wnum;
}
