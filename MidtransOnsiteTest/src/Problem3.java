import java.util.Scanner;

public class Problem3 {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		while (true){
			String input = in.nextLine();
			System.out.println(normalize(input));
		}
		
	}
	
	public static String normalize(String input){
		
		if (input.length() == 1){
			return input;
		}
		
		input = input.replaceAll("\\p{Alpha}", ""); //trims alphabetic chars
		input = input.replaceAll("\\p{Punct}", ""); //trims punctuation: !-@# etc
		input = input.replaceAll(" ", ""); //trims spaces
		
		if (input.startsWith("0")){
			input = input.replaceFirst("0", "62");
		}
		
		return input;
	}


}
