import java.util.*;
public class binary {
	
		
		public static void reverseAltLevels(BinaryTreeNode<Integer> root) {
			/* Your class should be named Solution
			* Don't write main().
			* Don't read input from, it is passed as function argument.
			* Print preorder traversal of output 
			*/
		  Queue<BinaryTreeNode<Integer>> queue=new LinkedList<>();
	        queue.add(root);
	        queue.add(null);
	        
	        BinaryTreeNode<Integer> root1=null;
	        String s="";
	        int count=0;
	        while(!queue.isEmpty()){
	            BinaryTreeNode<Integer> start=queue.poll();
	            BinaryTreeNode<Integer> stop=queue.peek();
	            if(start==null && stop==null)
	                break;
	            if(start!=null){
	                if(count%2!=0)
	                    s=s+start.data;
	                if(count%2==0)
	                    s=start.data+s;
	                if(start.left!=null)
	                    queue.add(start.left);
	                if(start.right!=null)
	                    queue.add(start.right);
	                
	                           }
	            else{
	                queue.add(null);
	                int num=Integer.parseInt(s);
	                while(num!=0){
	                	System.out.println(num);
	                    root1=insertion(root1,num%10);
	                    num=num/10;
	                }
	                s="";
	                count++;
	            }
	                
	        }
	        int num=Integer.parseInt(s);
            while(num!=0){
            	System.out.println(num);
                root1=insertion(root1,num%10);
                num=num/10;
            }
	        System.out.println();
		       inorder(root1); 
		}         
	     
		
	     
	   public static BinaryTreeNode<Integer> insertion(BinaryTreeNode<Integer> root1,int num){
	    if(root1==null)
	    {
	        root1=new BinaryTreeNode<>(num);
	        return root1;
	    }
	    Queue<BinaryTreeNode<Integer>> queue=new LinkedList<>();
	    queue.add(root1);
	    while(!queue.isEmpty()){
	        BinaryTreeNode<Integer> start=queue.poll();
	        if(start.left==null){
	            start.left=new BinaryTreeNode<>(num);
	            break;
	        }
	        if(start.right==null){
	            start.right=new BinaryTreeNode<>(num);
	            break;
	        }
	        if(start.left!=null)
	            queue.add(start.left);
	        if(start.right!=null)
	            queue.add(start.right);
	    }
	    return root1;
	}
	    public static void inorder(BinaryTreeNode<Integer> root1){
	        if(root1==null)
	            return;
	        inorder(root1.left);
	        System.out.print(root1.data+" ");
	        inorder(root1.right);
	    }
	    public static BinaryTreeNode construct() {
			Scanner s=new Scanner(System.in);
			int data=s.nextInt();
			BinaryTreeNode<Integer> root=new BinaryTreeNode<>(data);
			
			
			Queue<BinaryTreeNode<Integer>> queue=new LinkedList<>();
			queue.add(root);
			while(!queue.isEmpty()) {
				BinaryTreeNode<Integer>  start=queue.poll();
				int left=s.nextInt();
				if(left!=-1) {
					BinaryTreeNode<Integer> lef=new BinaryTreeNode<>(left);
//					lef.data=left;
					start.left=lef;
					queue.add(lef);
				}
				int right=s.nextInt();
				if(right!=-1) {
					BinaryTreeNode<Integer> righ=new BinaryTreeNode<>(right);
//					righ.data=right;
					start.right=righ;
					queue.add(righ);
				}
			}
			return root;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    BinaryTreeNode<Integer> root=construct();
    reverseAltLevels(root);
	}

}
		 class BinaryTreeNode<T> {
				T data;
				BinaryTreeNode<T> left;
				BinaryTreeNode<T> right;
				
				public BinaryTreeNode(T data) {
					this.data = data;
				}
			}
	
