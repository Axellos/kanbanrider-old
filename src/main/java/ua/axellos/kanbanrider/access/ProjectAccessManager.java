package ua.axellos.kanbanrider.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ua.axellos.kanbanrider.model.Project;
import ua.axellos.kanbanrider.repository.ProjectRepository;

@Component
public class ProjectAccessManager {

    @Autowired
    ProjectRepository projectRepository;

    public boolean canUpdateProject(Long projectId, Authentication authentication) {
        return projectRepository.findById(projectId)
                .map(project -> isOwner(project, authentication))
                .orElse(false);
    }

    private boolean isOwner(Project project, Authentication authentication) {
        return project.getOwnerId().equals(authentication.getName());
    }
}
