/*
 *  Author: Carlos, Micah, George, Angel
 *    Date: November 21st 2025
 * Purpose: Create Loan object class to calculate extra payments
 */
import java.util.Scanner;
public class Loan {
public static Scanner input = new Scanner(System.in); // Scanner can be used everywhere

	// METHODS
	
	// First month only
	public static void getExtraPayFirstMonth(double userLoanAmount, double monthlyInterestRate,
			double monthlyPayment, double userExtraPayment, double totalInterest) {
		
		double balance = userLoanAmount;
		double totalInterestFirstMonth = 0;
		double interestSaved;
		int monthCounter = 0;
				
		while (balance > 0 ) {
				monthCounter++;
				double interest = balance * monthlyInterestRate;
				double actualPayment = monthlyPayment;
				if (monthCounter == 1) actualPayment += userExtraPayment; // If statement only runs once
				if (actualPayment > balance + interest) actualPayment = balance + interest;
				double principal = actualPayment - interest;
				balance -= principal;
				totalInterestFirstMonth += interest;
			}
		interestSaved = totalInterest - totalInterestFirstMonth;
		System.out.printf("Extra payment only first month: $%.2f%n", userExtraPayment);
		System.out.printf("Total interest: $%.2f%n", totalInterestFirstMonth);
		double interestSavedRounded = Math.round(interestSaved * 100.0) / 100.0; // Rounds interest saved to closest integer and then divides by 100.
		System.out.printf("Total interest saved is: $%.2f%n", interestSavedRounded);	
		System.out.printf("Total months: %d%n%n", monthCounter);
			
	}
	
	// Every Month
	public static void getExtraPayEveryMonth(double userLoanAmount, double monthlyInterestRate,
			double monthlyPayment, double userExtraPayment, double totalInterest) {
		
		double balance = userLoanAmount;
		double totalInterestEveryMonth = 0;
		double interestSaved;
		int monthCounter = 0;				
		while (balance > 0) {
				double interest = balance * monthlyInterestRate;
				double actualPayment = monthlyPayment + userExtraPayment; // Recurring extra payment
				if (actualPayment > balance + interest)
					actualPayment = monthlyPayment; // Stops over payment
				double principal = actualPayment - interest;
				balance -= principal;
				totalInterestEveryMonth += interest;
				monthCounter++;
		}
		interestSaved = totalInterest - totalInterestEveryMonth;		
		System.out.printf("Extra payment every month: $%.2f%n", userExtraPayment);
		System.out.printf("Total interest: $%.2f%n", totalInterestEveryMonth);	
		double interestSavedRounded = Math.round(interestSaved * 100.0) / 100.0; // Rounds interest saved to closest integer and then divides by 100.
		System.out.printf("Total interest saved is: $%.2f%n", interestSavedRounded);	
		System.out.printf("Total Months: %d%n", monthCounter);
		
	}
}