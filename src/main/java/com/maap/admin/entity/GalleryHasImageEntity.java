package com.maap.admin.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name = "gallery_has_images")
public @Data
class GalleryHasImageEntity extends BaseAuditEntity {

    private static final long serialVersionUID = -6612762288260227887L;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gallery_id")
    private GalleryEntity gallery;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private ImageEntity image;

}
