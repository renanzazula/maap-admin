package com.maap.admin.function.jpa;

import com.maap.admin.domain.Image;
import com.maap.admin.entity.ImageEntity;

import java.util.function.Function;

public class ImageEntityToImageFunction implements Function<ImageEntity, Image> {


    @Override
    public Image apply(ImageEntity imageEntity) {
        return null;
    }
}
