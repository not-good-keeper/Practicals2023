import java.util.Scanner;
import java.util.StringTokenizer;

public class Paper1Question3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("CODE: ");
		String code = sc.next();
		for (int i = 0; i < code.length(); i++) {
			char ch = code.charAt(i);
			if (ch < '0' || ch > '9') { // Return if not a number
				System.out.println("INVALID INPUT");
				return;
			}
		}
		String decoded = "";
		for (int i = 0; i < code.length(); i++) {
			int parsedNum = code.charAt(i) - '0';
			parsedNum *= 10;
			i++; // Move to next character
			parsedNum += code.charAt(i) - '0';
			if (parsedNum != 32 // Not a space
					&& !(parsedNum >= 65 && parsedNum <= 90) // Not an uppercase letter
					&& !(parsedNum >= 97) // Not a lowercase letter between 97 and 99
			) {
				parsedNum *= 10;
				i++; // Move to next character
				parsedNum += code.charAt(i) - '0';
				if (!(parsedNum <= 122)) { // Not a lowercase letter between 100 and 122
					i--; // Move to previous character
					continue; // Skip character as it is not acceptable
				}
			}
			if (parsedNum == ' ') {
				if (decoded.charAt(decoded.length() - 1) == ' ') { // Skip extra spaces
					continue;
				}
			}
			decoded += (char) parsedNum;
		}
		// Format the sentence
		StringTokenizer tokens = new StringTokenizer(decoded);
		String formatted = "";
		while (tokens.hasMoreTokens()) {
			String token = tokens.nextToken().toLowerCase();
			formatted += token.substring(0, 1).toUpperCase(); // First character uppercase
			formatted += token.substring(1); // Other characters lowercase
			if (tokens.hasMoreTokens()) {
				formatted += " "; // Space
			}
		}
		System.out.println(formatted);
	}
}
