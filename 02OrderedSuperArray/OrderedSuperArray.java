public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(){
	super();
    }
    public OrderedSuperArray(int capacity){
	super(capacity);
    }
    public OrderedSuperArray(String[] ary){
	super(ary.length);
	for (int n = 0; n < ary.length; n++){
	    add(ary[n]);
	}
    }
    public void add(int index, String value){
		add(value);
    }
	public int indexOfBinary(String element){
		if (this.size()==0){
			return 0;
		}
		if (element.equals(this.get(0))){
			return 0;
		}
		int start = 0;
        int end = this.size() - 1;
        while (start <= end) {
            int m = (start+end+1) / 2;
            if (element.equals(this.get(m))) {
				if (m!=0){
					if (!(element.equals(this.get(m-1)))){
						return m;
					}
				}
            }
            if (element.compareTo(this.get(m))>0) {
                start = m + 1;
				
            }
			else {
                end = m - 1;
            }
        }
        return -1;
	}
	public int lastIndexOfBinary(String element){
        if (this.size()==0){
			return -1;
		}
		if (element.equals(this.get(this.size()-1))){
			return this.size()-1;
		}
		int start = 0;
        int end = this.size() - 1;
        while (start <= end) {
            int m = (start+end+1) / 2;
            if (element.equals(this.get(m))){
				if (m!=(this.size()-1)){
					if (!(element.equals(this.get(m+1)))){
						return m;
					}
				}
            }
            if (element.compareTo(this.get(m))>0) {
                start = m + 1;
            }
			else {
                end = m - 1;
            }
        }
        return -1;
	}
	private int findIndex(String element){
		int n = this.size();
		for (int x = 0; x < this.size(); x++){
			if (element.compareTo(get(x))<0){
				if (x < n){
					n = x;
				}
			}
		}
		return n;
	}
	private int findIndexBinary(String element) {
        if (this.size()==0){
			return 0;
		}
		if (this.size()==1){
			if (element.compareTo(this.get(0))<0){
				return 0;
			}
			return 1;
		}
		int start = 0;
        int end = this.size() - 1;
        while (start <= end) {
            int m = (start + end + 1) / 2;
			if (element.compareTo(this.get(m))==0){
				return m;
			}
            if (element.compareTo(this.get(m))>0) {
                if (m > 0){
					if (element.compareTo(this.get(m-1))<0){
						return m;
					}
				}
				if (m==0){
					return m;
				}
				end = m - 1;
            }
            else {
                start = m + 1;
            }
        }
		return 0;
    }
    public boolean add(String value){
	int n = this.size();
	if (n==0){
	    super.add(value);
	    return true;
	}
	super.add(findIndex(value), value);
	return true;
    }
}
