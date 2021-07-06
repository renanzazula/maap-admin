package com.maap.admin.service.gallery;

import com.maap.admin.domain.Gallery;
import com.maap.admin.domain.Image;
import com.maap.admin.entity.GalleryEntity;
import com.maap.admin.entity.ImageEntity;
import com.maap.admin.function.JpaFunctions;
import com.maap.admin.repository.GalleryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    @Override
    public Gallery save(Gallery gallery) {
        GalleryEntity galleryEntity = new GalleryEntity();
        galleryEntity.setName(gallery.getName());
        galleryEntity.setDescription(gallery.getDescription());
        if (gallery.getImages() != null) {
            Set<ImageEntity> images = new HashSet<>();
            for (Image image : gallery.getImages()) {
                images.add(JpaFunctions.imageToImageEntityFunction.apply(image));
            }
            galleryEntity.setImages(images);
        }
        return JpaFunctions.galleryEntityToGalleryFunction.apply(galleryRepository.saveAndFlush(galleryEntity));
    }

    @Override
    public Gallery update(UUID uuid, Gallery objToUpdate) throws Exception {
        GalleryEntity found = galleryRepository.findById(uuid).orElseThrow(() -> new Exception("Gallery not found:" + uuid));
        found.setName(objToUpdate.getName());
        found.setDescription(objToUpdate.getDescription());
        if (objToUpdate.getImages() != null) {
            Set<ImageEntity> images = new HashSet<>();
            for (Image image : objToUpdate.getImages()) {
                images.add(JpaFunctions.imageToImageEntityFunction.apply(image));
            }
            found.setImages(images);
        }
        return JpaFunctions.galleryEntityToGalleryFunction.apply(galleryRepository.saveAndFlush(found));
    }

    @Override
    public void deleteById(UUID uuid) {
        galleryRepository.deleteById(uuid);
    }

    @Override
    public List<Gallery> findAll() {
        return galleryRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(GalleryEntity::getId))
                .map(JpaFunctions.galleryEntityToGalleryFunction).collect(Collectors.toList());
    }

    @Override
    public Gallery getBy(UUID uuid) throws Exception {
        return JpaFunctions.galleryEntityToGalleryFunction.apply(galleryRepository.findById(uuid).orElseThrow(() -> new Exception("Gallery not found:" + uuid)));
    }
}
