package q8;
class Human1{
	private int Height;
	private int weight;
	private String name;
	public int getHeight() {
		return Height;
	}
	public void setHeight(int height) {
		Height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	Human1(String name, int height, int weight){
		this.Height=height;
		this.name=name;
		this.weight=weight;
		
	}
}
public class Class_02 {
	public static void main(String[] args) {
		Human h = new Human();
//		h.setHeight(40);
//		h.setName("동재");
//		h.setWeight(99);
		System.out.println(h.getHeight());
		System.out.println(h.getName());
		System.out.println(h.getWeight());
	}

}
