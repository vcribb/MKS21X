public class ReversedCharSequence{
    private String str;
    public ReversedCharSequence(String s){
        str = "";
	for (int x = s.length()-1; x > -1; x--){
	    str += s.substring(x,x+1);
	}
    }
    public char charAt(int index){
	return str.charAt(index);
    }
    public int length(){
	return str.length();
    }
    public CharSequence subSequence(int start, int end){
	String s = "";
	for (int x = start; x < end; x++){
	    s+=str.charAt(x);
	}
	return s;
    }
    public String toString(){
	return str;
    }
}
