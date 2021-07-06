package com.maap.admin.function.jpa;

import com.maap.admin.domain.Project;
import com.maap.admin.entity.ProjectEntity;
import com.maap.admin.function.JpaFunctions;

import java.util.function.Function;

public class ProjectEntityToProjectFunction implements Function<ProjectEntity, Project> {


    @Override
    public Project apply(ProjectEntity input) {
        Project output = new Project();
        output.setId(input.getId());
        output.setName(input.getName());
        output.setLocation(input.getLocation());

        if (input.getImage() != null) {
            output.setImage(JpaFunctions.imageEntityToImageFunction.apply(input.getImage()));
        }

        output.setExplain(input.getExplain());
        output.setStatus(input.getStatus().name());

        if (input.getGallery() != null) {
            output.setGallery(JpaFunctions.galleryEntityToGalleryFunction.apply(input.getGallery()));
        }

        if (input.getUser() != null) {
            output.setUser(JpaFunctions.userEntityToUserFunction.apply(input.getUser()));
        }

        output.setCreateBy(input.getCreateBy());
        output.setCreateOn(input.getCreateOn());
        output.setUpdateBy(input.getUpdateBy());
        output.setUpdateOn(input.getUpdateOn());
        return output;
    }
}
