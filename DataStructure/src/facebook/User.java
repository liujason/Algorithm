package facebook;

import java.util.HashSet;
import java.util.Iterator;

public class User {
	HashSet<User> friends;
	String name;
	public User(String n){
		friends=new HashSet<User>();
		name=n;
	}
	public String getName(){
		return name;
	}
	public void addFriend(User u){
		friends.add(u);
	}
	public HashSet<User> getLevel1Friends(){
		HashSet<User> level1=new HashSet<User> ();
		Iterator<User> iter=friends.iterator();
		while(iter.hasNext()){
			level1.add(iter.next());
		}
		return level1;
	}
	public HashSet<User> getLevel2Friends(){
		HashSet<User> level1=getLevel1Friends();
		Iterator<User> iter1=level1.iterator();
		HashSet<User> level2=new HashSet<User>();
		while(iter1.hasNext()){
			level2.addAll(iter1.next().getLevel1Friends());
		}
		return level2;
	}
}
