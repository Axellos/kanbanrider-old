package ua.axellos.kanbanrider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.axellos.kanbanrider.dto.ProjectDto;
import ua.axellos.kanbanrider.dto.mapper.ProjectMapper;
import ua.axellos.kanbanrider.exception.ModelNotFoundException;
import ua.axellos.kanbanrider.repository.ProjectRepository;
import ua.axellos.kanbanrider.service.ProjectService;
import ua.axellos.kanbanrider.model.Project;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("Project with id " + id + " not found"));
    }

    @Override
    public List<Project> findAllByOwnerId(String ownerId) {
        return projectRepository.findAllByOwnerId(ownerId);
    }

    @Override
    public Project create(ProjectDto projectDto, String ownerId) {
        Project project = ProjectMapper.INSTANCE.projectDtoToProject(projectDto);
        project.setOwnerId(ownerId);

        return projectRepository.save(project);
    }

    @Override
    @Transactional
    public Project updateById(Long id, ProjectDto projectDto) {
        Project project = findById(id);
        ProjectMapper.INSTANCE.updateProjectFromProjectDto(projectDto, project);

        return projectRepository.save(project);
    }
}
