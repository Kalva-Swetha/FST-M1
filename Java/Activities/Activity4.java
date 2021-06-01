package activities;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int arr[]= {5,6,1,3,9,2};
    
     System.out.print("Before sorting: ");
     for(int i:arr)
     System.out.print(i+" ");
     for (int i = 0; i < arr.length; i++)   
     {  
     for (int j = i + 1; j < arr.length; j++)   
     {  
     int tmp = 0;  
     if (arr[i] > arr[j])   
     {  
     tmp = arr[i];  
     arr[i] = arr[j];  
     arr[j] = tmp;  
     }  
     }
     }
     System.out.print("\nAfter sorting: ");
	for(int i:arr)
	     System.out.print(i+" ");
}
}
