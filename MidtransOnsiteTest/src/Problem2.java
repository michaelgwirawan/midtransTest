import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Problem2 {
	
	static ArrayList<User> users = new ArrayList<User>();
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		HashMap<String, User> emailsOwner = new HashMap<String, User>();
		HashMap<String, User> phonesOwner = new HashMap<String, User>();
		HashMap<String, User> cardsOwner = new HashMap<String, User>();
		
		while (true){
			
			System.out.println("Transaction input");
			System.out.printf("id: "); String id = in.nextLine();
			System.out.printf("email: "); String email= in.nextLine();
			System.out.printf("phone: "); String phone = in.nextLine();
			System.out.printf("card: "); String card = in.nextLine();
			
			boolean emailDuplicate = false; boolean phoneDuplicate = false; boolean cardDuplicate = false;
			
			if (emailsOwner.containsKey(email)){
				emailDuplicate = true;
			} else if (phonesOwner.containsKey(phone)){
				phoneDuplicate = true;
			} else if (cardsOwner.containsKey(card)){
				cardDuplicate = true;
			}
			else{
				User user = new User(id, email, phone, card);
				users.add(user);
				emailsOwner.put(email, user); phonesOwner.put(phone, user); cardsOwner.put(card, user);
			}
			
			if (emailDuplicate){
				User toAdd = emailsOwner.get(email);
				toAdd.addCard(card); toAdd.addId(id); toAdd.addPhone(phone);
			} else if (phoneDuplicate){
				User toAdd = phonesOwner.get(phone);
				toAdd.addCard(card); toAdd.addEmail(email); toAdd.addId(id);
			} else if (cardDuplicate){
				User toAdd = cardsOwner.get(card);
				toAdd.addEmail(email); toAdd.addId(id); toAdd.addPhone(phone);
			}
			
			
		}
		
	}
	
	public void merge(User user1, User user2){
		//TO DO: implement merge user
	}
	
	static public class User{
		
		ArrayList<String> transactionID;
		ArrayList<String> email;
		ArrayList<String> phone;
		ArrayList<String> card;
		
		public User(String id, String email, String phone, String card){
			this.transactionID.add(id);
			this.email.add(email);
			this.phone.add(phone);
			this.card.add(card);
		}
		
		public ArrayList<String> getId(){
			return transactionID;
		}
		
		public ArrayList<String> getEmail(){
			return email;
		}
		
		public ArrayList<String> getPhone(){
			return phone;
		}
		
		public ArrayList<String> getCard(){
			return card;
		}
		
		public void addId(String id){
			this.transactionID.add(id);
		}
		
		public void addEmail(String email){
			this.email.add(email);
		}
		
		public void addPhone(String phone){
			this.phone.add(phone);
		}
		
		public void addCard(String card){
			this.card.add(card);
		}
		
	}

}
