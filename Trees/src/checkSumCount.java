import java.util.*;
public class checkSumCount {
static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TreeNode<Integer> root=construct();
        print(root);
   //     int sum=findsum(root);
  //      count=0;
  //      int num=helper(root,sum);
   //     System.out.println(sum+" "+count);
        TreeNode<Integer> newnode=helper(root);
        System.out.println("******************************************");
        print(newnode);
       // ArrayList<Integer> arr=new ArrayList<>();
        //		pair ans=find(root,arr);
        //System.out.println();
        //for(int i=0;i<arr.size();i++)
        	//System.out.print(arr.get(i)+" ");
	}
	public static pair find(TreeNode<Integer> root,ArrayList<Integer> arr){
		if(root==null) {
			pair ans=new pair();
			return ans;
		}
		pair ans1=find(root.left,arr);
		pair ans2=find(root.right,arr);
		if(ans1.leftsum==ans2.rightsum && (root.left!=null || root.right!=null)) {
			arr.add(root.data);
		}
		pair ans=new pair();
		ans.leftsum+=ans1.leftsum+root.data;
		ans.rightsum+=ans2.rightsum+root.data;
		return ans;
	}
	public static TreeNode<Integer> helper(TreeNode<Integer> root){
	TreeNode<Integer> newnode=new TreeNode<>(root.data);
		Queue<TreeNode<Integer>> queue=new LinkedList<>();
		Queue<TreeNode<Integer>> q1=new LinkedList<>();
		queue.add(root);
		queue.add(null);
		q1.add(newnode);
		TreeNode<Integer> cur=null;
		while(!queue.isEmpty()) {
			try {
				TreeNode<Integer> curr=queue.poll();
				
				if(curr==null && queue.peek()==null) {
					break;
				}
				else if(curr==null) {
					queue.add(null);
					cur=q1.poll();
				}
				else {
					if(cur==null) {
					cur=new TreeNode<Integer>(curr.data);
					q1.add(cur);
					}
					else if(cur.right==null) {
						cur.right=new TreeNode<Integer>(curr.data);
						q1.add(cur.right);
					}
					else if(cur.left==null) {
						cur.left=new TreeNode<Integer>(curr.data);
						q1.add(cur.left);
						cur=q1.poll();
					}
					
					if(curr.right!=null) {
						queue.add(curr.right);
					}
					if(curr.left!=null) {
						queue.add(curr.left);
						
					}
				
				}
			}
			catch(Exception e) {
				
			}
		}
		return newnode;
	}
	public static int helper(TreeNode<Integer> root,int sum) {
		int num1=0,num2=0;
		if(root.left!=null) {
			num1=helper(root.left,sum);
			if(2*num1==sum)
				count++;
		}
		if(root.right!=null) {
			num1=helper(root.right,sum);
			if(2*num2==sum)
				count++;
		}
			
		return root.data+num1+num2;
	}
	
	public static int findsum(TreeNode<Integer> root) {
		if(root==null)
			return 0;
		return root.data+findsum(root.left)+findsum(root.right);
	}
	
	public static void print(TreeNode<Integer> root) {
		if(root==null)
            return;
        Queue<TreeNode<Integer>> frontnode=new LinkedList<>();
        frontnode.add(root);
        while(!frontnode.isEmpty()){
            TreeNode<Integer> result;
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
    public static TreeNode<Integer> construct(){
    	Scanner s=new Scanner(System.in);
    	int val=s.nextInt();
    	if(val==-1)
    		return null;
    	TreeNode<Integer> root=new TreeNode<Integer>(val);
    	Queue<TreeNode<Integer>> queue=new LinkedList<>();
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		try {
    			TreeNode<Integer> curr=queue.poll();
    			val=s.nextInt();
    			if(val!=-1) {
    				curr.left=new TreeNode<Integer>(val);
    				queue.add(curr.left);
    			}
    			val=s.nextInt();
    			if(val!=-1) {
    				curr.right=new TreeNode<Integer>(val);
    				queue.add(curr.right);
    			}
    		}
    		catch(Exception e) {
    			
    		}
    	}
    	return root;
    }
}
class TreeNode<T>{
	T data;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(T data) {
		this.data=data;
		left=null;
		right=null;
	}
}
class pair{
	int leftsum;
	int rightsum;
	public pair() {
		leftsum=0;
		rightsum=0;
	}
}