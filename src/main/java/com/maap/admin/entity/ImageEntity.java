package com.maap.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Entity(name = "image")
@EqualsAndHashCode(callSuper = false)
public @Data
class ImageEntity extends BaseAuditEntity {

	private static final long serialVersionUID = -4168634534361959887L;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "tooltip")
	private String tooltip;

	@Column(name = "sort")
	private long sort;

	@Column(name = "image", nullable = false)
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] image;

}
