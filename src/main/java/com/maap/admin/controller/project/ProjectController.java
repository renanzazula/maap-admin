package com.maap.admin.controller.project;

import com.maap.admin.domain.Project;
import com.maap.admin.service.project.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Api(value = "Project Controller", tags = "project")
@RestController
@RequestMapping(ProjectController.BASE_URL)
@AllArgsConstructor
public class ProjectController {

    public static final String BASE_URL = "/private/v1/project";

    private final ProjectService service;

    @GetMapping({""})
    @ApiOperation(value = "get all projects")
    public ResponseEntity<List<Project>> get() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    @ApiOperation(value = "get project by id")
    public ResponseEntity<Project> getBy(@PathVariable @NotNull UUID id) throws Exception {
        return new ResponseEntity<>(service.getBy(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save project")
    public ResponseEntity<Project> save(@RequestBody @NotNull Project project) {
        service.save(project);
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
    public ResponseEntity<Project> update(@PathVariable @NotNull UUID id, @RequestBody @NotNull Project project) throws Exception {
        return new ResponseEntity<>(service.update(id, project), HttpStatus.OK);
    }

}

