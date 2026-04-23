package BKLOAN.Factory;

import BKLOAN.*;

public class LoanFactory {

        public static LoanManager createLoan(String type, String loanId, double loanAmount,
                                             double interestRate, int loanDuration, String loanStatus,
                                             String officerName, String branchLocation,
                                             Object uniqueAttribute) {

            switch (type.toLowerCase()) {
                case "personal":
                    return new PersonalLoan(loanId, type, loanAmount, interestRate, loanDuration,
                            loanStatus, officerName, branchLocation, (String) uniqueAttribute);

                case "home":
                    return new HomeLoan(loanId, type, loanAmount, interestRate, loanDuration,
                            loanStatus, officerName, branchLocation, (Double) uniqueAttribute);

                case "car":
                    return new CarLoan(loanId, type, loanAmount, interestRate, loanDuration,
                            loanStatus, officerName, branchLocation, (String) uniqueAttribute);

                case "business":
                    return new BusinessLoan(loanId, type, loanAmount, interestRate, loanDuration,
                            loanStatus, officerName, branchLocation, (String) uniqueAttribute);

                case "student":
                    return new StudentLoan(loanId, type, loanAmount, interestRate, loanDuration,
                            loanStatus, officerName, branchLocation, (String) uniqueAttribute);

                case "agricultural":
                    return new AgriculturalLoan(loanId, type, loanAmount, interestRate, loanDuration,
                            loanStatus, officerName, branchLocation, (Double) uniqueAttribute);

                default:
                    return null;
            }
        }
    }

