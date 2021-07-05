package com.maap.admin.domain;


import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Project extends Base implements Serializable {

    private static final long serialVersionUID = 3098936361791582953L;
    private UUID id;
    private String name;
    private String location;
    private Image image;
    private String explain;
    private String status;
    private Gallery gallery;
    private User user;
}
