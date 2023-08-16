package ua.axellos.kanbanrider.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects")
public class Project extends BaseEntity {

    @Size(max = 255)
    @NotNull
    @NotBlank
    private String name;

    private String ownerId;

    @NotNull
    @NotBlank
    private String prefix;

    @NotNull
    @Min(1)
    private Integer startingNumber;

    @Size(max = 2000)
    private String description;

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
