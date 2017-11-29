abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    public LibraryBook(String a, String t, String i, String c){
	super(a,t,i);
	callNumber = c;
    }
    public String getCallNumber(){
	return callNumber;
    }
    public void setCallNumber(String c){
	callNumber = c;
    }
    public int compareTo(LibraryBook a){
	return this.getCallNumber().compareTo(a.getCallNumber());
    }
    public String toString(){
	return super.toString()+", "+getCallNumber();
    }
    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();
}
