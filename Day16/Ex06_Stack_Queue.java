import java.util.Stack;

 class MyStack {
	private Object[] stackarr;
	private int maxsize;
	private int top;

	public MyStack(int maxsize) {
		this.maxsize=maxsize;
		stackarr= new Object[maxsize];
		top=-1;//배열의 시작값 0 (index)
	}
	
	public boolean isEmpty() {
		return(top==-1);//true
	}
	public boolean isFull() {
		return(top==maxsize-1);//5개 방을 만들면[0][1][2][3][4]
	}
	public void push(Object i) {
		if(isFull()) {
			System.out.println("stack full");
			return;
		}else {
			//Point 
			stackarr[++top]=i;//처음 top =-1>>[0]
			
		}

	}
	public Object pop() {
		Object value= null;
		if(isEmpty()) {
			System.out.println("stack empty");
		}else {
			value=stackarr[top];
			top--;
			
		}
		return value;
	}


	
	// push(), pop(), boolean empty(), boolean pop()직접 구현
	
}

public class Ex06_Stack_Queue {

	public static void main(String[] args) {
		// JAVA API 제공하는 클래스
		// Collection JAVA API 제공
		// Stack 자료구조 가지는 클래스 제공 받아요

		Stack stack = new Stack();// LIFO
		stack.push("A");
		stack.push("B");
		stack.push("C");

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		// System.out.println(stack.pop());//java.util.EmptyStackException

		stack.empty();

		// JAVA API구현하는 stack직접 구현하기
		//LIFO 구조를 코드....
		// 1.stack 저장공간(Array), 저장공간 타입(Object)
		// 2. 위치정보 : 저장되는 값이 잇는 위치(index) hint)전자제품 매장 cart사용해서 처리
		// 3. 가능 : push(), pop(), boolean empty(), boolean full()

	}
}
