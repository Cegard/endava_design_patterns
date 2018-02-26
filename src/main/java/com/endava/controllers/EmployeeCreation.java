package com.endava.controllers;
import com.endava.entities.Employee;


@FunctionalInterface
public interface EmployeeCreation {
    Employee create(int id);
}
