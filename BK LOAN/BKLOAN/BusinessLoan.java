package BKLOAN;

public class BusinessLoan extends LoanManager {

        private String businessName;

        public BusinessLoan(String loanId, String loanType, double loanAmount,
                            double interestRate, int loanDuration, String loanStatus,
                            String officerName, String branchLocation,
                            String businessName) {
            super(loanId, loanType, loanAmount, interestRate, loanDuration, loanStatus,
                    officerName, branchLocation);
            this.businessName = businessName;
        }

        public String getBusinessName() { return businessName; }
        public void setBusinessName(String businessName) { this.businessName = businessName; }

        @Override
        public double calculateInterest() {
            return getLoanAmount() * (getInterestRate() + 3) * getLoanDuration() / 100;
        }

        @Override
        public boolean checkEligibility() {
            return getLoanAmount() <= 10000000;
        }

        @Override
        public String generateLoanReport() {
            return super.generateLoanReport() + "\nBusiness Name: " + businessName;
        }

        @Override
        public String toString() {
            return super.toString() + "\nBusiness Name: " + businessName;
        }
}