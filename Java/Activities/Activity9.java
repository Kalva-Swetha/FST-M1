package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> arrlist= new ArrayList<>();
		arrlist.add("Swetha");
		arrlist.add("Kavya");
		arrlist.add("Tan");
		arrlist.add("Myth");
		arrlist.add("Daksha");
		System.out.print("Array list:");
		for(String name:arrlist)
			System.out.println(name);
		System.out.println("3rd name in Array list is: "+arrlist.get(2));
		System.out.println("Array list contains kavay: "+arrlist.contains("Kavya"));
		System.out.println("Size of Array list is: "+arrlist.size());
		arrlist.remove(4);
		System.out.println("After removing size of Array list is: "+arrlist.size());

	}

}
