package q8;
class Car{
	private int width;
	private int height;
	private int length;
	
	private String name;
	private String number;
	
	private double X;
	private double	Y;
	private double tankage;
	private double fuel;
	private double sfc;
	
	public Car(int width, int height, int length, String name, String number, double x, double y, double tankage,
			double fuel, double sfc) {
		super();
		this.width = width;
		this.height = height;
		this.length = length;
		this.name = name;
		this.number = number;
		X = x;
		Y = y;
		this.tankage = tankage;
		this.fuel = (fuel<=tankage)? fuel : tankage;
		this.sfc = sfc;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getX() {
		return X;
	}

	public void setX(double x) {
		X = x;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		Y = y;
	}

	public double getTankage() {
		return tankage;
	}

	public void setTankage(double tankage) {
		this.tankage = tankage;
	}

	public double getFuel() {
		return fuel;
	}

	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

	public double getSfc() {
		return sfc;
	}

	public void setSfc(double sfc) {
		this.sfc = sfc;
	}

	Car(){
	
	}
	
	void location(double X, double Y) {
		System.out.println("("+X+","+Y+")");
	}
	

}
public class Class_03 {
	public static void main(String[] args) {
		Car car= new Car();
		car.setX(10)	;
		car.getX()	;
		car.location(10, 20);
		
		car.getFuel();
		
	}

}
