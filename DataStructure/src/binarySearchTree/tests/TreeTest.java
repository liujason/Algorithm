package binarySearchTree.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import binarySearchTree.Tree;

public class TreeTest {
	Tree tree;
	@Before
	public void prepareTree(){
		tree=new Tree();
		tree.insert(5);
		tree.insert(2);
		tree.insert(8);
		tree.insert(1);
		tree.insert(9);
		tree.insert(7);
		tree.insert(4);
	}
	
	@Test
	public final void testGetHeight_recursion() {
		assertEquals(2, tree.getHeight_recursion());
		tree.print();
	}

	@Test
	public final void testGetHeight() {
		assertEquals(2, tree.getHeight());
	}
	
	@Test
	public final void testPrint(){
		
	}

}
