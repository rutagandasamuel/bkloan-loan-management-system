package BKLOAN;

public class CarLoan extends LoanManager {

        private String carModel;

        public CarLoan(String loanId, String loanType, double loanAmount,
                       double interestRate, int loanDuration, String loanStatus,
                       String officerName, String branchLocation,
                       String carModel) {
            super(loanId, loanType, loanAmount, interestRate, loanDuration, loanStatus,
                    officerName, branchLocation);
            this.carModel = carModel;
        }

        public String getCarModel() { return carModel; }
        public void setCarModel(String carModel) { this.carModel = carModel; }

        @Override
        public double calculateInterest() {
            double timeInYears = getLoanDuration() / 12.0;
            return getLoanAmount() * (getInterestRate() + 1.5) / 100 * timeInYears;
        }

        @Override
        public boolean checkEligibility() {
            return getLoanAmount() <= 3000000;
        }

        @Override
        public String generateLoanReport() {
            return super.generateLoanReport() + "\nCar Model: " + carModel;
        }

        @Override
        public String toString() {
            return super.toString() + "\nCar Model: " + carModel;
        }
}

