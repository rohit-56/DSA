
public class Vehicle {
public String color;
protected int maxspeed;
public Vehicle(String color,int maxspeed) {
	this.color=color;
	this.maxspeed=maxspeed;
}
public void print() {
	System.out.println("color of vehicle:"+color+" "+"maxspeed:"+maxspeed);
}
}
