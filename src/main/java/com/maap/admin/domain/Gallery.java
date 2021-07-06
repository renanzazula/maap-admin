package com.maap.admin.domain;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Gallery extends Base implements Serializable {

    private static final long serialVersionUID = -6612762288260227887L;
    private UUID id;
    private String name;
    private String description;
    private List<Image> images;

}
