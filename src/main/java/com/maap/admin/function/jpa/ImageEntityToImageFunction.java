package com.maap.admin.function.jpa;

import com.maap.admin.domain.Image;
import com.maap.admin.entity.ImageEntity;

import java.util.function.Function;

public class ImageEntityToImageFunction implements Function<ImageEntity, Image> {

    @Override
    public Image apply(ImageEntity entity) {
        Image image = new Image();
        image.setId(entity.getId());
        image.setName(entity.getName());
        image.setDescription(entity.getDescription());
        image.setTooltip(entity.getTooltip());
        image.setSort(entity.getSort());
        image.setImage(image.getImage());
        return image;
    }
}
