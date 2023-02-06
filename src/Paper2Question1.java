import java.util.Scanner;
import java.util.StringTokenizer;

public class Paper2Question1 {
	public static void main(String[] args) {
		// Indices of the days of the week
		String[] daysOfTheWeek = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
		// Days in every month for a regular year
		int[] daysInMonthRegularYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		// Days in every month for a leap year
		int[] daysInMonthLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		Scanner sc = new Scanner(System.in);
		System.out.print("ENTER PROJECT DATE: ");
		String projectDate = sc.next();
		System.out.print("DAY OF THE WEEK:    ");
		String dayOfTheWeek = sc.next();

		int dayIndex = 0;
		for (int i = 0; i < daysOfTheWeek.length; i++) {
			if (daysOfTheWeek[i].equals(dayOfTheWeek)) {
				dayIndex = i;
				break;
			}
		}

		StringTokenizer dateTokens = new StringTokenizer(projectDate, "/");
		if (dateTokens.countTokens() != 3) { // Malformed date
			System.out.println("INVALID DATE");
			return;
		}
		int day = Integer.parseInt(dateTokens.nextToken());
		int month = Integer.parseInt(dateTokens.nextToken());
		if (month > 12) { // Invalid month
			System.out.println("INVALID DATE");
			return;
		}
		int year = Integer.parseInt(dateTokens.nextToken());
		boolean leap = year % 4 == 0 && !(year % 100 == 0 && year % 400 != 0);
		int[] daysPerYear = leap ? daysInMonthLeapYear : daysInMonthRegularYear;
		if (day > daysPerYear[month - 1]) { // Date out of bonds
			System.out.println("INVALID DATE");
			return;
		}

		int totalDaysAhead = 89; // 90 days including current day
		int nextDayIndex = (dayIndex + totalDaysAhead) % 7;
		if (nextDayIndex == 0) { // Give an extra day if it is sunday
			nextDayIndex += 1;
			totalDaysAhead += 1;
		}
		// Incrementally update the date
		while (totalDaysAhead > 0) {
			int daysRemaining = daysPerYear[month - 1] - day;
			if (daysRemaining > 0) {
				// If there are days remaining in the current month, try to fill the current month
				int daysAhead = Math.min(daysRemaining, totalDaysAhead);
				day += daysAhead;
				totalDaysAhead -= daysAhead;
			} else {
				// If there are no more days remaining in the current month, go to the next month
				if (month == 12) {
					// If the last month is reached, go to the first month of the next year
					year += 1; // Go to next year
					month = 1; // Go to first month
					// Refresh leap year status to fix some edge cases
					leap = year % 4 == 0 && !(year % 100 == 0 && year % 400 != 0);
					daysPerYear = leap ? daysInMonthLeapYear : daysInMonthRegularYear;
				} else {
					// Else go to the next month
					month += 1;
				}
				int daysAhead = Math.min(daysPerYear[month - 1], totalDaysAhead);
				day = daysAhead;
				totalDaysAhead -= daysAhead;
			}
		}
		String formattedDate = day + "/" + month + "/" + year;
		System.out.println("PROJECT TO BE SUBMITTED ON: " + formattedDate);
		System.out.println("DAY OF THE WEEK:            " + daysOfTheWeek[nextDayIndex]);
	}
}
