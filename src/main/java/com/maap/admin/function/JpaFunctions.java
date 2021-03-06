package com.maap.admin.function;

import com.maap.admin.function.jpa.GalleryEntityToGalleryFunction;
import com.maap.admin.function.jpa.ImageEntityToImageFunction;
import com.maap.admin.function.jpa.ProjectEntityToProjectFunction;
import com.maap.admin.function.jpa.UserEntityToUserFunction;

public class JpaFunctions {


    public static final GalleryEntityToGalleryFunction galleryEntityToGalleryFunction = new GalleryEntityToGalleryFunction();
    public static final ImageEntityToImageFunction imageEntityToImageFunction = new ImageEntityToImageFunction();
    public static final ProjectEntityToProjectFunction projectEntityToProjectFunction = new ProjectEntityToProjectFunction();
    public static final UserEntityToUserFunction userEntityToUserFunction = new UserEntityToUserFunction();

    public JpaFunctions() {
    }

}
