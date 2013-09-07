package facebook.tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import facebook.User;

public class UserTest {
	User user;
	
	@Before
	public void setup(){
		user=new User("root User");
		for(int i=0;i<10;i++){
			User user1=new User("L1- "+i);
			user.addFriend(user1);
			for (int j=0;j<i;j++){
				user1.addFriend(new User("L2- "+i+" - "+j));
			}
		}
	}
	
	@Test
	public final void testLevel1Friends() {
		HashSet<User> l1=user.getLevel1Friends();
		assertEquals(10,l1.size());
	}
	
	@Test
	public final void testLevel2Friends() {
		HashSet<User> l1=user.getLevel2Friends();
		assertEquals(45, l1.size());
	}

}
