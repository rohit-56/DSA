import java.util.*;
public class Binarytree {

	static class Node<T>{
	public T data;
	public Node<T> left;
	public Node<T> right;
	public Node(T data) {
		this.data=data;
	}
};

   public static Node<Integer> takeinput(){
	   Scanner s=new Scanner(System.in);
	   int data=s.nextInt();
	   Queue<Node<Integer>> frontnode=new LinkedList<>();
	   Node<Integer> root=new Node<>(data);
	   frontnode.add(root);
	   while(!frontnode.isEmpty()) {
		   Node<Integer> result=frontnode.poll();
		   int left=s.nextInt();
		   if(left!=-1) {
			   Node<Integer> leftnode=new Node<>(left);
			   result.left=leftnode;
               frontnode.add(leftnode);
		   }
		
		   int right=s.nextInt();
		   if(right!=-1) {
			   Node<Integer> rightnode=new Node<>(right);
			   result.right=rightnode;
			   frontnode.add(rightnode);
		   }
		
	   }
	   return root;
   }
   
   public static void printtree(Node<Integer> root) {
	   Queue<Node<Integer>> frontnode=new LinkedList<>();
	   frontnode.add(root);
	   frontnode.add(null);
	   while(!frontnode.isEmpty()) {
		   try {
			   Node<Integer> result=frontnode.poll();
			   if(frontnode.isEmpty())
				   break;
			  if(result!=null) {
				  System.out.print(result.data+" ");
				  if(result.left!=null) {
					  frontnode.add(result.left);
				  }
				  if(result.right!=null) {
					  frontnode.add(result.right);
				  }
			  }
			  else
			  {
				  frontnode.add(null);
				  System.out.println();
			  }
		   }catch(Exception e) {
			   
		   }
	   }
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Node<Integer> root=takeinput();
     printtree(root);
	}

}
