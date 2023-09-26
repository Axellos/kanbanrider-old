package ua.axellos.kanbanrider.service;

import ua.axellos.kanbanrider.dto.ProjectDto;
import ua.axellos.kanbanrider.model.Project;

import java.util.List;

public interface ProjectService {

    Project findById(Long id);

    List<Project> findAllByOwnerId(String ownerId);

    Project create(ProjectDto project, String ownerId);

    Project updateById(Long id, ProjectDto projectDto);
}
