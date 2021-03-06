package com.maap.admin.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "gallery")
public @Data
class GalleryEntity extends BaseAuditEntity {

	private static final long serialVersionUID = 8469236650577098647L;

	@Column(name = "name")
	private String name;

	//private List<ImageEntity> imageEntities;

}
