package mockito.example;

import java.util.List;

public class PayRoll {

	private EmployeeDB employeeDB;

	private BankService bankService;

	public PayRoll(EmployeeDB employeeDB, BankService bankService) {
		super();
		this.employeeDB = employeeDB;
		this.bankService = bankService;
	}

	public int monthlyPayment() {
		List<Employee> employees = employeeDB.getAllEmployees();

		employees.
			stream().
			forEach(employee -> bankService.makePayment(employee.getBankId(), employee.getSalary()));

		return employees.size();
	}

}
