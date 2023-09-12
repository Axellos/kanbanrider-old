package ua.axellos.kanbanrider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.axellos.kanbanrider.dto.ProjectDto;
import ua.axellos.kanbanrider.dto.mapper.ProjectMapper;
import ua.axellos.kanbanrider.repository.ProjectRepository;
import ua.axellos.kanbanrider.service.ProjectService;
import ua.axellos.kanbanrider.model.Project;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project save(ProjectDto projectDto, String ownerId) {
        Project project = ProjectMapper.INSTANCE.projectDtoToProject(projectDto);
        project.setOwnerId(ownerId);

        return projectRepository.save(project);
    }

    @Override
    public List<Project> findAllByOwnerId(String ownerId) {
        return projectRepository.findAllByOwnerId(ownerId);
    }
}
