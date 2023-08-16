package ua.axellos.kanbanrider.service;

import ua.axellos.kanbanrider.model.Project;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    List<Project> findAllByOwnerId(String ownerId);
}
