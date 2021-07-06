package com.maap.admin.controller.image;

import com.maap.admin.domain.Image;
import com.maap.admin.service.image.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Api(value = "Image Controller", tags = "Image")
@RestController
@RequestMapping(ImageController.BASE_URL)
@AllArgsConstructor
public class ImageController {

    public static final String BASE_URL = "/private/v1/image";

    private final ImageService service;

    @GetMapping({""})
    @ApiOperation(value = "get all Images")
    public ResponseEntity<List<Image>> get() {
        List<Image> list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    @ApiOperation(value = "get Image by id")
    public ResponseEntity<Image> getBy(@PathVariable @NotNull UUID id) throws Exception {
        return new ResponseEntity<>(service.getBy(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save Image")
    public ResponseEntity<Image> save(@RequestBody @NotNull Image Image) {
        service.save(Image);
        return new ResponseEntity<>(HttpStatus.CREATED);
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

}

