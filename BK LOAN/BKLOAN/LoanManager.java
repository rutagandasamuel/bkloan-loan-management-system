package BKLOAN;

import BKLOAN.Service.Payable;

public class LoanManager extends Loan implements Payable {

    private String officerName;
    private String branchLocation;

    public LoanManager() {
        super();
    }

    public LoanManager(String loanId, String loanType, double loanAmount,
                       double interestRate, int loanDuration, String loanStatus,
                       String officerName, String branchLocation) {

        super(loanId, loanType, loanAmount, interestRate, loanDuration, loanStatus);
        this.officerName = officerName;
        this.branchLocation = branchLocation;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    @Override
    public double calculateInterest() {
        double timeInYears = getLoanDuration()  / 12.0;
        return getLoanAmount() * getLoanDuration() / 100 * timeInYears ;
    }

    @Override
    public double calculateMonthlyInstallment() {
        return calculateTotalRepayment() / getLoanDuration();
    }

    @Override
    public boolean checkEligibility() {
        return getLoanAmount() > 0 && getLoanAmount() <= 10000000;
    }

    @Override
    public void approveLoan() {
        setLoanStatus("Approved");
    }

    @Override
    public void rejectLoan() {
        setLoanStatus("Rejected");
    }

    @Override
    public double calculateTotalRepayment() {
        return getLoanAmount() + calculateInterest();
    }

    @Override
    public String generateLoanReport() {
        return "Loan Report:\n" + toString();
    }

    @Override
    public boolean validateLoanDetails() {
        return getLoanAmount() > 0 && getInterestRate() > 0 && getLoanDuration() > 0;
    }

    private double remainingBalance = 0;

    @Override
    public void processPayment(double amount) {
        if (remainingBalance == 0) {
            remainingBalance = calculateTotalRepayment();
        }
        remainingBalance -= amount;
    }

    @Override
    public double calculateRemainingBalance() {
        return remainingBalance;
    }

    @Override
    public String generatePaymentReceipt() {
        return "Payment processed. Remaining balance: " + remainingBalance;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nOfficer Name: " + officerName +
                "\nBranch Location: " + branchLocation;
    }
}