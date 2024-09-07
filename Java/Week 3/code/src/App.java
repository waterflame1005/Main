import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Input Values
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter yearly interest rate:");
        double yearlyInterestRate = myObj.nextDouble();  // Read user input
        //0.15
        System.out.println("Enter loan years:");
        double loanYears = myObj.nextDouble();  // Read user input
        //2
        System.out.println("Enter loan aount:");
        double loanAmount = myObj.nextDouble();  // Read user input
        //100.25

        double monthlyInterestRate = yearlyInterestRate / 12.0;
        double numberOfPeriods = loanYears * 12;
        double discount = (Math.pow(1 + monthlyInterestRate, numberOfPeriods) - 1)
                / (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPeriods));
        double monthlyPayment = loanAmount / discount;
        double totalPayment = monthlyPayment * numberOfPeriods;

        System.out.println("You requested a loan of " + loanAmount + "$, repaying it over " + loanYears
                + " years, with an interest rate of " + yearlyInterestRate * 100 + "%.");
        System.out
                .println("Your monthly payment will be " + Math.floor(monthlyPayment * 100) / 100d + "$ per month for "
                        + numberOfPeriods + " months, for a total of " + Math.floor(totalPayment * 100) / 100d + "$.");
        // Input Values
        System.out.println("Enter investor amount:");
        double investorAmount = myObj.nextDouble();  // Read user input
        //0.15
        System.out.println("Enter present value:");
        double presentValue = myObj.nextDouble();  // Read user input
        //2.1
        System.out.println("Enter growth rate:");
        double growthRate = myObj.nextDouble();  // Read user input
        //0.1
        System.out.println("Enter investor percentage:");
        double investorPercentage = myObj.nextDouble();  // Read user input
        //0.01
        System.out.println("Enter time:");
        double time = myObj.nextDouble();  // Read user input
        //5.0

        double companyFutureValue = presentValue * Math.pow(1 + growthRate, time);
        double investorFutureValue = investorPercentage * companyFutureValue;
        double ownerFutureValue = companyFutureValue - (investorAmount + investorFutureValue);

        System.out.println("You have invested " + investorAmount + " million dollars into a company worth " +
                presentValue + " million dollars to buy " + investorPercentage * 100 +
                "% of the company. The company is expected to grow " + growthRate * 100 + "% in the next " + time
                + " years.");
        System.out.println("The expected future value for the owner is " + Math.floor(ownerFutureValue * 100) / 100d
                + " million dollars.");
    }
}
