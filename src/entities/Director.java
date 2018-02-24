package entities;

/**
 * This class define a director and his information.
 * Every director is identify by a unique id.
 */
public class Director extends Employee {
    public int id;

    public Director(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
