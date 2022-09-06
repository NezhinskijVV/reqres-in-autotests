package ru.buttonone.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@Data
public class Resource {

    private int id;
    private String name;
    private int year;
    private String color;
    @JsonProperty("pantone_value")
    private String pantoneValue;

    public Resource(int id, String name, int year, String color, String pantone_value) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantoneValue = pantone_value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resource)) return false;
        Resource resource = (Resource) o;
        return id == resource.id && year == resource.year && Objects.equals(name, resource.name) && Objects.equals(color, resource.color) && Objects.equals(pantoneValue, resource.pantoneValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year, color, pantoneValue);
    }
}
