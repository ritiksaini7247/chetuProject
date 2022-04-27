package com.chetu.firstassignment;

import java.util.Scanner;

public class MainClass {

	/*
	 * Get Employee Payment Based on her/his package and her/his
	 * type(permanent/temporary)
	 */
	public static Float getPaymentBasedOnPackage(float noOfPackage, boolean isPermanentEmployee) {
		Float paymentBasedOnPackage;
		if (isPermanentEmployee)
			paymentBasedOnPackage = (float) (noOfPackage * 50);
		else
			paymentBasedOnPackage = (float) (noOfPackage * 30);
		return paymentBasedOnPackage;
	}

	/* Get Employee Payment based on grade */
	public static Float getPaymentBasedOnGrade(String grade, float basicPay) {
		Float paymentBasedOnGrade;
		if (grade.equals("A1") || grade.equals("a1"))
			paymentBasedOnGrade = (basicPay * 5) / 100;
		else if (grade.equals("A2") || grade.equals("a2"))
			paymentBasedOnGrade = (basicPay * 10) / 100;
		else if (grade.equals("A3") || grade.equals("a3"))
			paymentBasedOnGrade = (basicPay * 15) / 100;
		else
			paymentBasedOnGrade = basicPay;
		return paymentBasedOnGrade;
	}

