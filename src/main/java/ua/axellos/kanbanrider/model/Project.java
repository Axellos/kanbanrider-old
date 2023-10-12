package ua.axellos.kanbanrider.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects")
public class Project extends BaseEntity {

    private String name;

    private String ownerId;

    private String prefix;

    private Integer startingNumber;

    private String description;
}
