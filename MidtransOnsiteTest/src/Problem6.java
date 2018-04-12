import java.util.ArrayList;
import java.util.Scanner;

public class Problem6 {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
    
    public static int numberNeeded(String a, String b){
        ArrayList<Character> arrlist = new ArrayList<Character>();
        if (a.length() > b.length()){
            for (int i = 0 ; i < b.length() ; i ++){
                if (a.contains(Character.toString(b.charAt(i)))){
                    arrlist.add(b.charAt(i));
                    a = a.replaceFirst(Character.toString(b.charAt(i)), "=");
                    b = b.replaceFirst(Character.toString(b.charAt(i)), "=");
                }
            }
        } else if (a.length() < b.length()){
            for (int i = 0 ; i < a.length() ; i ++){
                if (b.contains(Character.toString(a.charAt(i)))){
                    arrlist.add(a.charAt(i));
                    b = b.replaceFirst(Character.toString(a.charAt(i)), "=");
                    a = a.replaceFirst(Character.toString(a.charAt(i)), "=");     
                }
            }
        } else{
        	for (int i = 0 ; i < a.length() ; i ++){
                if (b.contains(Character.toString(a.charAt(i)))){
                    arrlist.add(a.charAt(i));
                    b = b.replaceFirst(Character.toString(a.charAt(i)), "=");
                    a = a.replaceFirst(Character.toString(a.charAt(i)), "=");
                }
            }
        }
        
        int nums = 0;
        
        for (int i = 0 ; i < a.length() ; i ++){
        	if (a.charAt(i) != '='){
        		nums ++;
        	}
        }
        for (int i = 0 ; i < b.length() ; i ++){
        	if (b.charAt(i) != '='){
        		nums ++;
        	}
        }
        return nums;
    }

}
