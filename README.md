# bkloan-loan-management-system
Java Loan Management System containerized with Docker and packaged as a JAR file for deployment and execution.
### ASSIGNMENT ONE
OOP Java Question: Advanced Loan Management System
Case Study: Bank of Kigali

Background
Bank of Kigali wants to develop a secure and scalable Loan Management System to manage loan products, customers, and repayment operations. The system must strictly follow Object-Oriented Programming (OOP) principles and demonstrate a clean, maintainable design.

PART A: Core Loan Structure
1. Abstract Class: Loan
Attributes (Private)
* Loan ID
* Loan Type
* Loan Amount
* Interest Rate
* Loan Duration (months)
* Loan Status
Requirements
Must include:
* Default constructor
* Parameterized constructor
* Getters and setters
* Override toString() to display loan details
Abstract Methods (at least 8)
* Calculate Interest
* Calculate Monthly Installment
* Check Eligibility
* Approve Loan
* Reject Loan
* Calculate Total Repayment
* Generate Loan Report
* Validate Loan Details

2. Interface: Payable
Define an interface called Payable
Methods
* Process Payment
* Calculate Remaining Balance
* Generate Payment Receipt

3. Class: LoanManager
* Must extend Loan
* Must implement Payable
Additional Attributes
* Officer Name
* Branch Location
Requirements
* Implement all abstract and interface methods
* Include constructors, getters/setters, and toString()

PART B: Loan Types (Inheritance)
Create the following 6 subclasses that extend LoanManager:
1. PersonalLoan
2. HomeLoan
3. CarLoan
4. BusinessLoan
5. StudentLoan
6. AgriculturalLoan
Requirements
Each subclass must:
* Have its own specific attribute
(e.g., collateral type, property value, university name, farm size, etc.)
* Use constructors
* Override at least 3 methods
* Override toString()

PART C: Additional System Classes
4. Class: Customer
Attributes
* Customer ID
* Customer Name
* National ID
* Phone Number
Requirements
* Constructors
* Getters and setters
* toString()

5. Class: Repayment
Attributes
* Payment ID
* Loan
* Amount Paid
* Payment Date
* Remaining Balance
Requirements
* Constructors
* Getters/setters
* toString()
* Method to update remaining balance

6. Class: InputValidator
Responsibilities
Validate:
* Empty inputs
* Invalid formats
* Negative numbers
* Incorrect data types
* Invalid interest rates
* Incorrect phone/National ID formats
Must:
* Provide clear error messages

7. Class: LoanFactory
Responsibilities
* Create loan objects based on type
(e.g., Personal → PersonalLoan)
* Demonstrate polymorphism

8. Class: LoanSystem (Main Class)
Responsibilities
* Contains the main method
* Interacts with the user
User Input
Prompt user to enter:
* Loan details
* Customer details
* Payment amount
Behavior
* Use InputValidator to validate inputs
* Use LoanFactory to create objects
* Process payments using Payable methods
Display
* Loan details
* Customer details
* Repayment summary

Validation Requirements (VERY IMPORTANT)
The system must handle real-world user behavior, including:
* Empty input
* Text instead of numbers
* Negative or zero values
* Invalid loan types
* Extremely large loan amounts
* Duplicate IDs
* Incorrect formats (phone, national ID, loan ID)
The program must:
* Display meaningful error messages
* Re-prompt user until valid input is provided

OOP Concepts to Demonstrate
Your design must clearly show:
* Encapsulation → private attributes + getters/setters
* Abstraction → abstract class (Loan)
* Interface → Payable
* Inheritance → multiple subclasses
* Polymorphism → method overriding & factory usage
* Constructor usage → default & parameterized
* Method overriding → toString() and others
