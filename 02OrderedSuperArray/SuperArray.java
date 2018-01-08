public class SuperArray{
    public String[] data;
    private int size;

    public SuperArray(){
	data = new String[10];
	size = 0;
    }
	
    public SuperArray(int startingCapacity){
	data = new String[startingCapacity];
	size = 0;
    }
	
    public void clear(){
	data = new String[10];
	size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
	return size == 0;
    }

    public boolean add(String element){
		if (this.size == data.length){
			this.resize();
		}
		data[this.size] = element;
		size++;
		return true;
    }
	
    public String get(int index){
	if (index < 0 || index >= this.size){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }
	
    public String set(int index, String element){
	if (index < 0 || index >= this.size){
	    throw new IndexOutOfBoundsException();
	}
	String s = data[index];
	data[index] = element;
	return s;
    }
	
    private void resize(){
	String[] a;
	a = new String[this.size * 2 + 1];
	for (int x = 0; x < this.size; x++){
	    a[x]=this.get(x);
	}
	this.data = a;
    }
	
    public String toString(){
	if (this.isEmpty()){
	    return "[]";
	}
	String s = "[";
	for (int x = 0; x < size - 1; x++){
	    s = s + data[x] + ", ";
	}
	s = s + data[size - 1];
	s += "]";
	return s;
    }
	
    public boolean contains(String element){
	boolean in = false;
	for (int x = 0; x < size; x++){
	    if (data[x].equals(element)){
		in = true;
	    }
	}
	return in;
    }
	
    public void add(int index, String element){
	if (index < 0){
	    throw new IndexOutOfBoundsException();
	}
	if (index > size()){
	    throw new IndexOutOfBoundsException();
	}
	if (data.length == size()){
	    this.resize();
	}
	size++;
	for (int n = size; n > index; n--){
	    data[n] = data[n-1];
	}
	data[index] = element;
    }
    
    public int indexOf(String element){
	for (int x = 0; x < size; x++){
	    if (data[x].equals(element)){
		return x;
	    }
	}
	return -1;
    }
    
    public int lastIndexOf(String element){
	for (int x = size - 1; x>=0; x--){
	    if (data[x].equals(element)){
		return x;
	    }
	}
	return -1;
    }
    
    public String remove(int index){
	if (this.size()==0||index >= data.length){
	    throw new IndexOutOfBoundsException();
	}
	String s = data[index];
	for (int n = index; n < this.size(); n++){
	    data[n] = data[n+1];
	}
	size--;
	return s;
    }
	
    public boolean remove(String element){
	int index = this.indexOf(element);
	if (index == -1){
	    return false;
	}
	for (int n = index; n < this.size(); n++){
	    data[n] = data[n+1];
	}
	size--;
	return true;
    }
}
