package binarySearchTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Tree {
	Node rootNode;
	
	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}
	
	//recursion get height
	public int getHeight_recursion(){
		int leftHeight=getHeight_r(rootNode.leftNode);
		int rightHeight=getHeight_r(rootNode.rightNode);
		if(leftHeight>rightHeight){
			return leftHeight;
		}else{
			return rightHeight;
		}
	}
	public int getHeight_r(Node root){
		if(root==null){
			return 0;
		}else{
			int leftHeight=getHeight_r(root.leftNode);
			int rightHeight=getHeight_r(root.rightNode);
			return 1+(leftHeight>rightHeight?leftHeight:rightHeight);
		}
	}
	//Iterative, in-order traversal
	public int getHeight(){
		int height=0;
		int maxHeight=0;
		Deque<Node> stack=new ArrayDeque<Node>();
		Node node=rootNode;
		
		while(!stack.isEmpty()||node!=null){
			if(node!=null){
				stack.push(node);
				node=node.leftNode;
				height++;
			}else{
				node=stack.pop();
				height--;
				if(height>maxHeight){
					maxHeight=height;
				}
				node=node.rightNode;
			}
		}
		return maxHeight;
	}
	public Node insert_recursion(int data){
		Insert insert=new Insert(this);
		return insert.insert_recursion(data);
	}
	public Node insert(int data){
		Insert insert=new Insert(this);
		return insert.insert_iterative(data);
	}

	public void print() {
		Print print=new Print(this);
		print.printTree();
		
	}
	
	//Validates if the tree is a BST by in order traversal
	public boolean validate(){
		System.out.println("Validate if tree is BST by in order traversal.");
		Deque<Node> stack=new ArrayDeque<Node>();
		Node n=rootNode;
		int last=Integer.MIN_VALUE;
		while(!stack.isEmpty()||n!=null){
			if(n!=null){
				stack.push(n);
				n=n.leftNode;
			}else{
				n=stack.pop();
				System.out.print(n.data+" ");
				if(last==Integer.MIN_VALUE){
					last=n.data;
				}else{
					if(last>n.data){
						return false;
					}else{
						last=n.data;
					}
				}
				n=n.rightNode;
			}
		}
		return true;
	}
	
}
