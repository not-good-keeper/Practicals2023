import java.util.Scanner;

public class Paper3Question1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("m = ");
		int m = sc.nextInt();
		System.out.print("n = ");
		int n = sc.nextInt();
		if (!(m < n)) {
			System.out.println("INVALID INPUT");
			return;
		}
		int count = 0;
		int[] numbers = new int[n - m + 1];
		for (int i = m; i <= n; i++) {
			int factors = 2; // Prime number will only have 2 factors
			for (int j = 2; j < Math.sqrt(i); j++) {
				if ((i % j) == 0) {
					factors++; // Composite has at least more than 2 factors
				}
			}
			if (factors == 2) {
				continue; // Number is prime so skip
			}
			int eventual = i; // Stores eventual sum of digits
			while (eventual >= 10) {
				int sum = 0; // Stores sum of digits
				for (int temp = eventual; temp > 0; temp /= 10) { // Bonce :coffee:
					sum += temp % 10;
				}
				eventual = sum;
			}
			if (eventual == 1) { // Number is a composite magic number
				numbers[count++] = i;
			}
		}
		System.out.println("THE COMPOSITE MAGIC INTEGERS ARE:");
		for (int i = 0; i < count; i++) {
			System.out.print(numbers[i]);
			if (i != count - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("\nFREQUENCY OF COMPOSITE MAGIC INTEGERS IS: " + count);
	}
}
