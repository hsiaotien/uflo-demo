package com.coinceres.uflodemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEMO")
public class Demo {

    @Id
    @Column(name = "ID_",length = 60)
    private String id;

    @Column(name = "NAME_",length = 60)
    private String name;

    @Column(name = "DESC_",length = 60)
    private String desc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
