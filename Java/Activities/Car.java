package activities;

 public class Car {
	String color;
	String transmission;
	int make,tyres,doors;
	Car(String color,String transmission,int make)
	{
		this.color=color;
		this.transmission=transmission;
		this.make=make;
		this.tyres=4;
		this.doors=4;
	}
	public void displayCharactiristics()
	{
		System.out.println("Color of car is:"+color+ " \n"+ "Transimission:" +transmission+"\n" + "Manufactured Year: "+ make+ " \n"+"No of Tyres and Doors: "+ tyres+ " "+doors);
	}
	public void accelarate()
	{
		System.out.println("Car is moving forward");
	}
	public void brake()
	{
		System.out.println("Car has stopped");
	}
 }

 
