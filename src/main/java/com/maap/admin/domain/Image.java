package com.maap.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Image extends Base implements Serializable {

    private static final long serialVersionUID = -6612762288260227887L;
    private UUID id;
    private String name;
    private String description;
    private String tooltip;
    private long order;
}
