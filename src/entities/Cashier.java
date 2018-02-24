package entities;

/**
 * This class define a cashier and his information.
 * Every cashier is identify by a unique id.
 */
public class Cashier extends Employee {
    public int id;

    public Cashier(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
