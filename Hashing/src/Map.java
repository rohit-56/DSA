import java.util.*;
public class Map<K,V> {

	static class Mapnode<K,V>{
		public K key;
		public V value;
		public Mapnode next;
		public Mapnode(K key,V value) {
			this.key=key;
			this.value=value;
		}
	}
	
	ArrayList<Mapnode<K,V>> buckets;
	int size;
	int numbuckets;
	
	public Map() {
		numbuckets=20;
		buckets=new ArrayList<>();
		for(int i=0;i<20;i++)
			buckets.add(null);
	}
	public int getbucketindex(K key) {
		int hashcode=key.hashCode();
		return hashcode%20;
	}
	public void insert(K key,V value) {
		int bucketindex=getbucketindex(key);
		Mapnode<K,V> head=buckets.get(bucketindex);
		while(head!=null) {
			if(head.key.equals(key)) {
				head.value=value;
				return;
			}
			head=head.next;
		}
		head=buckets.get(bucketindex);
		Mapnode<K,V> newnode=new Mapnode<>(key,value);
		newnode.next=head;
		buckets.set(bucketindex, newnode);
	}
	
	public V getvalue(K key) {
		int bucketindex=getbucketindex(key);
		Mapnode<K,V> head=buckets.get(bucketindex);
		while(head!=null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head=head.next;
		}
		return null;
	}
	public boolean containskey(K key) {
		int bucketindex=getbucketindex(key);
		Mapnode<K,V> head=buckets.get(bucketindex);
		while(head!=null) {
			if(head.key.equals(key))
				return true;
			head=head.next;
		}
		return false;
	}
	public V removekey(K key) {
		int bucketindex=getbucketindex(key);
		Mapnode<K,V> head=buckets.get(bucketindex);
		Mapnode<K,V> prev=null;
		while(head!=null) {
			if(prev==null) {
				buckets.set(bucketindex, head.next);
			}
			else
			{
				prev.next=head.next;
			}
			prev=head;
			head=head.next;
		}
		return null;
	}
}
