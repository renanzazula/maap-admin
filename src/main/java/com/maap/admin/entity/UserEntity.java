package com.maap.admin.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity(name = "user")
public @Data
class UserEntity extends BaseAuditEntity {

    private static final long serialVersionUID = -4426098122215553995L;

    @NotNull
    @Column(name = "name")
    private String name;

}
