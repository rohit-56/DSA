import java.util.*;
public class definebmw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner s=new Scanner(System.in);
String brand=s.nextLine();
String color=s.nextLine();
int maxspeed=s.nextInt();
int gear=s.nextInt();
int modelnum=s.nextInt();
double price=s.nextDouble();
bmw b1=new bmw(brand,color,maxspeed,gear,modelnum,price);
Car c=new bmw(brand,color,maxspeed,gear,modelnum,price);
b1.print();
c.print();
	}

}
