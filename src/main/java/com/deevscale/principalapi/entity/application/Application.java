package com.deevscale.principalapi.entity.application;

import com.deevscale.principalapi.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "application")
public class Application extends BaseEntity {

    @Column(name = "name")
    private String name;


}
