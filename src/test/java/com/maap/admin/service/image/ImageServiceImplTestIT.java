package com.maap.admin.service.image;

import com.maap.admin.BaseTest;
import com.maap.admin.domain.Image;
import com.maap.admin.repository.ImageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ImageServiceImplTestIT extends BaseTest {

    @Autowired
    private ImageRepository repository;
    private ImageService service;

    private UUID uuid;
    private Image image;

    @BeforeEach
    public void setUp() throws IOException {
        uuid = UUID.randomUUID();
        service = new ImageServiceImpl(repository);
        image = new Image();
        image.setName(NAME);
        image.setDescription(DESCRIPTION);
        image.setTooltip("tooltip");
        image.setSort(0);
        image.setImage(getImage());
    }

    @Test
    public void save() throws Exception {
        Image saved = service.save(image);
        assertNotNull(saved);

        Image found = service.getBy(saved.getId());
        assertEquals(found.getId(), saved.getId());
        assertEquals(found.getName(), saved.getName());
        assertEquals(found.getDescription(), saved.getDescription());
        assertEquals(found.getTooltip(), saved.getTooltip());
        assertEquals(found.getSort(), saved.getSort());
    }

    @Test
    public void update() throws Exception {
        Image saved = service.save(image);

        Image foundToUpdate = service.getBy(saved.getId());
        foundToUpdate.setName("name updated");
        foundToUpdate.setDescription("description updated");
        foundToUpdate.setTooltip("Tooltip updated");
        foundToUpdate.setSort(1);

        Image updated = service.update(saved.getId(), foundToUpdate);
        assertEquals(foundToUpdate.getId(), updated.getId());
        assertEquals(foundToUpdate.getName(), updated.getName());
        assertEquals(foundToUpdate.getDescription(), updated.getDescription());
        assertEquals(foundToUpdate.getTooltip(), updated.getTooltip());
        assertEquals(foundToUpdate.getSort(), updated.getSort());

    }

    @Test
    public void deleteById() {
        Image saved = service.save(image);
        assertNotNull(saved.getId());
        service.deleteById(saved.getId());
        Exception thrown = assertThrows(Exception.class, () -> service.getBy(saved.getId()), "Image not found:");
        assertTrue(thrown.getMessage().contains("Image not found:"));
    }

    @Test
    public void findAll() {
        service.save(image);
        List<Image> imageList = service.findAll();
        assertFalse(imageList.isEmpty());
    }

    @Test
    public void getBy() throws Exception {
        Image saved = service.save(image);
        Image image = service.getBy(saved.getId());
        assertNotNull(image);
    }

}