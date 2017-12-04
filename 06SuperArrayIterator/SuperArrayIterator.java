import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{
	private SuperArray arr;
	private int current;
	
	public SuperArrayIterator(SuperArray a, int start){
		arr = a;
		current = start;
	}
	
	public boolean hasNext(){
		return current < arr.size();
	}
	
	public String next(){
		if(hasNext()){
			current++;
		}
		else{
			System.exit(1);
		}
		return arr.get(current-1);
	}
	
	public void remove(){
		arr.remove(arr.get(current-1));
	}
}