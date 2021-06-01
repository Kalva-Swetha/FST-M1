package activities;
abstract class Book{
	String title;
	public  String getTitle()
	{
		return title;
	}
	public void setTitle(String t1)
	{
		title=t1;
	}
}
public class Activity5 extends Book {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Activity5 newNovel=new Activity5();
		newNovel.setTitle("Ramayan");
		System.out.println("Book name: "+newNovel.getTitle());
		

	}

}
