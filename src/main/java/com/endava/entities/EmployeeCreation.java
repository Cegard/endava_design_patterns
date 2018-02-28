package com.endava.entities;
import com.endava.entities.Employee;


@FunctionalInterface
public interface EmployeeCreation {
    Employee create(int id);
}
