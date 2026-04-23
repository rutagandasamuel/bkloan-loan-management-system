package BKLOAN.Main;

import BKLOAN.Customer;
import BKLOAN.Factory.LoanFactory;
import BKLOAN.LoanManager;
import BKLOAN.Repayment;
import BKLOAN.Utilities.InputValidator;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter Customer ID:");
            String customerId = scanner.nextLine();
            while (InputValidator.isEmpty(customerId)) {
                InputValidator.showError("Customer ID cannot be empty.");
                customerId = scanner.nextLine();
            }

            System.out.println("Enter Customer Name:");
            String customerName = scanner.nextLine();
            while (InputValidator.isEmpty(customerName)) {
                InputValidator.showError("Customer name cannot be empty.");
                customerName = scanner.nextLine();
            }

            System.out.println("Enter National ID (16 digits):");
            String nationalId = scanner.nextLine();
            while (!InputValidator.isValidNationalId(nationalId)) {
                InputValidator.showError("Invalid National ID format.");
                nationalId = scanner.nextLine();
            }

            System.out.println("Enter Phone Number (10 digits):");
            String phoneNumber = scanner.nextLine();
            while (!InputValidator.isValidPhone(phoneNumber)) {
                InputValidator.showError("Invalid phone number format.");
                phoneNumber = scanner.nextLine();
            }

            Customer customer = new Customer(customerId, customerName, nationalId, phoneNumber);


            System.out.println("Enter Loan ID:");
            String loanId = scanner.nextLine();
            while (InputValidator.isEmpty(loanId)) {
                InputValidator.showError("Loan ID cannot be empty.");
                loanId = scanner.nextLine();
            }

            System.out.println("Enter Loan Type (Personal, Home, Car, Business, Student, Agricultural):");
            String loanType = scanner.nextLine();
            while (!InputValidator.isValidLoanType(loanType)) {
                InputValidator.showError("Invalid Loan Type.");
                loanType = scanner.nextLine();
            }

            double loanAmount = 0;
            System.out.printf("Loan Amount: %,.0f RWF%n", loanAmount);
            loanAmount = 0;
            while (true) {
                String input = scanner.nextLine();
                if (InputValidator.isDouble(input)) {
                    loanAmount = Double.parseDouble(input);
                    if (InputValidator.isPositiveNumber(loanAmount)) break;
                }
                InputValidator.showError("Enter a valid positive number for Loan Amount.");
            }

            System.out.println("Enter Interest Rate (%):");
            double interestRate = 0;
            while (true) {
                String input = scanner.nextLine();
                if (InputValidator.isDouble(input)) {
                    interestRate = Double.parseDouble(input);
                    if (InputValidator.isValidInterestRate(interestRate)) break;
                }
                InputValidator.showError("Enter a valid interest rate between 0 and 100.");
            }

            System.out.println("Enter Loan Duration (months):");
            int loanDuration = 0;
            while (true) {
                String input = scanner.nextLine();
                if (InputValidator.isInteger(input)) {
                    loanDuration = Integer.parseInt(input);
                    if (loanDuration > 0) break;
                }
                InputValidator.showError("Enter a valid positive integer for duration.");
            }

            System.out.println("Enter Officer Name:");
            String officerName = scanner.nextLine();
            while (InputValidator.isEmpty(officerName)) {
                InputValidator.showError("Officer Name cannot be empty.");
                officerName = scanner.nextLine();
            }

            System.out.println("Enter Branch Location:");
            String branchLocation = scanner.nextLine();
            while (InputValidator.isEmpty(branchLocation)) {
                InputValidator.showError("Branch Location cannot be empty.");
                branchLocation = scanner.nextLine();
            }

            Object uniqueAttribute = null;

            switch (loanType.toLowerCase()) {
                case "personal":
                    System.out.println("Enter Purpose of Personal Loan:");
                    uniqueAttribute = scanner.nextLine();
                    break;
                case "home":
                    System.out.println("Enter Property Value:");
                    while (true) {
                        String input = scanner.nextLine();
                        if (InputValidator.isDouble(input)) {
                            uniqueAttribute = Double.parseDouble(input);
                            break;
                        }
                        InputValidator.showError("Enter a valid property value.");
                    }
                    break;
                case "car":
                    System.out.println("Enter Car Model:");
                    uniqueAttribute = scanner.nextLine();
                    break;
                case "business":
                    System.out.println("Enter Business Name:");
                    uniqueAttribute = scanner.nextLine();
                    break;
                case "student":
                    System.out.println("Enter University Name:");
                    uniqueAttribute = scanner.nextLine();
                    break;
                case "agricultural":
                    System.out.println("Enter Farm Size (acres):");
                    while (true) {
                        String input = scanner.nextLine();
                        if (InputValidator.isDouble(input)) {
                            uniqueAttribute = Double.parseDouble(input);
                            break;
                        }
                        InputValidator.showError("Enter a valid farm size.");
                    }
                    break;
            }
            LoanManager loan = LoanFactory.createLoan(
                    loanType, loanId, loanAmount, interestRate, loanDuration, "Pending",
                    officerName, branchLocation, uniqueAttribute
            );
            System.out.println("Enter Payment Amount:");
            double paymentAmount = 0;
            while (true) {
                String input = scanner.nextLine();
                if (InputValidator.isDouble(input)) {
                    paymentAmount = Double.parseDouble(input);
                    if (InputValidator.isPositiveNumber(paymentAmount)) break;
                }
                InputValidator.showError("Enter a valid positive number for Payment.");
            }
            Repayment repayment = new Repayment("P001", loan, paymentAmount, LocalDate.now());

            System.out.println("\n======== CUSTOMER DETAILS ========");
            System.out.println(customer);

            System.out.println("\n======== LOAN DETAILS ========");
            System.out.println(loan);

            System.out.println("\n======== REPAYMENT SUMMARY ========");
            System.out.printf("Remaining Balance: %, .2f RWF%n", repayment.getRemainingBalance());

        }
}

