package ua.axellos.kanbanrider.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.axellos.kanbanrider.dto.ProjectDto;
import ua.axellos.kanbanrider.model.Project;

@Mapper
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectDto projectToProjectDto(Project project);

    Project projectDtoToEntity(ProjectDto projectDto);
}
