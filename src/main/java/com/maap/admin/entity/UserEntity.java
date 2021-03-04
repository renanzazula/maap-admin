package com.maap.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class UserEntity extends BaseAuditEntity implements Serializable {

    @NotNull
    @Column(name = "name")
    private String name;


}
