package BKLOAN;

import java.time.LocalDate;

public class Repayment {

    private String paymentId;
    private LoanManager loan;
    private double amountPaid;
    private LocalDate paymentDate;
    private double remainingBalance;

    public Repayment() {
    }

    public Repayment(String paymentId, LoanManager loan, double amountPaid, LocalDate paymentDate) {
        this.paymentId = paymentId;
        this.loan = loan;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        this.remainingBalance = loan.calculateTotalRepayment() - amountPaid;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public LoanManager getLoan() {
        return loan;
    }

    public void setLoan(LoanManager loan) {
        this.loan = loan;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
        updateRemainingBalance();
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }


    public void updateRemainingBalance() {
        if (loan != null) {
            remainingBalance = loan.calculateTotalRepayment() - amountPaid;
        }
    }

    @Override
    public String toString() {
        return "Payment ID: " + paymentId +
                "\nLoan ID: " + loan.getLoanId() +
                "\nAmount Paid: " + amountPaid +
                "\nPayment Date: " + paymentDate +
                "\nRemaining Balance: " + remainingBalance;
    }
}
