
package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void testGetAnnualSalary() {
        Employee employeeUnderTest = new Employee(1, "Jamie", "Cornick", 100);
        Assertions.assertEquals(1200, employeeUnderTest.getAnnualSalary());
    }

    @Test
    public void testEmployeesAreEqual() {
        Employee employeeUnderTest1 = new Employee(1, "Jamie", "Cornick", 100);
        Employee employeeUnderTest2 = new Employee(2, "Jamie", "Cornick", 100);
        Assertions.assertEquals(employeeUnderTest1, employeeUnderTest2);
    }

    @Test
    public void testRaiseSalaryBy20Percent() {
        Employee employeeUnderTest = new Employee(1, "Jamie", "Cornick", 5000);
        int newSalary = employeeUnderTest.raiseSalary(20);
        Assertions.assertEquals(6000, newSalary);
    }

    @Test
    public void testRaiseSalaryByNegativePercent() {
        Employee employeeUnderTest = new Employee(1, "Jamie", "Cornick", 5000);
        int newSalary = employeeUnderTest.raiseSalary(-10);
        Assertions.assertEquals(4500, newSalary);
    }

    @Test
    public void testRaiseSalaryByZeroPercent() {
        Employee employeeUnderTest = new Employee(1, "Jamie", "Cornick", 5000);
        int newSalary = employeeUnderTest.raiseSalary(0);
        Assertions.assertEquals(5000, newSalary);
    }
}

