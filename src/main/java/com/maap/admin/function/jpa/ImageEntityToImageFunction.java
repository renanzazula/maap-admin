package com.maap.admin.function.jpa;

import com.maap.admin.domain.Image;
import com.maap.admin.entity.ImageEntity;

import java.util.function.Function;

public class ImageEntityToImageFunction implements Function<ImageEntity, Image> {

    @Override
    public Image apply(ImageEntity input) {
        Image output = new Image();
        output.setId(input.getId());
        output.setName(input.getName());
        output.setDescription(input.getDescription());
        output.setTooltip(input.getTooltip());
        output.setSort(input.getSort());
        output.setImage(output.getImage());
        return output;
    }
}
