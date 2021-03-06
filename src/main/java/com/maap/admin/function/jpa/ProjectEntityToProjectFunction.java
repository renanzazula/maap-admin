package com.maap.admin.function.jpa;

import com.maap.admin.domain.Project;
import com.maap.admin.entity.ProjectEntity;

import java.util.function.Function;

public class ProjectEntityToProjectFunction implements Function<ProjectEntity, Project> {


    @Override
    public Project apply(ProjectEntity projectEntity) {
        Project project = new Project();
        project.setId(projectEntity.getId());
        project.setName(projectEntity.getName());
        project.setLocation(projectEntity.getLocation());
        // project.setImage(projectEntity.getImage());     fixme:
        project.setExplain(projectEntity.getExplain());
        project.setStatus(projectEntity.getStatus().name());
        // project.setGallery(projectEntity.getGallery()); fixme:
        // project.setUser(projectEntity.getUser());       fixme:
        project.setCreateBy(projectEntity.getCreateBy());
        project.setCreateOn(projectEntity.getCreateOn());
        project.setUpdateBy(projectEntity.getUpdateBy());
        project.setUpdateOn(projectEntity.getUpdateOn());
        return project;
    }
}
