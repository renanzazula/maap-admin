package com.maap.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
public class AuditEntity implements Serializable {

    @Version
    @Column(name = "version")
    private Long version;

    @CreatedBy
    @Column(name = "createBy", insertable = true, updatable = false)
    private String createBy;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "createOn", updatable = false)
    private Date createOn;

    @CreationTimestamp
    @Temporal(TemporalType.TIME)
    @Column(name = "createOnTime", updatable = false)
    private Date createOnTime;

    @LastModifiedBy
    @Column(name = "updateBy")
    private String updateBy;

    @LastModifiedDate
    @Temporal(TemporalType.DATE)
    @Column(name = "updateOn")
    private Date updateOn;

    @LastModifiedDate
    @Temporal(TemporalType.TIME)
    @Column(name = "updateOnTime")
    private Date updateOnTime;

}
