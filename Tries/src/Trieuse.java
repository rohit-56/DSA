import java.util.*;
public class Trieuse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner s=new Scanner(System.in);
       Trie start=new Trie();
       int n=s.nextInt();
       s.nextLine();
       while(n!=0) {
    	   String str=s.nextLine();
    	   start.add(str);
    	   n--;
       }
       String str1=s.nextLine();
       start.remove(str1);
       String str=s.nextLine();
       System.out.println(start.search(str));
	}

}
