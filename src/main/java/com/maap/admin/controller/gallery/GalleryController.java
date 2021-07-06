package com.maap.admin.controller.gallery;

import com.maap.admin.domain.Gallery;
import com.maap.admin.service.gallery.GalleryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Api(value = "Gallery Controller", tags = "gallery")
@RestController
@RequestMapping(GalleryController.BASE_URL)
@AllArgsConstructor
public class GalleryController {

    public static final String BASE_URL = "/private/v1/gallery";

    private final GalleryService service;

    @GetMapping({""})
    @ApiOperation(value = "get all projects")
    public ResponseEntity<List<Gallery>> get() {
        List<Gallery> list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    @ApiOperation(value = "get gallery by id")
    public ResponseEntity<Gallery> getBy(@PathVariable @NotNull UUID id) throws Exception {
        return new ResponseEntity<>(service.getBy(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save gallery")
    public ResponseEntity<Gallery> save(@RequestBody @NotNull Gallery gallery) {
        service.save(gallery);
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
    public ResponseEntity<Gallery> update(@PathVariable @NotNull UUID id, @RequestBody @NotNull Gallery gallery) throws Exception {
        return new ResponseEntity<>(service.update(id, gallery), HttpStatus.OK);
    }

}

