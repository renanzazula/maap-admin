package com.maap.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity(name = "gallery")
@EqualsAndHashCode(callSuper = false)
public @Data
class GalleryEntity extends BaseAuditEntity {

	private static final long serialVersionUID = 8469236650577098647L;

	@Column(name = "name")
	private String name;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "image_id")
	private ImageEntity image;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "produto_codigo")
	private Set<GalleryHasImageEntity> imageHasGallery;


}
