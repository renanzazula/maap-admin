package com.maap.admin.domain;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends Base implements Serializable {

    private UUID id;
    private String name;

}
