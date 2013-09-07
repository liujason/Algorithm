package binarySearchTree;

public class Insert {
	Tree tree;
	public Insert(Tree t){
		tree=t;
	}
	//Recursion insert
	public Node insert_recursion(int data){
		return insert_r(tree.getRootNode(), data);
	}
	public Node insert_r(Node root, int data){
		if(root==null){
			root=new Node(data);
		}else if(root.data==data){
			//We are not supporting duplicate node to be inserted into our tree
			return root;
		}else{
			root=data<root.data?insert_r(root.getLeftNode(),data):insert_r(root.getRightNode(),data);
		}
		return root;
	}
	
	//iterative insert
	public Node insert_iterative(int data){
		Node curNode=tree.getRootNode();
		if(curNode==null){
			Node rootNode=new Node(data);
			tree.setRootNode(rootNode);
			System.out.println("Inserting: "+data+" as root.");
			return rootNode;
		}
		Node parentNode=null;
		for(;;){
			parentNode=curNode;
			if(curNode.data==data){
				System.out.println("Found duplicate: "+data);
				return curNode;
			}else{
				if(data<curNode.getData()){
					curNode=curNode.leftNode;
					if(curNode==null){
						curNode=new Node(data);
						parentNode.leftNode=curNode;
						System.out.println("Inserting: "+data+" as left node of "+parentNode.data);
						return curNode;
					}
				}else{
					curNode=curNode.rightNode;
					if(curNode==null){
						curNode=new Node(data);
						parentNode.rightNode=curNode;
						System.out.println("Inserting: "+data+" as right node of "+parentNode.data);
						return curNode;
					}
				}
			}
		}
	}
}
