package com.maap.admin.function;

import com.maap.admin.function.jpa.*;

public class JpaFunctions {


    public static final GalleryEntityToGalleryFunction galleryEntityToGalleryFunction = new GalleryEntityToGalleryFunction();
    public static final GalleryToGalleryEntityFunction galleryToGalleryEntityFunction = new GalleryToGalleryEntityFunction();

    public static final ImageEntityToImageFunction imageEntityToImageFunction = new ImageEntityToImageFunction();
    public static final ImageToImageEntityFunction imageToImageEntityFunction = new ImageToImageEntityFunction();

    public static final ProjectEntityToProjectFunction projectEntityToProjectFunction = new ProjectEntityToProjectFunction();
    public static final UserEntityToUserFunction userEntityToUserFunction = new UserEntityToUserFunction();

    public JpaFunctions() {
    }

}
