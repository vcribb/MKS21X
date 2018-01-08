public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(){
	super();
    }

    public OrderedSuperArray(int startingCapacity){
	super(startingCapacity);
    }

    public OrderedSuperArray(String[] ary){
	super(ary.length);
	for (int x = 0; x < ary.length; x++){
	    add(ary[x]);
	}
    }

    public String set(int index, String element){
	throw new UnsupportedOperationException();
    }

    public void add(int index, String value){
	add(value);
    }

    public int indexOfBinary(String element){
	int high = this.size();
	int low = 0;
	int n = 0;
	if (get(this.size()/2).equals(element)){
	    for (int x = this.size()/2; x>=0; x--){
		if (get(x).equals(element)){
		    n = x;
		}
	    }
	}
	else{
	    while (low != high){
		if (this.get(low+((high-low)/2)).equals(element)){
		    for (int x = low+((high-low)/2); x >= low; x--){
			if (this.get(x).equals(element)){
			    n = x;
			}
		    }
		    return n;
		}
		if (this.get(low+((high-low)/2)).compareTo(element) < 0){
		    low = low+((high-low)/2);
		}
		else{
		    high = low+((high-low)/2);
		}
	    }
	}
	return n;
    }

    public int lastIndexOfBinary(String element){
	int low = 0;
	int high = this.size();
	int n = 0;
	if (get(this.size()/2).equals(element)){
	    for (int x = this.size()/2; x < this.size(); x++){
		if (this.get(x).equals(element)){
		    n = x;
		}
	    }
	}
	else {
	    while (low != high){
		if (this.get(low+((high-low)/2)).compareTo(element) < 0){
		    low = low+((high-low)/2);
		}
		else{
		    if (this.get(low+((high-low)/2)).equals(element)){
			for (int x = low+((high-low)/2); x < high; x++){
			    if (this.get(x).equals(element)){
				n = x;
			    }
			}
			return n;
		    }
		    else {
			high = low+((high-low)/2);
		    }
		}
	    }
	}
	return n;
    }

    private int findIndexBinary(String value){
	int index = 0;
	int low = 0;
	int high = size();
	if (get(size()/2).compareTo(value) == 0){
	    index = size()/2;
	}
	else {
	    if (get(this.size()/2).compareTo(value) < 0){
		low = this.size()/2;
		while (low >= 0){
		    if (high-low > 1){
			if (this.get(low+(high-low)/2).compareTo(value) < 0){
			    low = low+((high-low)/2);
			}
		    }
		    else{
			index = low+1;
		    }
		}
	    }
	    else {
		high = this.size()/2;
		while (high >= 0){
		    if (high-low > 1){
			if (this.get(low+(high-low)/2).compareTo(value) < 0){
			    low = low+((high-low)/2);
			}
			else {
			    index = low+1;
			}
		    }
		}
	    }
	}
	return index;
    }

    
    public int findIndex(String value){
	int index = 0;
	boolean found = false;
	for (int x = 0; x < this.size(); x++){
	    if (this.get(x).compareTo(value) > 0 && found == false){
		found = true;
		index = x + 1;
	    }
	    else if (this.get(x).compareTo(value) == 0 && found == false){
		found = true;
		index = x;
	    }
	}
	return index;
    }


    public boolean add(String value){
	super.add(findIndex(value), value);
	return true;
    }
}
