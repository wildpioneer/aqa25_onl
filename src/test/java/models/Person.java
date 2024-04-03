package models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class Person {
    /**
     * Age of the person.
     *
     * @param age New value for this person's age.
     * @return The current value of this person's age.
     */
    @Getter @Setter private int age = 10;

    /**
     * Name of the person.
     * -- SETTER --
     * Changes the name of this person.
     *
     * @param name The new value.
     */
    @Setter(AccessLevel.PROTECTED) private String name;

    @Override
    public String toString() {
        return String.format("%s (age: %d)", name, age);
    }
}
