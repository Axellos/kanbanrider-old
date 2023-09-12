package ua.axellos.kanbanrider.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.axellos.kanbanrider.dto.ProjectDto;
import ua.axellos.kanbanrider.dto.mapper.ProjectMapper;
import ua.axellos.kanbanrider.model.Project;
import ua.axellos.kanbanrider.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@RequestBody @Validated ProjectDto projectDto) {
        String ownerId = SecurityContextHolder.getContext().getAuthentication().getName();
        projectService.save(projectDto, ownerId);

        return new ResponseEntity<>(projectDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllOwnProjects() {
        List<Project> projects = projectService.findAllByOwnerId(
                SecurityContextHolder.getContext().getAuthentication().getName()
        );

        return new ResponseEntity<>(ProjectMapper.INSTANCE.map(projects), HttpStatus.OK);
    }
}
