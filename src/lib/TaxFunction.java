package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	public static int calculateTax(int monthlySalary, int otherSalary, int monthsWorked, int deductible, boolean isMarried, int numberOfKids) {
		if (monthsWorked > 12) {
			System.err.println("More than 12 month working per year");
		}
		
		int tax = 0;
		int baseNetIncome = ((monthlySalary + otherSalary) * monthsWorked) - deductible;
		
		if (isMarried) {
			int deducedNumberOfKids = numberOfKids > 3 ? 3 : numberOfKids
			tax = (int) Math.round(0.05 * ((baseNetIncome - (54000000 + 4500000 + (deducedNumberOfKids * 1500000))));
		}
		
		tax = (int) Math.round(0.05 * ((baseNetIncome - 54000000));
		
		return tax < 0 ? 0 : tax;
	}
	
}
