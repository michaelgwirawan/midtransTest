import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1 {
	
public static void main (String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String total = in.readLine();
		
		for (int i = 0 ; i < (Integer.parseInt(total)) ; i++){
			String banyakKata = in.readLine();
			
			String[][] prefix = new String[Integer.parseInt(banyakKata)][];
			
			for (int j = 0 ; j < (Integer.parseInt(banyakKata)) ; j++){
				String kata = in.readLine();
				prefix[j] = new String[kata.length()];
				for (int k = 0 ; k < kata.length() ; k++){
					prefix[j][k] = Character.toString(kata.charAt(k));
				}
			}
			
			int lenKataMin = prefix[0].length;
			int indexMin = 0;
			for (int j = 0 ; j < prefix.length ; j++){
				if (prefix[j].length < lenKataMin){
					lenKataMin = prefix[j].length;
					indexMin = j;
				}
			}
			
			String longest = "";
			
			boolean flag = true;
			for (int k = 0 ; k < lenKataMin ; k++){
				if (flag == false){
					break;
				}
				String toCheck = prefix[indexMin][k];
				for (int l = 0 ; l < (Integer.parseInt(banyakKata)) ; l++){
					
					if (flag == false){
						break;
					}
					
					if (prefix[l][k].equalsIgnoreCase(toCheck) && l != Integer.parseInt(banyakKata)-1){
						continue;
					} else if (prefix[l][k].equalsIgnoreCase(toCheck) && l == Integer.parseInt(banyakKata)-1){
						longest += toCheck;
					} else if (!prefix[l][k].equalsIgnoreCase(toCheck)){
						flag = false; 
					}
					
				}
				
			}
			
			System.out.println("Case #" + (i+1) + ": " + longest);
			
		}
		
	}

}
