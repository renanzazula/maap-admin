package com.maap.admin;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BaseTest {

    public static final String NAME = "name";
    public static final String DESCRIPTION = "Description";

    protected byte[] getImage() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("img-tests/1.png");
        File file = new File(url.getFile());
        byte[] imageInBytes = new byte[(int) file.length()];
        return imageInBytes;
    }

}
