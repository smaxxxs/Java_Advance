package dvLes02;

public class Payments {
int id_payment;
String name;
String description;
float sum;
public Payments(int id_payment, String name, String description, float sum) {
	
	this.id_payment = id_payment;
	this.name = name;
	this.description = description;
	this.sum = sum;
}
public int getId_payment() {
	return id_payment;
}
public void setId_payment(int id_payment) {
	this.id_payment = id_payment;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public float getSum() {
	return sum;
}
public void setSum(float sum) {
	this.sum = sum;
}
@Override
public String toString() {
	return "Payments [id_payment=" + id_payment + ", name=" + name + ", description=" + description + ", sum=" + sum
			+ "]";
}



}
