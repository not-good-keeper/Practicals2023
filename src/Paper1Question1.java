import java.util.Scanner;

public class Paper1Question1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		String num = sc.next();
		int prevNum = 0;
		boolean increasing = true;
		boolean decreasing = true;
		for (int i = 0; i < num.length(); i++) {
			char ch = num.charAt(i);
			if (ch > '9' || ch < '0') { // Return if invalid character is present
				System.out.println("INVALID INPUT");
				return;
			}
			int currentNum = ch - '0';
			if (currentNum > prevNum) {
				if (i != 0) { // Skip check for first digit as there is no previous digit
					decreasing = false; // If next digit is greater than previous digit, number is not decreasing
				}
			} else if (currentNum < prevNum) {
				increasing = false; // If previous digit is greater than next digit, number is not increasing
			}
			prevNum = currentNum;
		}
		if (increasing) {
			System.out.println(num + " IS AN INCREASING NUMBER");
		} else if (decreasing) {
			System.out.println(num + " IS A DECREASING NUMBER");
		} else { // Neither increasing nor decreasing
			System.out.println(num + " IS A BONCE NUMBER");
		}
	}
}
