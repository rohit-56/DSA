import java.util.*;
public class Mapuse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner s=new Scanner(System.in);
String str=s.nextLine();
Map<String,Integer> map=new Map<>(); 
for(int i=0;i<str.length();i++) {
	String stri=""+str.charAt(i);
	if(map.containskey(stri))
	{
		int v=map.getvalue(stri)+1;
		map.insert(stri, v);
	}else
	{
		map.insert(stri, 1);
	}
}
String ans="";
for(int i=0;i<str.length();i++) {
	String stri=""+str.charAt(i);
	if(map.containskey(stri)) {
		ans=ans+stri;
	map.removekey(stri);
	}
}
System.out.println(ans);
	}

}
