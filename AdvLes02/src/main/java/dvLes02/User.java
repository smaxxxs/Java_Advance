package dvLes02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
private int user_id;
private String user_name;
private List <Integer>  subscribes = new ArrayList<>();
private String sub; 


public List <Integer> toIntList(String str){
	String str2 = str.replace(",", " ");
	Scanner scanner = new Scanner(str2);
	List<Integer> list = new ArrayList<Integer>();
	while (scanner.hasNextInt()) {
	    list.add(scanner.nextInt());
	}
	scanner.close();
	return list;
}
public User(int user_id, String user_name, List<Integer> subscribes) {
	this.user_id = user_id;
	this.user_name = user_name;
	this.subscribes = subscribes;
	this.sub =subscribes.toString();
}

public User(String user_name) {
	
		this.user_name = user_name;
}


public int getUser_id() {
	return user_id;
}

public User(String user_name, String s) {
	this.user_name = user_name;
	this.sub= s;
}

public User(int id, String name, String sub) {
	this.user_id = id;
	this.user_name = name;
	this.sub =sub;
	this.subscribes = toIntList(sub); 
	}

public void setUser_id(int user_id) {
	this.user_id = user_id;
}

public String getUser_name() {
	return user_name;
}

public void setUser_name(String user_name) {
	this.user_name = user_name;
}

public List<Integer> getSubscribes() {
	return subscribes;
}

public void setSubscribes(ArrayList<Integer> subscribes) {
	this.subscribes = subscribes;
}

public void addSubscribe(Integer mag) {
		subscribes.add(mag);
}

public void removeSubscribe(Integer mag) {
	subscribes.stream().forEach(m -> {if (m == mag) subscribes.remove(m);});
	
}

public String getSub() {
	return sub;
}

public void setSub(String sub) {
	this.sub = sub;
}


@Override
public String toString() {
	return user_id + " " + user_name + ", subscribes:\n" + sub ;
}





}