	public static void main(String[] args) {

		float basicPayment = 0;
		float paymentBasedOnNightShift = 0;
		float paymentBasedOnGrade = 0;
		float paymentBasedOnPackage = 0;
		float paymentBasedOnTravel = 0;
		float totalExtraPayment = 0;

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print(
				"Enter the type of Employee.....\n\tIf employee is permanent press 'p' / 'P'\n\tIf employee is temporary press 't' / 'T'\n\t\tPress......:-   ");
		String typeOfEmployee = scanner.next();
		/* IF Employee is permanent */
		if (typeOfEmployee.equals("p") || typeOfEmployee.equals("P")) {
			System.out.print("Enter the number of packages delivered by permanent employee..:-  ");
			float noOfDeliveredPackages = scanner.nextFloat();
			/* Count payment based on package */
			paymentBasedOnPackage = getPaymentBasedOnPackage(noOfDeliveredPackages, true);
			/* Count total payment based on travel */
			System.out.print("Enter days travel by permanent employee :- ");
			float travelledDays = scanner.nextFloat();
			paymentBasedOnTravel = travelledDays * 75;

			/* Count total payment based on night shift */
			System.out.print(
					"Has he/she done the night shift....?\n\tIf Yess press 'Y'/'y' else 'N'/'n' \n\t\tPress....:- ");
			String nightShift = scanner.next();
			int rnsDays = 0;
			String rgrade = null;
			if (nightShift.equals("y") || nightShift.equals("Y")) {
				System.out.print("How many days he/she done the night shift...:- ");
				int nsDays = scanner.nextInt();
				rnsDays = nsDays;
				paymentBasedOnNightShift = nsDays * 166.66f;
				/* Count total payment based on grade */
				System.out.print("Enter employee grade (A1/a1/A2/a2/A3/a3)    Press....:- ");
				String grade = scanner.next();
				rgrade = grade;
				paymentBasedOnGrade = getPaymentBasedOnGrade(grade, 5000);
			} else if (nightShift.equals("n") || nightShift.equals("N")) {
				/* Count total payment based on grade */
				System.out.print("Enter employee grade (A1/a1/A2/a2/A3/a3)    Press....:- ");
				String grade = scanner.next();
				rgrade = grade;
				paymentBasedOnGrade = getPaymentBasedOnGrade(grade, 5000);
			}
			System.out.println("\n\n---------------------------------------------------------------------");
			System.out.println("Description of basic payment of permanent employee....\n(1)  " + noOfDeliveredPackages
					+ " of package delivers (" + noOfDeliveredPackages + " * 50$(per package)) = "
					+ paymentBasedOnPackage + "$");
			System.out.println("(2)  Travelled distance (" + travelledDays + " days * 75$(daily allowance)) = "
					+ (travelledDays * 75) + "$");
			if (nightShift.equals("y") || nightShift.equals("Y"))
				System.out.println("(3)  Night Shift (TRUE). Days of night shift..:- " + rnsDays + "   (" + rnsDays
						+ ", 10% of regular pay(166.66)) = " + (rnsDays * 166.66f) + "$");
			else
				System.out.println("Night Shift (FALSE)");
			System.out.println("(4)  Grade is " + rgrade + "...So ");
			if (rgrade.equals("a1") || rgrade.equals("A1"))
				System.out.print("reward is 5% of 5000$ = " + ((5000 * 5) / 100) + "$");
			else if (rgrade.equals("a2") || rgrade.equals("A2"))
				System.out.print("reward is 10% of 5000$ = " + ((5000 * 10) / 100) + "$");
			else if (rgrade.equals("a3") || rgrade.equals("A3"))
				System.out.print("reward is 15% of 5000$ = " + ((5000 * 15) / 100) + "$");
			else
				System.out.print("reward is (no_reward) = 0");
			totalExtraPayment = paymentBasedOnPackage + paymentBasedOnTravel + paymentBasedOnNightShift
					+ paymentBasedOnGrade;
			System.out.println("\n-----------------------------------------------------------------------");
			System.out.println("\n\nExtra payment is = " + totalExtraPayment + "$");
			System.out.println("Total basic salary of employee is = " + (5000 + totalExtraPayment) + "$");

		}
		/* If employee type is temporary */
		else if (typeOfEmployee.equals("t") || typeOfEmployee.equals("T")) {
			System.out.print("Enter the number of packages delivered by temporary employee..:-  ");
			float noOfDeliveredPackages = scanner.nextFloat();
			/* Count payment based on package */
			paymentBasedOnPackage = getPaymentBasedOnPackage(noOfDeliveredPackages, false);
			/* Count total payment based on travel */
			System.out.print("Enter days travel by permanent employee :- ");
			float travelledDays = scanner.nextFloat();
			paymentBasedOnTravel = travelledDays * 65;

			/* Count total payment based on night shift */
			System.out.print(
					"Has he/she done the night shift....? \n\t If Yess press 'Y'/'y' else 'N'/'n' \n\t\t Press....:- ");
			String nightShift = scanner.next();
			int rnsDays = 0;
			String rgrade = null;
			if (nightShift.equals("y") || nightShift.equals("Y")) {
				System.out.print("How many days he/she done the night shift...:- ");
				int nsDays = scanner.nextInt();
				rnsDays = nsDays;
				paymentBasedOnNightShift = nsDays * 166.66f;
				/* Count total payment based on grade */
				System.out.print("Enter employee grade (A1/a1/A2/a2/A3/a3)    Press....:- ");
				String grade = scanner.next();
				rgrade = grade;
				paymentBasedOnGrade = getPaymentBasedOnGrade(grade, 5000);
			} else if (nightShift.equals("n") || nightShift.equals("N")) {
				/* Count total payment based on grade */
				System.out.print("Enter employee grade (A1/a1/A2/a2/A3/a3)    Press....:- ");
				String grade = scanner.next();
				rgrade = grade;
				paymentBasedOnGrade = getPaymentBasedOnGrade(grade, 5000);
			}
			System.out.println("\n\n---------------------------------------------------------------------");
			System.out.println("Description of basic payment of temporary employee....\n(1)  " + noOfDeliveredPackages
					+ " of package delivers (" + noOfDeliveredPackages + " * 30$(per package)) = "
					+ paymentBasedOnPackage + "$");
			System.out.println("(2)  Travelled distance (" + travelledDays + " days * 65$(daily allowance)) = "
					+ (travelledDays * 65) + "$");
			if (nightShift.equals("y") || nightShift.equals("Y"))
				System.out.println("(3)  Night Shift (TRUE). Days of night shift..:- " + rnsDays + "   (" + rnsDays
						+ ", 10% of regular pay(166.66)) = " + (rnsDays * 166.66f) + "$");
			else
				System.out.println("Night Shift (FALSE)");
			System.out.println("(4)  Grade is " + rgrade + "...So ");
			if (rgrade.equals("a1") || rgrade.equals("A1"))
				System.out.print("reward is 5% of 5000$ = " + ((5000 * 5) / 100) + "$");
			else if (rgrade.equals("a2") || rgrade.equals("A2"))
				System.out.print("reward is 10% of 5000$ = " + ((5000 * 10) / 100) + "$");
			else if (rgrade.equals("a3") || rgrade.equals("A3"))
				System.out.print("reward is 15% of 5000$ = " + ((5000 * 15) / 100) + "$");
			else
				System.out.print("reward is (no_reward) = 0");
			totalExtraPayment = paymentBasedOnPackage + paymentBasedOnTravel + paymentBasedOnNightShift
					+ paymentBasedOnGrade;
			System.out.println("\n-----------------------------------------------------------------------");
			System.out.println("\n\nExtra payment is = " + totalExtraPayment + "$");
			System.out.println("Total basic salary of employee is = " + (5000 + totalExtraPayment) + "$");

		} else {
			System.err.println("Sorry you choose wrong option try again..! !");
			float basicPayment2 = 2000;
			System.out.println(getPaymentBasedOnGrade("a1", basicPayment2));
		}

	}

}
