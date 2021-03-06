package com.maap.admin.function.jpa;

import com.maap.admin.domain.Gallery;
import com.maap.admin.entity.GalleryEntity;

import java.util.function.Function;

public class GalleryEntityToGalleryFunction implements Function<GalleryEntity, Gallery> {


	@Override
	public Gallery apply(GalleryEntity galleryEntity) {
		return null;
	}
}
