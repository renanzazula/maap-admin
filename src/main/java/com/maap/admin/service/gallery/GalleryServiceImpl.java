package com.maap.admin.service.gallery;

import com.maap.admin.domain.Gallery;
import com.maap.admin.entity.GalleryEntity;
import com.maap.admin.function.JpaFunctions;
import com.maap.admin.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    @Override
    public void save(Gallery obj) {
        GalleryEntity galleryEntity = new GalleryEntity();
        galleryRepository.save(galleryEntity);
    }

    @Override
    public Gallery update(UUID uuid, Gallery objToUpdate) throws Exception {
        GalleryEntity galleryEntity = galleryRepository.findById(uuid).orElseThrow(() -> new Exception("Gallery not found:" + uuid.toString()));
        //TODO: set values from new obj
        return JpaFunctions.galleryEntityToGalleryFunction.apply(galleryRepository.save(galleryEntity));
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
        return JpaFunctions.galleryEntityToGalleryFunction.apply(galleryRepository.findById(uuid).orElseThrow(() -> new Exception("Gallery not found:")));
    }
}
