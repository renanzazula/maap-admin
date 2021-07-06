package com.maap.admin.entity;


import com.maap.admin.enums.StatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "project")
@EqualsAndHashCode(callSuper = false)
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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "image_id", referencedColumnName = "id")
	private ImageEntity image;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gallery_id", referencedColumnName = "id")
	private GalleryEntity gallery;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity user;

}
