package com.EmpPayRoll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static com.EmpPayRoll.EmployeePayrollService.IOService.FILE_IO;

public class EmployeePayrollServiceTest {
    @Test
    public  void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() {
        EmployeePayroll[] arrayOfEmps = {
                new EmployeePayroll(1, "Arun",100000.0),
                new EmployeePayroll(2, "Amal",150000.0),
                new EmployeePayroll(3, "Arjun",200000.0),
        };
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayroll();
        employeePayrollService.printData(FILE_IO);
        long entries = employeePayrollService.countEntries(FILE_IO);
        Assertions.assertEquals(3, entries);
    }
}

