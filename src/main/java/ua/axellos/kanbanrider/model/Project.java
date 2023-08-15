package ua.axellos.kanbanrider.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Table(name = "projects")
public class Project extends BaseEntity {

    private String name;

    private String ownerId;

    private String prefix;

    private int startingNumber;

    private String description;

    public Project(String name, String prefix, int startingNumber, String description, String ownerId) {
        this.name = name;
        this.prefix = prefix;
        this.startingNumber = startingNumber;
        this.description = description;
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getStartingNumber() {
        return startingNumber;
    }

    public void setStartingNumber(int startingNumber) {
        this.startingNumber = startingNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
