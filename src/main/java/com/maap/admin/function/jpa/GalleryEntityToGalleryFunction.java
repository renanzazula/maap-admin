package com.maap.admin.function.jpa;

import com.maap.admin.domain.Gallery;
import com.maap.admin.entity.GalleryEntity;
import com.maap.admin.function.JpaFunctions;

import java.util.function.Function;
import java.util.stream.Collectors;

public class GalleryEntityToGalleryFunction implements Function<GalleryEntity, Gallery> {

	@Override
	public Gallery apply(GalleryEntity input) {
		Gallery output = new Gallery();
		output.setId(input.getId());
		output.setName(input.getName());
		output.setDescription(input.getDescription());
		if (input.getImages() != null) {
			output.setImages(input.getImages().stream().map(JpaFunctions.imageEntityToImageFunction).collect(Collectors.toList()));
		}
		return output;
	}
}
