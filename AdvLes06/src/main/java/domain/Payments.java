package domain;

import java.util.Date;

public class Payments {
int id_payment;
Date date;
String name;
String description;
float sum;

public Payments(int id_payment, Date date, String name, String description, float sum) {
	
	this.id_payment = id_payment;
	this.date = date;
	this.name = name;
	this.description = description;
	this.sum = sum;
}

public Payments(Date date, String name, String description, float sum) {
	
	this.date = date;
	this.name = name;
	this.description = description;
	this.sum = sum;
}

public Payments(String currentDateTime, String user_name, String name2, float price) {
	
}

public int getId_payment() {
	return id_payment;
}
public void setId_payment(int id_payment) {
	this.id_payment = id_payment;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
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
	return  id_payment + "   " + date + "    " + name + "    " + description
			+ "    " + sum ;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((date == null) ? 0 : date.hashCode());
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + id_payment;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + Float.floatToIntBits(sum);
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Payments other = (Payments) obj;
	if (date == null) {
		if (other.date != null)
			return false;
	} else if (!date.equals(other.date))
		return false;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (id_payment != other.id_payment)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (Float.floatToIntBits(sum) != Float.floatToIntBits(other.sum))
		return false;
	return true;
}




}
