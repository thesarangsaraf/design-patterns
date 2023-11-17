package design.patterns.observer;

import design.patterns.observer.abstraction.EmployeeSalaryChangeListener;

public class UpdateEmployeeSalaryDatabase implements EmployeeSalaryChangeListener {

    @Override
    public void listen(long updatedSalary) {
        System.out.println("Called listener class with input " + updatedSalary);
    }

}