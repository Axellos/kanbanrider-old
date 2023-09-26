package ua.axellos.kanbanrider.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
    private final ProjectMapper projectMapper = ProjectMapper.INSTANCE;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllOwnProjects() {
        List<Project> projects = projectService.findAllByOwnerId(
                SecurityContextHolder.getContext().getAuthentication().getName()
        );

        return new ResponseEntity<>(projectMapper.map(projects), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@RequestBody @Validated ProjectDto projectDto) {
        String ownerId = SecurityContextHolder.getContext().getAuthentication().getName();
        Project project = projectService.create(projectDto, ownerId);

        return new ResponseEntity<>(projectMapper.projectToProjectDto(project), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    @PreAuthorize("@projectAccessManager.canUpdateProject(#id, authentication)")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable Long id, @RequestBody @Validated ProjectDto projectDto, Authentication authentication) {
        Project project = projectService.updateById(id, projectDto);

        return new ResponseEntity<>(projectMapper.projectToProjectDto(project), HttpStatus.OK);
    }
}
