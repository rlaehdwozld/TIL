package prac_1;

import java.util.Stack;

class Mystack {
	private Object[] stackarr;
	private int maxsize;
	private int top;

	public Mystack(int maxsize) {
		this.maxsize = maxsize;
		stackarr = new Object[maxsize];
		top = -1;// 배열의 시작값 0 (index)

	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxsize - 1);
	}

	public void push(Object i) {
		if (isFull()) {
			System.out.println("stack full");

			return;
		} else {
			stackarr[++top] = i;
		}
	}

	public Object pop() {
		Object value = null;
		if (isEmpty()) {
			System.out.println("stack empty");
		} else {
			value = stackarr[top];
			top--;

		}
		return value;
	}

}

public class collection_ex06 {
	public static void main(String[] args) {
		
	Stack stack = new Stack();// LIFO
	stack.push("A");
	stack.push("B");
	stack.push("C");

	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.pop());

	// System.out.println(stack.pop());//java.util.EmptyStackException

	stack.empty();
	}

}
