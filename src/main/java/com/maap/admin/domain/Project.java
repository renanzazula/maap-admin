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
