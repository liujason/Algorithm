package binarySearchTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Print {
	Tree tree;
	public Print(Tree t){
		tree=t;
	}

	//breadth first search
	public void print(){
		Deque<Node> queue1=new ArrayDeque<Node>();
		Deque<Node> queue2=new ArrayDeque<Node>();
		queue1.push(tree.getRootNode());
		Node node;
		int height=tree.getHeight();
		int currentHeight=0;
		while(!queue1.isEmpty()||!queue2.isEmpty()){
			if(currentHeight%2==0){
				node=queue1.pollLast();
			}else{
				node=queue2.pollLast();
			}
			
			System.out.print(node.data+" ");
			if(node.leftNode!=null){
				if(currentHeight%2==0){
					queue2.push(node.leftNode);
				}else{
					queue1.push(node.leftNode);
				}
			}
			if(node.rightNode!=null){
				if(currentHeight%2==0){
					queue2.push(node.rightNode);
				}else{
					queue1.push(node.rightNode);
				}
			}
			if(queue1.isEmpty()&&currentHeight%2==0){
				currentHeight++;
				System.out.println();
			}else if(queue2.isEmpty()&&currentHeight%2==1){
				currentHeight++;
				System.out.println();
			}
		}
	}
}
