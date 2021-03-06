package collection;

import java.util.Stack;

public class StackTEst {

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		
		s.push("둘리");
		s.push("마이콜");
		s.push("또치");
		
		while(!s.isEmpty()) {
			String str = s.pop();
			System.out.println(str);
		}
		//비어있는경우 StackException이 발생
		//s.pop();
		
		s.push("둘리");
		s.push("마이콜");
		s.push("또치");
		
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
	
	}

}
