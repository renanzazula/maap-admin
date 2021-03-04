package com.maap.admin.entity;


import com.maap.admin.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "project")
public class ProjectEntity extends BaseAuditEntity {

	private static final long serialVersionUID = 3098936361791582953L;

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

	@NotNull
	@Column(name = "user")
	private UserEntity userEntity;

	// private ImageEntity imageEntity;
	// private GalleryEntity galleryEntity;

}
