package com.maap.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "image")
public class ImageEntity extends BaseAuditEntity {

	private static final long serialVersionUID = -6612762288260227887L;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "tooltip")
	private String tooltip;

	@Column(name = "order")
	private long order;
}
