package com.promauto.wes.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Belyaev Alexei (lebllex) on 30.11.18.
 */
@Data
@Entity
@Table(name = "modules")
public class CModule {
    @Id
    int idm;
    int idmt;
    int idsl;
    String name;
    String descr;
    boolean enabled;
    String  svrname;
    int     arcvalsize;
    int     arcoutsize;
    int     arcoutper;
    int     arcouttime;
    int     wesparts;
    int     wmul;
    int     protocolvers;
    // and so on and so on
}
