package ua.axellos.kanbanrider.service;

import ua.axellos.kanbanrider.model.Project;

public interface ProjectService {

    Project save(String name, String prefix, int startingNumber, String description, String ownerId);
}
