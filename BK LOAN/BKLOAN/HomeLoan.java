package BKLOAN;

public class HomeLoan extends LoanManager {

        private double propertyValue;

        public HomeLoan(String loanId, String loanType, double loanAmount,
                        double interestRate, int loanDuration, String loanStatus,
                        String officerName, String branchLocation,
                        double propertyValue) {
            super(loanId, loanType, loanAmount, interestRate, loanDuration, loanStatus,
                    officerName, branchLocation);
            this.propertyValue = propertyValue;
        }

        public double getPropertyValue() { return propertyValue; }
        public void setPropertyValue(double propertyValue) { this.propertyValue = propertyValue; }

        @Override
        public double calculateInterest() {
            return getLoanAmount() * getInterestRate() * getLoanDuration() / 100 + propertyValue * 0.01;
        }

        @Override
        public boolean checkEligibility() {
            return getLoanAmount() <= propertyValue * 0.8;
        }

        @Override
        public String generateLoanReport() {
            return super.generateLoanReport() + "\nProperty Value: " + propertyValue;
        }

        @Override
        public String toString() {
            return super.toString() + "\nProperty Value: " + propertyValue;
        }
}

