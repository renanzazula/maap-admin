package com.maap.admin.service.gallery;

import com.maap.admin.BaseTest;
import com.maap.admin.domain.Gallery;
import com.maap.admin.domain.Image;
import com.maap.admin.repository.GalleryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GalleryServiceImplTestIT extends BaseTest {

    @Autowired
    private GalleryRepository repository;
    private GalleryService service;
    private Gallery gallery;


    @BeforeEach
    public void setUp() throws IOException {
        service = new GalleryServiceImpl(repository);
        gallery = new Gallery();
        gallery.setDescription(DESCRIPTION);

        List<Image> images = new ArrayList<>();
        images.add(newImage());
        images.add(newImage());
        images.add(newImage());
        images.add(newImage());
        gallery.setImages(images);

    }

    @Test
    public void save() throws Exception {
        Gallery saved = service.save(gallery);
        assertNotNull(saved);

        Gallery found = service.getBy(saved.getId());
        assertEquals(found.getId(), saved.getId());
        assertEquals(found.getName(), saved.getName());
        assertEquals(found.getDescription(), saved.getDescription());
        assertFalse(found.getImages().isEmpty());
    }

    @Test
    public void update() throws Exception {
        Gallery saved = service.save(gallery);

        Gallery foundToUpdate = service.getBy(saved.getId());
        foundToUpdate.setName("name updated");
        foundToUpdate.setDescription("description updated");

        Gallery updated = service.update(saved.getId(), foundToUpdate);
        assertEquals(foundToUpdate.getId(), updated.getId());
        assertEquals(foundToUpdate.getName(), updated.getName());
        assertEquals(foundToUpdate.getDescription(), updated.getDescription());


    }

    @Test
    public void deleteById() {
        Gallery saved = service.save(gallery);
        assertNotNull(saved.getId());
        service.deleteById(saved.getId());
        Exception thrown = assertThrows(Exception.class, () -> service.getBy(saved.getId()), "gallery not found:");
        assertTrue(thrown.getMessage().contains("gallery not found:"));
    }

    @Test
    public void findAll() {
        service.save(gallery);
        List<Gallery> galleryList = service.findAll();
        assertFalse(galleryList.isEmpty());
    }

    @Test
    public void getBy() throws Exception {
        Gallery saved = service.save(gallery);
        Gallery gallery = service.getBy(saved.getId());
        assertNotNull(gallery);
    }

}