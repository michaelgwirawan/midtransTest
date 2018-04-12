import java.util.ArrayList;
import java.util.Scanner;

public class Problem5 {
	
	static ArrayList<Bus> station = new ArrayList<Bus>();
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		String input = in.nextLine();
		for (int i = 0 ; i < 5 ; i++) {
			String[] inp = input.split(" ");
			double arr = Double.parseDouble(inp[0]);
			double dep = Double.parseDouble(inp[1]);
			station.add(new Bus(arr, dep));
			
			input = in.nextLine();
		}
		
		int maxBus = 1;
		
		double a = station.get(0).departure; double b = station.get(1).arrival;
		for (int i = 0 ; i < station.size()-2 ; i++) {

			if (a - b > 0){
				maxBus = 2;
				if (station.get(i+2) != null){
					b = station.get(i+2).arrival;
					if (a - b > 0){
						maxBus = 3;
					}
				}
			}
			a = station.get(i+1).departure; b = station.get(i+2).arrival;
		} System.out.println(maxBus);
		
	}
	
	static class Bus{
		
		double arrival;
		double departure;
		
		public Bus(double arr, double dept){
			arrival = arr; departure = dept;
		}

		public double getArrival() {
			return arrival;
		}

		public double getDeparture() {
			return departure;
		}

	}

}
