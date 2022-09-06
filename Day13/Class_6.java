package 명품자바;


import java.util.Scanner;

class Circle{
    private double x, y;
    private int radius;

    public Circle(double x, double y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public void show(){

    	System.out.printf("(%f,%.1f)%d\n",x,y,radius);
    }
    int getR() {
    	return radius;
    }
}

public class Class_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle c [] = new Circle [3];

        for (int i = 0; i < c.length; i++) {
            System.out.print("x :");
            System.out.print("y :");
            System.out.print("radius :");
            c[i] = new Circle(sc.nextDouble(),sc.nextDouble(),sc.nextInt());
            
            
        }
        int temp=0;
        for (int i = 1; i < c.length; i++) {
            if(c[temp].getR()<c[i].getR()){
            	temp=i;
            }
        }
        System.out.print("가장 면적이 큰 원은"	);
        c[temp].show();
        sc.close();
    }
}