package com.maap.admin.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maap.admin.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Base implements Serializable {

    @JsonFormat(pattern = Constants.PATTERN_DATE_FORMAT)
    private Date createOn;
    private String createBy;

    @JsonFormat(pattern = Constants.PATTERN_DATE_FORMAT)
    private Date updateOn;
    private String updateBy;

}
