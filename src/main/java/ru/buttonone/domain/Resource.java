package ru.buttonone.domain;

<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonProperty;
>>>>>>> master
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

<<<<<<< HEAD
@Data
@NoArgsConstructor
public class Resource {
=======
@NoArgsConstructor
@Data
public class Resource {

>>>>>>> master
    private int id;
    private String name;
    private int year;
    private String color;
<<<<<<< HEAD
    private String pantone_value;
=======
    @JsonProperty("pantone_value")
    private String pantoneValue;
>>>>>>> master

    public Resource(int id, String name, int year, String color, String pantone_value) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
<<<<<<< HEAD
        this.pantone_value = pantone_value;
=======
        this.pantoneValue = pantone_value;
>>>>>>> master
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
<<<<<<< HEAD
        if (o == null || getClass() != o.getClass()) return false;
        Resource that = (Resource) o;
        return id == that.id &&
               year == that.year &&
               Objects.equals(name, that.name) &&
               Objects.equals(color, that.color) &&
               Objects.equals(pantone_value, that.pantone_value);
=======
        if (!(o instanceof Resource)) return false;
        Resource resource = (Resource) o;
        return id == resource.id && year == resource.year && Objects.equals(name, resource.name) && Objects.equals(color, resource.color) && Objects.equals(pantoneValue, resource.pantoneValue);
>>>>>>> master
    }

    @Override
    public int hashCode() {
<<<<<<< HEAD
        return Objects.hash(id, name, year, color, pantone_value);
    }


=======
        return Objects.hash(id, name, year, color, pantoneValue);
    }
>>>>>>> master
}
