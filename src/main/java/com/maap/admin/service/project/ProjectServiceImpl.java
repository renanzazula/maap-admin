package com.maap.admin.service.project;


import com.maap.admin.domain.Image;
import com.maap.admin.domain.Project;
import com.maap.admin.entity.GalleryEntity;
import com.maap.admin.entity.ImageEntity;
import com.maap.admin.entity.ProjectEntity;
import com.maap.admin.enums.StatusEnum;
import com.maap.admin.function.JpaFunctions;
import com.maap.admin.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository repository;

    @Override
    public Project save(Project input) {
        ProjectEntity output = new ProjectEntity();
        output.setId(input.getId());
        output.setName(input.getName());
        output.setLocation(input.getLocation());
        output.setExplain(input.getExplain());
        output.setStatus(StatusEnum.valueOf(input.getStatus()));
        output.setImage(JpaFunctions.imageToImageEntityFunction.apply(input.getImage()));

        GalleryEntity galleryEntity = new GalleryEntity();
        galleryEntity.setName(input.getGallery().getName());
        galleryEntity.setDescription(input.getGallery().getDescription());
        if (input.getGallery().getImages() != null) {
            Set<ImageEntity> images = new HashSet<>();
            for (Image image : input.getGallery().getImages()) {
                images.add(JpaFunctions.imageToImageEntityFunction.apply(image));
            }
            galleryEntity.setImages(images);
        }
        output.setGallery(galleryEntity);

        output.setUser(JpaFunctions.userToUserEntityFunction.apply(input.getUser()));
        return JpaFunctions.projectEntityToProjectFunction.apply(repository.saveAndFlush(output));
    }

    @Override
    public Project update(UUID uuid, Project input) throws Exception {
        ProjectEntity found = repository.findById(uuid).orElseThrow(() -> new Exception("Project not found:" + uuid));
        found.setName(input.getName());
        found.setLocation(input.getLocation());
        found.setExplain(input.getExplain());
        found.setStatus(StatusEnum.valueOf(input.getStatus()));
        found.setImage(JpaFunctions.imageToImageEntityFunction.apply(input.getImage()));

        GalleryEntity galleryEntity = new GalleryEntity();
        galleryEntity.setName(input.getGallery().getName());
        galleryEntity.setDescription(input.getGallery().getDescription());
        if (input.getGallery().getImages() != null) {
            Set<ImageEntity> images = new HashSet<>();
            for (Image image : input.getGallery().getImages()) {
                images.add(JpaFunctions.imageToImageEntityFunction.apply(image));
            }
            galleryEntity.setImages(images);
        }
        found.setGallery(galleryEntity);
        found.setUser(JpaFunctions.userToUserEntityFunction.apply(input.getUser()));
        return JpaFunctions.projectEntityToProjectFunction.apply(repository.saveAndFlush(found));
    }

    @Override
    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(cacheNames = "projectListCache", condition = "#showInventoryOnHand == false")
    public List<Project> findAll() {
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(ProjectEntity::getId))
                .map(JpaFunctions.projectEntityToProjectFunction).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(cacheNames = "projectCache", key = "#id", condition = "#showInventoryOnHand == false")
    public Project getBy(UUID uuid) throws Exception {
        return JpaFunctions.projectEntityToProjectFunction.apply(repository.findById(uuid).orElseThrow(() -> new Exception("Project not found:" + uuid)));
    }

}
