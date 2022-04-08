import java.util.*;
public class tree {

	public static node<Integer> construct(){
		Scanner s=new Scanner(System.in);
		int data=s.nextInt();
		
		node<Integer> root=new node<>(data);
		Queue<node<Integer>> queue=new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			
			node<Integer> start=queue.poll();
			int left=s.nextInt();
			if(left!=-1) {
				node<Integer> lef=new node<>(left);
				start.left=lef;
				queue.add(lef);
			}
			int righ=s.nextInt();
			if(righ!=-1) {
				node<Integer> rig=new node<>(righ);
				start.right=rig;
				queue.add(rig);
			}
		}
		
		
		return root;
	}
	public static void printTree(node<Integer> root) {
		Queue<node<Integer>> queue=new LinkedList<>();
		
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			node<Integer> start=queue.poll();
			node<Integer> stop=queue.peek();
			if(start==null && stop==null)
				break;
			if(start!=null) {
				System.out.print(start.data+" ");
				if(start.left!=null) {
					queue.add(start.left);
					System.out.print("L:"+start.left.data+" ");
				}
				if(start.right!=null) {
					queue.add(start.right);
					System.out.print("R:"+start.right.data);
				}
				System.out.println();
			}else {
				queue.add(null);
				
			}
		}
	}
	public static node<Integer> insertnode(node<Integer> root,int element){
		if(root==null) {
			root=new node<>(element);
			return root;
		}
		if(root.data>element) {
			root.left=insertnode(root.left,element);
		}
		else {
			root.right=insertnode(root.right,element);
		}
		return root;
	}
	public static boolean searchNode(node<Integer> root,int find) {
		if(root==null)
			return false;
		if(root.data==find)
			return true;
		boolean ans=false;
		if(root.data>find) {
			ans=searchNode(root.left,find);
		}
		else {
			ans=searchNode(root.right,find);
		}
		return ans;
	}
	public static boolean binaryIsbst(node<Integer> root) {
		if(root==null)
			return true;
	    if(root.left!=null && root.right!=null) {
	    	node<Integer> lef=root.left;
	    	node<Integer> righ=root.right;
	    	if(lef.data>=root.data || root.data>righ.data)
	    		return false;
	    }
	    else if(root.left==null && root.right!=null) {
	    	node<Integer> righ=root.right;
	    	if(root.data>righ.data)
	    		return false;
	    }
	    else if(root.left!=null && root.right==null) {
	    	node<Integer> lef=root.left;
	    	if(root.data < lef.data)
	    		return false;
	
	    }
	    boolean ans1=binaryIsbst(root.left);
	    boolean ans2=binaryIsbst(root.right);
	    if(ans1 && ans2)
	    	return true;
	    else
	    	return false;
	}
	public static list sortedLL(node<Integer> root,list linked) {
		if(root==null)
			return linked;
		linked=sortedLL(root.right,linked);
		if(linked==null) {
			linked=new list(root.data);
		}
		else {
			list newl=new list(root.data);
			newl.next=linked;
			linked=newl;
		}
		linked=sortedLL(root.left,linked);
		return linked;
	}
	public static ArrayList<Integer> findPath(node<Integer> root,int k){
		if(root==null) {
			ArrayList<Integer> ans=new ArrayList<>();
			return ans;
		}
		ArrayList<Integer> ans=new ArrayList<>();
		if(root.data==k) {
			ans.add(root.data);
			return ans;
		}
		if(root.data<k) {
			ArrayList<Integer> ans2=findPath(root.right,k);
			if(ans2.size()!=0) {
				ans.add(root.data);
				ans.addAll(ans2);
			}
		}
		if(root.data>k) {
			ArrayList<Integer> ans2=findPath(root.left,k);
			if(ans2.size()!=0) {
				ans.add(root.data);
				ans.addAll(ans2);
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//      node<Integer> root=construct();
		node<Integer> root=null;
		Scanner s=new Scanner(System.in);
		int element=s.nextInt();
		while(element!=-1) {
			root=insertnode(root,element);
			element=s.nextInt();
		}
      printTree(root);
//      System.out.println("Enter the element which u want to search:");
//      int find=s.nextInt();
//      System.out.println(searchNode(root,find));
//      node<Integer> root1=construct();
//      printTree(root1);
//      System.out.println(binaryIsbst(root1));
      list linked=null;
      linked=sortedLL(root,linked);
      while(linked!=null) {
    	  System.out.print(linked.data+" ");
    	  linked=linked.next;
      }
      System.out.println("Find Path:");
      int find=s.nextInt();
      ArrayList<Integer> ans=findPath(root,find);
      for(int i=0;i<ans.size();i++)
    	  System.out.print(ans.get(i)+" ");
	}

}
class node<T>{
	
	public T data;
	public node left;
	public node right;
	
	public node(T data) {
		this.data=data;
	}
	
}
class list{
	int data;
	list next;
	
	public list(int data) {
		this.data=data;
	}
}