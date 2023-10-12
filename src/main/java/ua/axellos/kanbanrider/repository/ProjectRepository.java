package ua.axellos.kanbanrider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.axellos.kanbanrider.model.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findAllByOwnerId(String ownerId);

    boolean existsByNameAndOwnerId(String name, String ownerId);

    boolean existsByIdAndOwnerId(Long id, String ownerId);
}
