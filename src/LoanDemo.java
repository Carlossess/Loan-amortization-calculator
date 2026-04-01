/*
 * Author: Carlos, Micah, George, Angel
 *   Date: December 10th 2025
 *Purpose: Create an amortization calculator
 */
public class LoanDemo extends Loan{

	public static void main(String[] args) {
		// Local Variables
		
		
		double userInterestRate, userLoanAmount, userExtraPayment, // User Inputs
		monthlyPayment, totalInterest, totalPayment, monthlyInterestRate; // Calculated Inputs
		int numOfYears, numOfMonths; // Duration of time
	
		
		java.util.Date date = new java.util.Date(); // Creates new date object
	
		// User input
		while (true) {
		try {
			System.out.print("Enter annual interest rate, for example, 8.25: ");
			double originalInterestRate = input.nextDouble();
			while (originalInterestRate < 0 || originalInterestRate > 100) {
				System.err.print("Please enter a value between 0-100: ");
				originalInterestRate = input.nextDouble();
			}
			userInterestRate = originalInterestRate / 100.0;
			System.out.print("Enter number of years as an integer: ");
			numOfYears = input.nextInt();
			while (numOfYears <= 0) {
				System.err.print("Please enter a value greater than 0: ");
				numOfYears = input.nextInt();
			}
			System.out.print("Enter loan amount, for example, 1200000.95: ");
			userLoanAmount = input.nextDouble();
			while (userLoanAmount <= 0) {
				System.err.print("Please enter a value greater than 0: ");
				userLoanAmount = input.nextDouble();
			}
			System.out.print("Enter extra payment amount, for example, 1000.0: ");
			userExtraPayment = input.nextDouble();
			while (userExtraPayment <= 0) {
				System.err.print("Please enter a value greater than 0: ");
				userExtraPayment = input.nextDouble();
			}
		
		// User loan was created on *date*
		System.out.println("The loan was created on " + date.toString());
		
		numOfMonths = numOfYears * 12;
		monthlyInterestRate = userInterestRate / 12;
		monthlyPayment = (userLoanAmount * monthlyInterestRate) / (1.0 - (1.0 / Math.pow(1 + (monthlyInterestRate), numOfMonths)) );
		totalInterest = (monthlyPayment - (userLoanAmount / numOfMonths)) * numOfMonths;
		totalPayment = userLoanAmount + totalInterest;
		
		System.out.printf("Your monthly payment is: %.2f%n", monthlyPayment);
		System.out.printf("The total payment is: %.2f%n", totalPayment);
		System.out.printf("The total interest is: %.2f%n%n", totalInterest);
		
		// Payment first month only
		getExtraPayFirstMonth(userLoanAmount, monthlyInterestRate, monthlyPayment, userExtraPayment, totalInterest);
		
		// Payment every month
		getExtraPayEveryMonth(userLoanAmount, monthlyInterestRate,
		 monthlyPayment, userExtraPayment, totalInterest);
		
		break;
		
		} catch (Exception e) { // Catches every exception 
			System.err.println("Please follow instructions");
			input.nextLine(); // Burns extra line
		}
	}
		input.close(); // Close Scanner
}
}