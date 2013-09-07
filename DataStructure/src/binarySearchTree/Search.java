package binarySearchTree;

public class Search {
	Tree tree;
	public Search(Tree t){
		tree=t;
	}
	Node find_r(Node root, int data){
		if(root==null){
			return null;
		}else if(root.data==data){
			return root;
		}else{
			return find_r(data<root.data?root.getLeftNode():root.getRightNode(),data);
		}
	}
	
	//Use recursion to find for data
	Node find_recursion(int data){
		return find_r(tree.getRootNode(), data);
	}
	
	//Use while loop to find data
	Node find_iterative(int data){
		Node curNode=tree.rootNode;
		while(curNode!=null){
			if(curNode.data==data){
				return curNode;
			}else{
				curNode=data<curNode.data?curNode.leftNode:curNode.rightNode;
			}
		}
		return curNode;
	}
	
}
