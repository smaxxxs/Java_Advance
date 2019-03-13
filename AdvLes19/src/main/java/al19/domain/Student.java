package al19.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="list")
public class Student {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
String id;
String firstName;
String secondName;
Integer age;
String urlPic;
public Student(String id, String firstName, String secondName, Integer age, String urlPic) {
	
	this.id = id;
	this.firstName = firstName;
	this.secondName = secondName;
	this.age = age;
	this.urlPic = urlPic;
}
public Student(String firstName, String secondName, Integer age, String urlPic) {
	
	this.firstName = firstName;
	this.secondName = secondName;
	this.age = age;
	this.urlPic = urlPic;
}
public Student() {
	
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getSecondName() {
	return secondName;
}
public void setSecondName(String secondName) {
	this.secondName = secondName;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public String getUrlPic() {
	return urlPic;
}
public void setUrlPic(String urlPic) {
	this.urlPic = urlPic;
}
@Override
public String toString() {
	return "Student [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", age=" + age
			+ ", urlPic=" + urlPic + "]";
}
 

}
