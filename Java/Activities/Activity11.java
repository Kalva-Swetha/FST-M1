package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> colours=new HashMap<>();
		colours.put(1,"Black");
		colours.put(2,"Red");
		colours.put(3,"White");
		colours.put(4,"Blue");
		colours.put(5,"Green");
		System.out.println(colours);
		colours.remove(2);
		System.out.println("Is Red is available in Map: "+colours.containsValue("Red"));
		
		System.out.println("Map size "+colours.size());
	}

}
