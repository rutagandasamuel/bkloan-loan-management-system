package BKLOAN;

public class AgriculturalLoan extends LoanManager {

    private double farmSize;

    public AgriculturalLoan(String loanId, String loanType, double loanAmount,
                            double interestRate, int loanDuration, String loanStatus,
                            String officerName, String branchLocation,
                            double farmSize) {
        super(loanId, loanType, loanAmount, interestRate, loanDuration, loanStatus,
                officerName, branchLocation);
        this.farmSize = farmSize;
    }

    public double getFarmSize() { return farmSize; }
    public void setFarmSize(double farmSize) { this.farmSize = farmSize; }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * (getInterestRate() - 1) * getLoanDuration() / 100;
    }

    @Override
    public boolean checkEligibility() {
        return getLoanAmount() <= farmSize * 100000;
    }

    @Override
    public String generateLoanReport() {
        return super.generateLoanReport() + "\nFarm Size: " + farmSize + " acres";
    }

    @Override
    public String toString() {
        return super.toString() + "\nFarm Size: " + farmSize + " acres";
    }
}
