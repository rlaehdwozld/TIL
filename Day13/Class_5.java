package 명품자바;


import java.util.Scanner;

//class Circle{
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
}

public class Class_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle c [] = new Circle [3];

        for (int i = 0; i < c.length; i++) {
            System.out.print("x :");
            System.out.print("y :");
            System.out.print("radius :");
            c[i] = new Circle(sc.nextDouble(),sc.nextDouble(),sc.nextInt());
            
            
        }

        for (int i = 0; i < c.length; i++) {
            c[i].show();
        }
        sc.close();
    }
}