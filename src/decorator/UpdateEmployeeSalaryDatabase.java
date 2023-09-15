package decorator;

import decorator.abstraction.EmployeeSalaryChangeListener;

public class UpdateEmployeeSalaryDatabase implements EmployeeSalaryChangeListener {

    @Override
    public void listen(long updatedSalary) {
        System.out.println("Called listener class with input " + updatedSalary);
    }

}