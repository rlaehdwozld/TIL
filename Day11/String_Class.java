package Day4;

public class String_Class {
	public static void main(String[] args) {
		
		String str="hello";
		String concatstr=str.concat("world");
		str.concat(concatstr);
		
		boolean bo = str.contains("e");
		System.out.println(bo);
		
		String filename="hello java world";
		System.out.println(filename.indexOf("a"));
		System.out.println(filename.indexOf("java"));
		System.out.println(filename.indexOf("a"));
		
		if(filename.indexOf("wo")!=-1) {
			System.out.println("wo단어가 하나라도 있다");
		}
		System.out.println(filename.lastIndexOf("a"));
		
		String result="superman";
		System.out.println(result.substring(0));
		System.out.println(result.substring(4));
		System.out.println(result.substring(4,6));
		System.out.println(result.substring(0,0));
		System.out.println(result.substring(0,1));
		
		
		String filename2="home.jpg";
		
		int position = filename2.indexOf(".");
		System.out.println(position);
		String extension = filename2.substring(0,position);
		System.out.println(extension);
		String extension2=filename2.substring(position+1,filename2.length() );
		System.out.println(extension2);
		
		
		
		
	}

}
