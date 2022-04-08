import java.util.*;
class TrieNode{
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childcount;
	public TrieNode(char data) {
		this.data=data;
		isTerminating=false;
		children=new TrieNode[26];
		childcount=0;
	}
}
public class Trie {
	private TrieNode root;
	
	public Trie() {
		root=new TrieNode('\0');
	}
	public void add(String word) {
		add(root,word);
	}
	private void add(TrieNode root,String word) {
		if(word.length()==0) {
			root.isTerminating=true;
			return;
		}
		int childindex=word.charAt(0)-'a';
		TrieNode child=root.children[childindex];
		if(child==null) {
			child=new TrieNode(word.charAt(0));
			root.children[childindex]=child;
			root.childcount++;
		}
		add(child,word.substring(1));
	}
   
	public boolean search(String word) {
		return search(root,word);
	}
	
	private boolean search(TrieNode root,String word) {
		if(word.length()==0) {
			return root.isTerminating;
		}
		int childindex=word.charAt(0)-'a';
		TrieNode child=root.children[childindex];
		if(child==null) {
			return false;
		}
		boolean ans=search(child,word.substring(1));
		return ans;
		
	}
	public void remove(String word) {
		remove(root,word);
	}
	private void remove(TrieNode root,String word) {
		if(word.length()==0) {
			root.isTerminating=false;
			return;
		}
		int childindex=word.charAt(0)-'a';
		TrieNode child=root.children[childindex];
		if(child==null) {
			return ;
		}
		remove(child,word.substring(1));
		if(!child.isTerminating && child.childcount==0) {
			root.children[childindex]=null;
			child=null;
			root.childcount--;
		}
	}
}
