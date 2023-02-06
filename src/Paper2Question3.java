import java.util.Scanner;
import java.util.StringTokenizer;

public class Paper2Question3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sentence: ");
		String sentence = sc.nextLine().toUpperCase();
		System.out.println("WORD TO BE INSERTED: ");
		String word = sc.next().toUpperCase();
		System.out.println("WORLD POSITION IN THE SENTENCE: ");
		int wordPos = sc.nextInt();
		StringTokenizer tokens = new StringTokenizer(sentence);
		String formatted = "";
		int count = 1;
		int wordCnt = tokens.countTokens();
		while (tokens.hasMoreTokens()) {
			String token = tokens.nextToken();
			if (count == wordPos) {
				formatted += word + " ";
			}
			formatted += token + " ";
			count++;
		}
		System.out.println(formatted);
	}
}
