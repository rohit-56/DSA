
public class bmw extends Car {
public int modelnum;
public double price;
public bmw(String brandname,String color,int maxspeed,int gear,int modelnum,double price) {
	super(brandname,color,maxspeed,gear);
	this.modelnum=modelnum;
	this.price=price;
}
public void print() {
	super.print();
	System.out.println("modelnumber:"+modelnum+" "+"price:"+price);
}
}
