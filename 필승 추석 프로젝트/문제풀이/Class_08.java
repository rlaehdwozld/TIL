package q8;

public class Class_08 {
	
	public static int[] shuffle(int[]arr){
		if(arr==null||arr.length==0) {
			return arr;
		}
			for( int i=0;i<arr.length;i++) {
				int j= (int )(Math.random()*arr.length);
				int tmp=arr[i];
				arr[i]=arr[j];
				arr[j]=tmp;
			}
		
		return arr;
	}
	
	
	public static void main(String[] args) {
		
		int[]original={1,2,3,4,5,6,7};
		System.out.println(java.util.Arrays.toString(original));
		int [] shuffle=shuffle(original);
		System.out.println(java.util.Arrays.toString(shuffle));
	}
}


