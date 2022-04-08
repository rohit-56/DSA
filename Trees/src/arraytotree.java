import java.util.*;
public class arraytotree {

	static class Node<T>{
		public T data;
		public Node left;
		public Node right;
		public Node(T data) {
			this.data=data;
		}
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		int arr[][]=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
				arr[i][j]=s.nextInt();
		}
		Node<Integer> root=createtree(arr);
		print(root);
		n=s.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=s.nextInt();
		for(int i=0;i<n;i++)
		root=swap(root,1,a[i]);
		print(root);
		ArrayList<Integer> ar=new ArrayList<Integer>();
		array(root,ar);
		System.out.println();
		for(Integer num:ar)
			System.out.print(num+" ");
	}
	// coorect this function
	public static void array(Node<Integer> root,ArrayList<Integer> ar){
		if(root==null)
		return;
		array(root.left, ar);
		ar.add(root.data);
		array(root.right,ar);
	}
	public static Node<Integer> swap(Node<Integer> root,int x,int depth) {
		if(x==0 || x>depth || root==null)
			return root;
		if(x==depth) {
			if(root.left!=null && root.right!=null) {
				Node<Integer> temp=root.left;
				root.left=root.right;
				root.right=temp;
			}
			else if(root.left==null && root.right!=null)
			{
				root.left=root.right;
				root.right=null;
			}
			else if(root.left!=null && root.right==null) {
				root.right=root.left;
				root.left=null;
			}
			depth=depth*2;
		}
		swap(root.left,x+1,depth);
		swap(root.right,x+1,depth);
		return root;
	}
	public static void print(Node<Integer> root) {
		if(root==null)
            return;
        Queue<Node<Integer>> frontnode=new LinkedList<>();
        frontnode.add(root);
        while(!frontnode.isEmpty()){
            Node<Integer> result;
            try{
                result=frontnode.poll();
                System.out.print(result.data+":");
            }catch(Exception e){
                return;
            }
            if(result.left!=null){
                System.out.print("L:"+result.left.data+",");
                frontnode.add(result.left);
            }
            else
               System.out.print("L:"+"-1,");  
            if(result.right!=null){
                System.out.print("R:"+result.right.data);
                frontnode.add(result.right);
            }
            else
                System.out.print("R:"+"-1"); 
            System.out.println();
        }

	}
	public static Node<Integer> createtree(int[][] arr){
		Node<Integer> root=new Node<>(1);
		Queue<Node<Integer>> frontnode=new LinkedList<>();
		frontnode.add(root);
		int i=0;
		while(!frontnode.isEmpty()) {
			try {
				Node<Integer> result=frontnode.poll();
				if(i<arr.length) {
					Node<Integer> l=null,r=null;
					if(arr[i][0]!=-1)
				l=new Node<>(arr[i][0]);
					if(arr[i][1]!=-1)
			    r=new Node<>(arr[i][1]);
				result.left=l;
				result.right=r;
				frontnode.add(result.left);
				frontnode.add(result.right);
				i++;
				}
			}catch(Exception e) {
				
			}
		}
		return root;
	}
}
