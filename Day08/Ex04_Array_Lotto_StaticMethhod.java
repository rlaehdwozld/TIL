
public class Ex04_Array_Lotto_StaticMethhod {


static void swap(int [] arr , int source , int target) {
		   int tmp = arr[source];
		   arr[source]  = arr[target];
		   arr[target] = tmp;
	   }	
	   
	   static void printArray(int[] arr) {
		   for(int  data : arr) {
			   System.out.print(data + ", ");
		   }
		   System.out.println();
	   }
	   
	   static void bubbleSort(int[] arr) {
		   bubbleSort(arr, arr.length -1);
	   }
	   
	   static void bubbleSort(int[] arr , int last) {
		   if(last > 0 ) {
			    for(int i = 1 ; i <= last ; i++) {
			    	 if(arr[i-1] > arr[i]) {
			    		 swap(arr, i - 1 , i);
			    	 }
			    }
			    bubbleSort(arr, last - 1 );
			    	 
		   }

	   }​
	   }

