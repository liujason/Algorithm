package test;

import java.util.ArrayDeque;
import java.util.Deque;

public class TestDeque {
	public static void main(String[] args){
		Deque<String> queue=new ArrayDeque<String>();
		queue.push("First");
		queue.push("Second");
		queue.push("Third");
		System.out.println(queue.pollLast());//returns "First".
	}
	
}
