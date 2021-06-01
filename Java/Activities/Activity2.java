package activities;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10, 77, 10, 54, -11, 10};
	
		System.out.println(check_array(arr));
	}
		public static boolean check_array(int arr1[])
		{
			int total=0,fixed=30;
			int find_Value=10;
			for(int i:arr1)
			{
				if(i==find_Value)
					total=total+i;
				if(total>fixed)
					break;
					
			}
			
			return total==fixed;
		}
		

	}


