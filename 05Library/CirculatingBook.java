public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;
    public CirculatingBook(String a, String t, String i, String c){
	super(a,t,i,c);
    }
    public String getCurrentHolder(){
	return currentHolder;
    }
    public String getDueDate(){
	return dueDate;
    }
    public void setCurrentHolder(String curr){
	currentHolder = curr;
    }
    public void setDueDate(String dd){
	dueDate = dd;
    }
    public void checkout(String patron, String due){
	setCurrentHolder(patron);
	setDueDate(due);
    }
    public void returned(){
	currentHolder=null;
	dueDate=null;
    }
    public String circulationStatus(){
	if (currentHolder == null){
	    return "book available on shelves";
	}
	return "Current holder: "+currentHolder+" Due: "+dueDate;
    }
    public String toString(){
	return super.toString();
    }
}
