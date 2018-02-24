package controllers;

import java.util.function.Supplier;

/**
 * This method represents the promise for the completable future that was created by the dispatcher.
 */
public class AgentSupplier implements Supplier<Double> {

    /**
     * This method simulate the time of attention of a client, it is define by a random number between 10 to 15 seconds.
     * @return the time that took attend a specific client.
     */
    @Override
    public Double get() {
        double timeOfAttention = (Math.floor(Math.random()*5 + 10)) * 1000;
        try {
            Thread.sleep((long) timeOfAttention);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return timeOfAttention/1000;
    }
}
