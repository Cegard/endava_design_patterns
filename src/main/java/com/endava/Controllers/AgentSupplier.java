
package com.endava.Controllers;
import com.endava.Entities.Employees.Employee;

import java.util.function.Supplier;

/**
 * This method represents the promise for the completable future that was created by the dispatcher.
 */
public class AgentSupplier implements Supplier<Employee> {

    public Employee getAgent() {
        return agent;
    }

    public void setAgent(Employee agent) {
        this.agent = agent;
    }

    private Employee agent;
    private double timeToAttend;


    public AgentSupplier(Employee agent){
        this.agent = agent;
    }


    /**
     * This method simulate the time of attention of a client, it is define by a random number between 10 to 15 seconds.
     * @return the time that took attend a specific client.
     */
    @Override
    public Employee get() {
        this.timeToAttend = (Math.floor(Math.random()*5 + 10));
        double timeToSleep = timeToAttend * 1000;

        try {
            Thread.sleep((long) timeToSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this.agent;
    }


    public double getTimeToAttend() {
        return timeToAttend;
    }


    public void setTimeToAttend(double timeToAttend) {
        this.timeToAttend = timeToAttend;
    }
}
