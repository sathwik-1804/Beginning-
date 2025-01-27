import java.util.Scanner;
class LinearSearch{
	public static void main(String[] args){
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int[] arr = new int[n];
	    for(int i = 0; i<arr.length; i++){
	        arr[i] = sc.nextInt();
	    }
	    int target = sc.nextInt();
	    int result = LinearSearch(arr,target);
	    System.out.println(result);
	    sc.close();
	    }
	public static int LinearSearch(int arr[],int target){
	    for(int i = 0; i < arr.length; i++){
	        if(arr[i] == target) return i;
	    }
	    return -1;
	}
}

