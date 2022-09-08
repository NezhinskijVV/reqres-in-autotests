package ru.buttonone.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Resource {
    private int id;
    private String name;
    private int year;
    private String color;
    private String pantone_value;

    public Resource(int id, String name, int year, String color, String pantone_value) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantone_value = pantone_value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource that = (Resource) o;
        return id == that.id &&
               year == that.year &&
               Objects.equals(name, that.name) &&
               Objects.equals(color, that.color) &&
               Objects.equals(pantone_value, that.pantone_value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year, color, pantone_value);
    }


}
