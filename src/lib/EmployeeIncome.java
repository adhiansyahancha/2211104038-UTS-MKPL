package lib;

import java.time.LocalDate;

public class EmployeeIncome {
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	private int monthWorkingInYear;
	private Employee employee;

	public EmployeeIncome(Employee employee) {
		this.employee = employee;
	}

	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	public void setMonthlySalary(int grade) {
		if (this.employee.isForeigner) {
			monthlySalary = (int) (3000000 * 1.5);
			return;
		}

		switch (grade) {
			case 1:
				monthlySalary = 3000000;
				break;
			case 2:
				monthlySalary = 5000000;
				break;
			case 3:
				monthlySalary = 7000000;
				break;
		}
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public int getAnnualIncomeTax() {
		// Jika pegawai sudah bekerja dari tahun sebelumnya maka dianggap 12 bulan.
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == this.employee.dateJoined.getYear()) {
			monthWorkingInYear = date.getMonthValue() - this.employee.dateJoined.getMonthValue();
		}else {
			monthWorkingInYear = 12;
		}
		
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, this.employee.family.spouseIdNumber.isEmpty(), this.employee.family.childIdNumbers.size());
	}
}