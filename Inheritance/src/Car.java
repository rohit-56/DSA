
public class Car extends Vehicle {
public String brandname;
private int gear;
public Car(String brandname,String color,int maxspeed,int gear) {
	super(color,maxspeed);
	this.brandname=brandname;

	this.gear=gear;
}
public void print() {
	super.print();
	System.out.println("brandname of car:"+brandname+" "+"gears:"+gear);
}
}
