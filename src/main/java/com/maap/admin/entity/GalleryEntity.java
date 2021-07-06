package com.maap.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "gallery")
@EqualsAndHashCode(callSuper = false)
public @Data
class GalleryEntity extends BaseAuditEntity {

	private static final long serialVersionUID = 8469236650577098647L;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ImageEntity> images;

}
