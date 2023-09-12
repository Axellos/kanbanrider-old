package ua.axellos.kanbanrider.service;

import ua.axellos.kanbanrider.dto.ProjectDto;
import ua.axellos.kanbanrider.model.Project;

import java.util.List;

public interface ProjectService {

    Project save(ProjectDto project, String ownerId);

    List<Project> findAllByOwnerId(String ownerId);
}
