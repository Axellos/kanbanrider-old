package ua.axellos.kanbanrider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.axellos.kanbanrider.repository.ProjectRepository;
import ua.axellos.kanbanrider.service.ProjectService;
import ua.axellos.kanbanrider.model.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project save(String name, String prefix, int startingNumber, String description, String ownerId) {
        return projectRepository.save(new Project(name, prefix, startingNumber, description, ownerId));
    }
}
