import java.util.*;
public class treefromPreorder {

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
		int preorder[]=new int[n];
		for(int i=0;i<n;i++)
			preorder[i]=s.nextInt();
		Node<Integer> root=construct(preorder,0,preorder.length-1);
		print(root);
	}
	public static void print(Node<Integer> root) {
		Queue<Node<Integer>> frontnode=new LinkedList<>();
		frontnode.add(root);
		while(!frontnode.isEmpty()) {
			try {
				Node<Integer> result=frontnode.poll();
				System.out.print(result.data+" ");
				if(result.left!=null) {
					System.out.print("L:"+result.left.data+" ");
					frontnode.add(result.left);
				}
				if(result.right!=null) {
					System.out.print("R:"+result.right.data+" ");
					frontnode.add(result.right);
				}
				System.out.println();
			}catch(Exception e) {
				
			}
		}
	}
	public static Node<Integer> construct(int[] preorder,int si,int ei){
		if(si>ei)
			return null;
		Node<Integer> root=new Node<>(preorder[si]);
		int pos=0;
		for(int i=si+1;i<=ei;i++) {
			if(preorder[si]<preorder[i]) {
				pos=i;
				break;
			}
		}
		if(pos==0)
			pos=ei+1;
		root.left=construct(preorder,si+1,pos-1);
		root.right=construct(preorder,pos,ei);
		return root;
	}
}
