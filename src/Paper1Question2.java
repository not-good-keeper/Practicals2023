import java.util.Scanner;

public class Paper1Question2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("N = ");
		int n = sc.nextInt();
		if (!(n > 3 && n < 10)) {
			System.out.println("SIZE IS OUT OF RANGE");
			return;
		}
		System.out.print("Enter First Character: ");
		char first = sc.next().charAt(0);
		System.out.print("Enter Second Character: ");
		char second = sc.next().charAt(0);
		System.out.print("Enter Third Character: ");
		char third = sc.next().charAt(0);
		char[][] mat = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i == 0 || i == n - 1) && (j == 0 || j == n -1)) { // Corner
					mat[i][j] = first;
				} else if (i == 0 || i == n - 1 || j == 0 || j == n -1) { // Edge
					mat[i][j] = second;
				} else {
					mat[i][j] = third;
				}
			}
		}
		System.out.println("FORMED MATRIX");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
