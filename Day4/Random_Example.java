package Day4;

import java.util.Random;

public class Random_Example {

	public static void main(String[] args) {
		
		System.out.println("0.0~1.0사이의 난수 1개 발생 : "+Math.random());
		System.out.println((int)(Math.random()*10));
		
      Random rd = new Random(); //랜덤 객체 생성(디폴트 시드값 : 현재시간)
	        rd.setSeed(System.currentTimeMillis()); //시드값 설정을 따로 할수도 있음

	        System.out.println("n 미만의 랜덤 정수 리턴 : " + rd.nextInt(10)); 
	        System.out.println("무작위 boolean 값 : " + rd.nextBoolean());
	        System.out.println("무작위 long 값 : " + rd.nextLong());
	        System.out.println("무작위 float 값 : " + rd.nextFloat());
	        System.out.println("무작위 double 값 : " + rd.nextDouble());
	        System.out.println("무작위 정규 분포의 난수 값 :" + rd.nextGaussian());
	    
		
		
		
			
		for(int i=1;i<=6;i++) {
			System.out.print(rd.nextInt(45)+1);
		}
	}
	

}
