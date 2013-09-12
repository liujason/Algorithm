package binarySearchTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Print {
	Tree tree;
	public Print(Tree t){
		tree=t;
	}

	//breadth first search
	public void printTree(){
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
	//depth first traversal
	public String traverseInorder(){
		System.out.println("Traversing In-order for tree:");
		printTree();
		String result="";
		Node root=tree.getRootNode();
		Deque<Node> stack=new ArrayDeque<Node>();
		while(!stack.isEmpty()||root!=null){
			if(root!=null){
				stack.push(root);
				root=root.leftNode;
			}else{
				root=stack.poll();
				result+=root.data+" ";
				root=root.rightNode;
			}
			
		}
		return result;
	}
	
	//Pre order: Node, Left, Right
	public String traversePreorder(){
		String result="";
		Deque<Node> stack=new ArrayDeque<Node>();
		Node node=tree.rootNode;
		while(!stack.isEmpty()||node!=null){
			if(node!=null){
				result+=node.data+" ";
				stack.push(node);
				node=node.leftNode;
			}else{
				node=stack.pop();
				node=node.rightNode;
			}
		}
		
		
		return result;
	}
	
	//Post order: Left, Right, Node
		public String traversePostorder(){
			String result="";
			Deque<Node> stack=new ArrayDeque<Node>();
			Node node;
			Node prevNode=null;
			stack.push(tree.getRootNode());
			while(!stack.isEmpty()){
				node=stack.peek();
				if(prevNode==null||prevNode.leftNode==node||prevNode.rightNode==node){
					if(node.leftNode!=null){
						stack.push(node.leftNode);
					}else if(node.rightNode!=null){
						stack.push(node.rightNode);
					}
				}else if(prevNode==node.leftNode){
					if(node.rightNode!=null){
						stack.push(node.rightNode);
					}
				}else if(prevNode==node){
					result+=node.data+" ";
					stack.pop();
				}
				prevNode=node;
			}
			
			return result;
		}
		//Post order
		public String traversePostorder2(){
			String result="";
			Deque<Node> stack=new ArrayDeque<Node>();
			Node node=tree.rootNode;
			String dir="";
			while(!stack.isEmpty()||node!=null){
				if(node!=null){
					System.out.println("current at: "+node.data+" dir: "+dir);
					if(dir==""){
						stack.push(node);
						node=node.leftNode;
						dir="LD";
					}else if(dir=="RU"){
						
						node=node.rightNode;
						dir="RD";
					}else if (dir=="LD"){
						stack.push(node);
						node=node.leftNode;
						dir="LD";
					}else if (dir=="RD"){
						stack.push(node);
						node=node.rightNode;
						dir="RD";
					}else if (dir=="LU"){
						node=stack.peek();
						dir="RU";
					}
					
				}else{
					if(dir=="LD"){
						node=stack.peek();
						dir="RU";
						node=node.rightNode;
						dir="RD";
					}else if(dir=="RD"){
						node=stack.peek();
						result+=node.data+" ";
						dir="LU"; //there is no LU, just clear direction
						stack.pop();
					}
				}
				
			}

			return result;
		}
		
		
		
		
}
