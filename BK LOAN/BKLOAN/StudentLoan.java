package BKLOAN;

public class StudentLoan extends LoanManager {

    private String universityName;

    public StudentLoan(String loanId, String loanType, double loanAmount,
                       double interestRate, int loanDuration, String loanStatus,
                       String officerName, String branchLocation,
                       String universityName) {
        super(loanId, loanType, loanAmount, interestRate, loanDuration, loanStatus,
                officerName, branchLocation);
        this.universityName = universityName;
    }

    public String getUniversityName() { return universityName; }
    public void setUniversityName(String universityName) { this.universityName = universityName; }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * getInterestRate() * getLoanDuration() / 100;
    }

    @Override
    public boolean checkEligibility() {
        return getLoanAmount() <= 2000000;
    }

    @Override
    public String generateLoanReport() {
        return super.generateLoanReport() + "\nUniversity Name: " + universityName;
    }

    @Override
    public String toString() {
        return super.toString() + "\nUniversity Name: " + universityName;
    }
}
