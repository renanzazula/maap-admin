package com.maap.admin.service.image;

import com.maap.admin.domain.Image;
import com.maap.admin.entity.ImageEntity;
import com.maap.admin.function.JpaFunctions;
import com.maap.admin.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void save(Image obj) {
        ImageEntity imageEntity = new ImageEntity();
        imageRepository.save(imageEntity);
    }

    @Override
    public Image update(UUID uuid, Image objToUpdate) throws Exception {
        ImageEntity imageEntity = imageRepository.findById(uuid).orElseThrow(() -> new Exception("Image not found:" + uuid.toString()));
        //TODO: set values from new obj
        return JpaFunctions.imageEntityToImageFunction.apply(imageRepository.save(imageEntity));
    }

    @Override
    public void deleteById(UUID uuid) {
        imageRepository.deleteById(uuid);
    }

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(ImageEntity::getId))
                .map(JpaFunctions.imageEntityToImageFunction).collect(Collectors.toList());
    }

    @Override
    public Image getBy(UUID uuid) throws Exception {
        return JpaFunctions.imageEntityToImageFunction.apply(imageRepository.findById(uuid).orElseThrow(() -> new Exception("Image not found:")));
    }

}
