package ua.axellos.kanbanrider.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.axellos.kanbanrider.model.Project;
import ua.axellos.kanbanrider.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody @Validated Project project) {
        project.setOwnerId(SecurityContextHolder.getContext().getAuthentication().getName());
        projectService.save(project);

        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }
}
