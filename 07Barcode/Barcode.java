import java.util.*;

public class Barcode implements Comparable<Barcode>{
	private String zip;
	
	public Barcode(String zip){
		boolean digit = true;
		for (int x = 0; x < 5; x++){
			if (stringToInt(zip.charAt(x)+"") == -1){
				digit = false;
			}
		}
		if (zip.length()==5 && digit){
			this.zip = zip;
			}
		else{
			throw new IllegalArgumentException();
		}
	}

	public String getZip(){
		return zip;
	}
	
	public String getCode(){
		return toCode(zip);
	}
	
	public static String toZip(String code){
		String l = "";
		if (code.length() == 32){	
			if (code.charAt(0) == '|' && code.charAt(code.length()-1) == '|'){
				if (stringToInt(convertCode(code.substring(26, 31))) == checksum(convertCode(code.substring(0, 26)))){
					ArrayList<String> digits = new ArrayList<String>();
					String[] s = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
					for (int z = 0; z < 10; z++){
						digits.add(s[z]);
					}
					boolean go = true;
					for (int x = 1; x < 27; x+=5){
						if (digits.indexOf(code.substring(x,x+5)) == -1){
							go = false;
						}
					}
					if (go){
						for (int x = 1; x < 27; x+=5){
							l+=convertCode(code.substring(x, x + 5));
						}
					}
				}
			}
		}
		else{
			throw new IllegalArgumentException();
		}
		return l;
	}
	
	public String toString(){
		return getCode()+" ("+getZip()+")";
	}
	
	public int compareTo(Barcode a){
		return this.zip.compareTo(a.zip);
	}
	
	public boolean equals(Barcode a){
		return this.getZip().equals(a.getZip());
	}
	
	public static String toCode(String zip){
		boolean digit = true;
		for (int x = 0; x < 5; x++){
			if (stringToInt(zip.charAt(x)+"") == -1){
				digit = false;
			}
		}
		if (zip.length()==5 && digit){
			String s = "|";
			for (int x = 0; x < 5; x++){
				s+=convert(zip.charAt(x)+"");
			}
			return s+convert(checksum(zip)+"")+"|";
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	private static String convert(String x){
		String[] s = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
		return s[stringToInt(x)];
	}
	
	private static String convertCode(String x){
		ArrayList<String> digits = new ArrayList<String>();
		String[] s = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
		for (int z = 0; z < 10; z++){
			digits.add(s[z]);
		}
		return digits.indexOf(x)+"";
	}
	
	private static int stringToInt(String x){
		ArrayList<String> digits = new ArrayList<String>();
		for (int z = 0; z < 10; z++){
			digits.add(z+"");
		}
		return digits.indexOf(x);
	}
	
	public static int checksum(String zip){
		int n = 0;
		for (int x = 0; x < 5; x++){
			n+=stringToInt(zip.charAt(x)+"");
		}
		return n%10;
	}
}