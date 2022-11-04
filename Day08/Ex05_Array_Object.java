//클래스 == 타입 == 설계도

class Person{
   String name;
   int age;
   
   //사람을 만들때 반드시 이름, 나이를 가지게 하려면
   //Person(String name, int age) {}
   
   void print() {
      System.out.println(this.name + "." + this.age);
   }
}


public class Ex05_Array_Object {
   public static void main(String[] args) {
      int[] intarr = new int[10]; //값타입 배열 8가지 + String
      boolean[] booarr = new boolean[5]; //값타입 (5개방에 false)
      
      Person p = new Person();   // 참조변수 (p 라는 변수는 주소값)
      p.name = "홍길동";
      p.age = 100;
      
      //사람 3명을 만들어라
      //Person p1 = new Person();
      //Person p2 = new Person();
      //Person p3 = new Person();
      
      // 이제부터 이렇게 만들면 최악...!
      
      
      
      //int[] intarr = new int[10];
      Person[] persons = new Person[3];
      System.out.println("person: " + persons);
      System.out.println("person[0]" + persons[0]);  //각각의 방은 null default값
      //객체배열은 방을 만들고 방에 객체를 넣어주는 작업....
      //persons[0] 은 person객체의 주소를가진다
      persons[0] = new Person();
      Person p2 = new Person();
      persons[1] = p2;
      persons[2] = new Person();
      
      System.out.println("person[0]" + persons[0]);
      System.out.println("person[1]" + persons[1]);
      System.out.println("person[2]" + persons[2]);
      
      persons[0].name = "김유신";
      persons[0].age = 100;
      
      //객체배열은 방을 만드는것과 방을 채우는 작업은 별도다.
      for(int i = 0; i < persons.length; i++) {
         System.out.println(persons[i].name);
      }
      
      
      
      
      //객체 배열 3가지 방법으로 만들기
      
      //1. int[] arr = new int[10];
      Person[] parray1 = new Person[10]; // 방만 생성
      for (int i = 0; i < parray1.length; i++) {
         parray1[i] = new Person();
         System.out.println("주소값: " + parray1[i]);
      }
      
      
      //2. int[] arr = new int[]{10,20,30}
      Person[] parray2 = new Person[] {new Person(), new Person(), new Person()};  
      
      
      //3. int[] arr = {10,20,30}
      Person[] parray3 = {new Person(), new Person(), new Person()};
      
   }
}
