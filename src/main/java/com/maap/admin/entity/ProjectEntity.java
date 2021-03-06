package com.maap.admin.entity;


import com.maap.admin.enums.StatusEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Entity(name = "project")
public @Data
class ProjectEntity extends BaseAuditEntity {

	private static final long serialVersionUID = 1830958044628679550L;

	@Column(name = "name")
	private String name;

	@Column(name = "location")
	private String location;

	@Column(name = "explain")
	private String explain;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private StatusEnum status;

	// @NotNull
	//@JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false)
	// private UserEntity user;

	// private ImageEntity imageEntity;
	// private GalleryEntity galleryEntity;

}
