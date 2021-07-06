package com.maap.admin;

import com.maap.admin.domain.Gallery;
import com.maap.admin.domain.Image;
import com.maap.admin.domain.User;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BaseTest {

    public static final String NAME = "name";
    public static final String DESCRIPTION = "Description";

    protected Image newImage() throws IOException {
        Image image = new Image();
        image.setName(NAME);
        image.setDescription(DESCRIPTION);
        image.setTooltip("tooltip");
        image.setSort(0);
        image.setImage(getImage());
        return image;
    }

    protected Gallery newGallery() throws IOException {
        Gallery gallery = new Gallery();
        gallery.setDescription(DESCRIPTION);

        List<Image> images = new ArrayList<>();
        images.add(newImage());
        images.add(newImage());
        images.add(newImage());
        images.add(newImage());
        gallery.setImages(images);
        return gallery;
    }


    protected User newUser() {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setName(NAME);
        return user;
    }

    protected byte[] getImage() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("img-tests/1.png");
        File file = new File(url.getFile());
        byte[] imageInBytes = new byte[(int) file.length()];
        return imageInBytes;
    }

}
