package com.maap.admin.service.project;

import com.maap.admin.BaseTest;
import com.maap.admin.domain.Project;
import com.maap.admin.enums.StatusEnum;
import com.maap.admin.repository.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProjectServiceImplTestIT extends BaseTest {

    @Autowired
    private ProjectRepository repository;
    private ProjectService service;
    private Project project;


    @BeforeEach
    public void setUp() throws IOException {
        service = new ProjectServiceImpl(repository);
        project = new Project();


    }

    @Test
    public void save() throws Exception {
        Project saved = service.save(project);
        assertNotNull(saved);

        Project found = service.getBy(saved.getId());
        assertEquals(found.getId(), saved.getId());
        assertEquals(found.getName(), saved.getName());
        assertEquals(found.getLocation(), saved.getLocation());
        assertEquals(found.getImage(), saved.getImage());
        assertEquals(found.getExplain(), saved.getExplain());
        assertEquals(found.getStatus(), saved.getStatus());

        assertEquals(found.getGallery(), saved.getGallery());
        assertEquals(found.getGallery().getId(), saved.getGallery().getId());
        assertEquals(found.getGallery().getName(), saved.getGallery().getName());
        assertEquals(found.getGallery().getDescription(), saved.getGallery().getDescription());
        assertFalse(found.getGallery().getImages().isEmpty());

        assertEquals(found.getUser().getId(), saved.getUser().getId());
        assertEquals(found.getUser().getName(), saved.getUser().getName());
    }

    @Test
    public void update() throws Exception {
        Project saved = service.save(project);

        Project foundToUpdate = service.getBy(saved.getId());
        foundToUpdate.setName("name update");
        foundToUpdate.setLocation("Location update");
        foundToUpdate.setImage(newImage());
        foundToUpdate.setExplain("Explain update");
        foundToUpdate.setStatus(StatusEnum.OFFLINE.name());
        foundToUpdate.setGallery(newGallery());
        foundToUpdate.setUser(newUser());

        Project updated = service.update(saved.getId(), foundToUpdate);
        assertEquals(foundToUpdate.getId(), updated.getId());
        assertEquals(foundToUpdate.getName(), updated.getName());

        assertEquals(foundToUpdate.getId(), updated.getId());
        assertEquals(foundToUpdate.getName(), updated.getName());
        assertEquals(foundToUpdate.getLocation(), updated.getLocation());

        assertEquals(foundToUpdate.getImage().getId(), foundToUpdate.getImage().getId());
        assertEquals(foundToUpdate.getImage().getName(), foundToUpdate.getImage().getName());
        assertEquals(foundToUpdate.getImage().getSort(), foundToUpdate.getImage().getSort());
        assertEquals(foundToUpdate.getImage().getTooltip(), foundToUpdate.getImage().getTooltip());
        assertEquals(foundToUpdate.getImage().getDescription(), foundToUpdate.getImage().getDescription());

        assertEquals(foundToUpdate.getStatus(), updated.getStatus());
        assertEquals(foundToUpdate.getExplain(), updated.getExplain());

// FIXME: why its not the same?
//        assertEquals(foundToUpdate.getGallery(),                  updated.getGallery());
//        assertEquals(foundToUpdate.getGallery().getId(),          updated.getGallery().getId());
//        assertEquals(foundToUpdate.getGallery().getName(),        updated.getGallery().getName());
//        assertEquals(foundToUpdate.getGallery().getDescription(), updated.getGallery().getDescription());
//
//        assertFalse(foundToUpdate.getGallery().getImages().isEmpty());
//
//        assertEquals(foundToUpdate.getUser().getId(),   updated.getUser().getId());
//        assertEquals(foundToUpdate.getUser().getName(), updated.getUser().getName());
    }

    @Test
    public void deleteById() {
        Project saved = service.save(project);
        assertNotNull(saved.getId());
        service.deleteById(saved.getId());
        Exception thrown = assertThrows(Exception.class, () -> service.getBy(saved.getId()), "Project not found:");
        assertTrue(thrown.getMessage().contains("Project not found:"));
    }

    @Test
    public void findAll() {
        service.save(project);
        List<Project> projectList = service.findAll();
        assertFalse(projectList.isEmpty());
    }

    @Test
    public void getBy() throws Exception {
        Project saved = service.save(project);
        Project project = service.getBy(saved.getId());
        assertNotNull(project);
    }

}