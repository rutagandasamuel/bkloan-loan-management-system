package BKLOAN;

public class PersonalLoan extends LoanManager {

    private String purpose;

    public PersonalLoan(String loanId, String loanType, double loanAmount,
                        double interestRate, int loanDuration, String loanStatus,
                        String officerName, String branchLocation,
                        String purpose) {
        super(loanId, loanType, loanAmount, interestRate, loanDuration, loanStatus,
                officerName, branchLocation);
        this.purpose = purpose;
    }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * (getInterestRate() + 2) * getLoanDuration() / 100;
    }

    @Override
    public boolean checkEligibility() {
        return getLoanAmount() <= 5000000;
    }

    @Override
    public String generateLoanReport() {
        return super.generateLoanReport() + "\nPurpose: " + purpose;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPurpose: " + purpose;
    }
}
