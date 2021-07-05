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

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image save(Image obj) {
        ImageEntity entity = imageRepository.saveAndFlush(JpaFunctions.imageToImageEntityFunction.apply(obj));
        return JpaFunctions.imageEntityToImageFunction.apply(entity);
    }

    @Override
    public Image update(UUID uuid, Image imgToUpdate) throws Exception {
        ImageEntity entity = imageRepository.findById(uuid).orElseThrow(() -> new Exception("Image not found:" + uuid));
        entity.setName(imgToUpdate.getName());
        entity.setDescription(imgToUpdate.getDescription());
        entity.setTooltip(imgToUpdate.getTooltip());
        entity.setSort(imgToUpdate.getSort());
        //missing byte array
        return JpaFunctions.imageEntityToImageFunction.apply(imageRepository.saveAndFlush(entity));
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
        return JpaFunctions.imageEntityToImageFunction.apply(imageRepository.findById(uuid).orElseThrow(() -> new Exception("Image not found:" + uuid)));
    }

}
