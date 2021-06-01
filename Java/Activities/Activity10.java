package activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> hs=new HashSet<>();
		hs.add("Rose");
		hs.add("Jasmin");
		hs.add("Lilly");
		hs.add("Alovera");
		hs.add("Hybiscus");
		hs.add("Betroot");
		System.out.println("Size of Hash set is: "+hs.size());
		hs.remove("Jasmin");
		if(hs.remove("Kiwi")) {
        	System.out.println("Kiwi removed from the Set");
        } else {
        	System.out.println("Kiwi is not present in the Set");
        }
		System.out.println("Is carrot there in set? "+hs.contains("Carrot"));
		System.out.print("Updated set is: "+hs);
		
		
	}

}
