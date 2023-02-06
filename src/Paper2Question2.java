import java.util.Scanner;

public class Paper2Question2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("N = ");
		int n = sc.nextInt();
		if (!(n > 3 && n < 10)) {
			System.out.println("SIZE OUT OF RANGE");
			return;
		}
		int[] boundaryElements = new int[(n - 1) * 4];
		int idx = 0; // Stores next index to store values in boundaryElements
		int product = 1; // Sum of non-boundary elements
		int[][] mat = new int[n][n];
		System.out.println("Enter the elements of the matrix");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int num = sc.nextInt();
				mat[i][j] = num;
				// If the element is a boundary element, add it to boundaryElements array
				if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
					boundaryElements[idx++] = num;
				} else {
					product *= num;
				}
			}
		}
		System.out.println("ORIGINAL MATRIX");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

		// Sort boundaryElements using insertion sort
		for (int i = 0; i < boundaryElements.length; i++) {
			int key = boundaryElements[i];
			int j = i - 1;
			while (j >= 0 && boundaryElements[j] > key) {
				boundaryElements[j + 1] = boundaryElements[j];
				j -= 1;
			}
			boundaryElements[j + 1] = key;
		}

		// Replace values in the original matrix
		int currentRow = 0;
		int currentCol = 0;
		for (int i = 0; i < boundaryElements.length; i++) {
			mat[currentRow][currentCol] = boundaryElements[i];
			if (currentCol < n - 1 && currentRow == 0) { // First row
				currentCol++;
			} else if (currentCol == n - 1 && currentRow < n - 1) { // Last column
				currentRow++;
			} else if (currentCol > 0 && currentRow == n - 1) { // Last row
				currentCol--;
			} else if (currentCol == 0) { // First column
				currentRow--;
			}
		}

		System.out.println("REARRANGED MATRIX");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("NON BOUNDARY ELEMENTS");
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("PRODUCT OF THE NON BOUNDARY ELEMENTS = " + product);
	}
}
