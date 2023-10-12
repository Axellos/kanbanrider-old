package ua.axellos.kanbanrider.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ua.axellos.kanbanrider.repository.ProjectRepository;

@Component
public class ProjectAccessManager {

    @Autowired
    private ProjectRepository projectRepository;

    public boolean canAccess(Long projectId, Authentication authentication) {
        return projectRepository.existsByIdAndOwnerId(projectId, authentication.getName());
    }

    public boolean canUpdateProject(Long projectId, Authentication authentication) {
        return projectRepository.existsByIdAndOwnerId(projectId, authentication.getName());
    }

    private boolean isOwner(Project project, Authentication authentication) {
        return project.getOwnerId().equals(authentication.getName());
    }
}
