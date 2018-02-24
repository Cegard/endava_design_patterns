package entities;

/**
 * This class define a supervisor and his information.
 * Every supervisor is identify by a unique id.
 */
public class Supervisor extends Employee {
    public int id;

    public Supervisor(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
