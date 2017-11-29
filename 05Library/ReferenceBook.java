public class ReferenceBook extends LibraryBook{
    private String collection;
    public ReferenceBook(String a, String t, String i, String c, String coll){
        super(a,t,i,c);
	collection = coll;
    }
    public String getCollection(){
	return collection;
    }
    public void setCollection(String coll){
	collection = coll;
    }
    public void checkout(String patron, String due){
	System.out.println("Sorry, you can't check out a reference book");
    }
    public void returned(){
	System.out.println("Reference book couldn't have been checked out - return impossible");
    }
    public String circulationStatus(){
	return "non-circulating reference book";
    }
}
