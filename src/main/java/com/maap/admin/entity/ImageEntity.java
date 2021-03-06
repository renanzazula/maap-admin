package com.maap.admin.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity(name = "image")
public @Data
class ImageEntity extends BaseAuditEntity {

	private static final long serialVersionUID = 8931981566704330072L;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "tooltip")
	private String tooltip;

	@Column(name = "order")
	private long order;
}
