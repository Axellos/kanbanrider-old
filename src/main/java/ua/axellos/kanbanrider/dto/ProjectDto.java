package ua.axellos.kanbanrider.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    @Size(max = 255)
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String prefix;

    @NotNull
    @Min(1)
    private Integer startingNumber;

    @Size(max = 2000)
    private String description;
}
