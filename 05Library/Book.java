public class Book{
    private String author;
    private String title;
    private String ISBN;
    public Book(String a, String t, String i){
	author = a;
	title = t;
	ISBN = i;
    }
    public Book(){
    }
    public String getAuthor(){
	return author;
    }
    public String getTitle(){
	return title;
    }
    public String getISBN(){
	return ISBN;
    }
    public void setAuthor(String a){
	author = a;
    }
    public void setTitle(String t){
	title = t;
    }
    public void setISBN(String i){
	ISBN = i;
    }
    public String toString(){
	return getTitle()+", "+getAuthor()+", "+getISBN();
    }
}
