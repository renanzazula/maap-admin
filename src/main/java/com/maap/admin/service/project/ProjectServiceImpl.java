package com.maap.admin.service.project;


import com.maap.admin.domain.Project;
import com.maap.admin.entity.ProjectEntity;
import com.maap.admin.function.JpaFunctions;
import com.maap.admin.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void save(Project obj) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectRepository.save(projectEntity);
    }

    @Override
    public Project update(UUID uuid, Project objToUpdate) throws Exception {
        ProjectEntity projectEntity = projectRepository.findById(uuid).orElseThrow(() -> new Exception("Project not found:" + uuid.toString()));
        //TODO: set values from new obj
        return JpaFunctions.projectEntityToProjectFunction.apply(projectRepository.save(projectEntity));
    }

    @Override
    public void deleteById(UUID uuid) {
        projectRepository.deleteById(uuid);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(cacheNames = "projectListCache", condition = "#showInventoryOnHand == false")
    public List<Project> findAll() {
        return projectRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(ProjectEntity::getId))
                .map(JpaFunctions.projectEntityToProjectFunction).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(cacheNames = "projectCache", key = "#id", condition = "#showInventoryOnHand == false")
    public Project getBy(UUID uuid) throws Exception {
        return JpaFunctions.projectEntityToProjectFunction.apply(projectRepository.findById(uuid).orElseThrow(() -> new Exception("Project not found:")));
    }

}
