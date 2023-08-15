package ua.axellos.kanbanrider.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public ResponseEntity<Project> createProject(@RequestParam String name
            , @RequestParam String prefix
            , @RequestParam(name = "starting_number") int startingNumber
            , @RequestParam String description) {
        String ownerId = SecurityContextHolder.getContext().getAuthentication().getName();
        Project project = projectService.save(name, prefix, startingNumber, description, ownerId);

        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }
}
