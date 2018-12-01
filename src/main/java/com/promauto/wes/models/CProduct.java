package com.promauto.wes.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "product")
public class CProduct {
    @Id
    int idprod;
    String name;
    String descr;
    int code;
}
