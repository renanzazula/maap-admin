package com.maap.admin.controller.image;

import com.maap.admin.domain.Image;
import com.maap.admin.service.image.ImageService;
import com.maap.admin.util.FileUploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Api(value = "Image Controller", tags = "Image")
@RestController
@RequestMapping(ImageController.BASE_URL)
@AllArgsConstructor
public class ImageController {

    public static final String BASE_URL = "/private/v1/image";

    private final ImageService service;
    private final HttpSession session;

    @GetMapping({""})
    @ApiOperation(value = "get all Images")
    public ResponseEntity<List<Image>> get() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    @ApiOperation(value = "get Image by id")
    public ResponseEntity<Image> getBy(@PathVariable @NotNull UUID id) throws Exception {
        return new ResponseEntity<>(service.getBy(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save Image")
    public ResponseEntity<Image> save(@RequestBody @NotNull Image image) {
        return new ResponseEntity<>(service.save(image), HttpStatus.CREATED);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete by id")
    public void delete(@PathVariable @NotNull UUID id) {
        service.deleteById(id);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Image> update(@PathVariable @NotNull UUID id, @RequestBody @NotNull Image Image) throws Exception {
        return new ResponseEntity<>(service.update(id, Image), HttpStatus.OK);
    }

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Image> upload(@RequestBody @NotNull Image image, @RequestPart("file") MultipartFile file) throws IOException {
        image.setImage(FileUploadUtil.compressBytes(file.getBytes()));
        image.setType(file.getContentType());
        return new ResponseEntity<>(service.save(image), HttpStatus.OK);
    }


}

