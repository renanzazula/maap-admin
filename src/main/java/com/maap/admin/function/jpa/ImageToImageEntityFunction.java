package com.maap.admin.function.jpa;

import com.maap.admin.domain.Image;
import com.maap.admin.entity.ImageEntity;

import java.util.function.Function;

public class ImageToImageEntityFunction implements Function<Image, ImageEntity> {

    @Override
    public ImageEntity apply(Image image) {
        ImageEntity entity = new ImageEntity();
        entity.setName(image.getName());
        entity.setDescription(image.getDescription());
        entity.setTooltip(image.getTooltip());
        entity.setSort(image.getSort());
        entity.setImage(image.getImage());
        return entity;
    }
}
