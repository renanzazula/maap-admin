package com.maap.admin.function.jpa;

import com.maap.admin.domain.Project;
import com.maap.admin.entity.ProjectEntity;

import java.util.function.Function;

public class ProjectEntityToProjectFunction implements Function<ProjectEntity, Project> {


    @Override
    public Project apply(ProjectEntity projectEntity) {
        return null;
    }
}
