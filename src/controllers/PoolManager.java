package controllers;

/**
 * This class control the creation of every pool of cashiers, supervisors and directors.
 */
public class PoolManager {
   public PoolsController poolControllerCashier;
   public PoolsController poolControllerSupervisor;
   public PoolsController poolControllerDirector;

    public PoolManager(int numberOfCashiers, int numberOfSupervisors, int numberOfDirectors) {
        createPoolObjects(numberOfCashiers, numberOfSupervisors, numberOfDirectors);
    }

    /**
     * This method creates every structure for control the assignation of cashiers, supervisors and directors.
     * @param numberOfCashiers represent the quantity of cashiers in the bank.
     * @param numberOfSupervisors represent the quantity of supervisors in the bank.
     * @param numberOfDirectors represent the quantity of supervisors in the bank.
     */
    public void createPoolObjects(int numberOfCashiers, int numberOfSupervisors, int numberOfDirectors ){
        poolControllerCashier = new PoolCashier(numberOfCashiers);
        poolControllerSupervisor = new PoolSupervisor(numberOfSupervisors);
        poolControllerDirector = new PoolDirector(numberOfDirectors);

    }
}
