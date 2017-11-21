import java.util.*;
import java.io.*;

public class WordSearch{
    private char[][]data;
	public ArrayList<String> wordsToAdd;
	private ArrayList<String> wordsAdded;
	private Random randgen;
	private int seed;

	public WordSearch(int rows, int cols){
		data = new char[rows][cols];
		for (int x = 0; x < rows; x++){
			for (int y = 0; y < cols; y++){
				data[x][y]='_';
			}
		}
	}
	
	public WordSearch(int rows, int cols, String fileName){
		data = new char[rows][cols];
		for (int x = 0; x < rows; x++){
			for (int y = 0; y < cols; y++){
				data[x][y]='_';
			}
		}
		try{
			File f = new File(fileName);
			Scanner in = new Scanner(f);
			wordsToAdd = new ArrayList<String>();
			while (in.hasNext()){
				String word = in.nextLine();
				wordsToAdd.add(word);
			}
			in.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File not found: " + fileName);
			System.exit(1);
		}
		randgen = new Random();
		seed = randgen.nextInt(1000);
		randgen = new Random(seed);
	}
	
	public WordSearch(int rows, int cols, String fileName, int randSeed){
		data = new char[rows][cols];
		for (int x = 0; x < rows; x++){
			for (int y = 0; y < cols; y++){
				data[x][y]='_';
			}
		}
		try{
			File f = new File(fileName);
			Scanner in = new Scanner(f);
			wordsToAdd = new ArrayList<String>();
			while (in.hasNext()){
				String word = in.nextLine();
				wordsToAdd.add(word);
			}
			in.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File not found: " + fileName);
			System.exit(1);
		}
		seed = randSeed;
		randgen = new Random(seed);
	}

    private void clear(){
		for (int x = 0; x < data.length; x++){
			for (int y = 0; y < data[x].length; y++){
				data[x][y]='_';
			}
		}
    }

    public String toString(){
		String s = "";
		for (int x = 0; x < data.length; x++){
			for (int y = 0; y < data[x].length; y++){
				s+=data[x][y]+" ";
			}
			s+="\n";
		}
		return s;
    }
	
	public boolean addWord(int r, int c, String word, int rowIncrement, int colIncrement){
		if (r >= data.length || c >= data[r].length ||
		(rowIncrement == 0 && colIncrement == 0)){
			return false;
		}
		if (rowIncrement == 1){
			if (r + word.length() >= data.length){
				return false;
			}
		}
		if (colIncrement == 1){
			if (c + word.length() >= data[0].length){
				return false;
			}
		}
		if (rowIncrement == -1){
			if (r - word.length() < -1){
				return false;
			}
		}
		if (colIncrement == -1){
			if (c - word.length() < -1){
				return false;
			}
		}
		for (int x = 0; x < word.length(); x++){
			if (data[r+rowIncrement*x][c+colIncrement*x]!='_' && data[r+rowIncrement*x][c+colIncrement*x]!=word.charAt(x)){
				return false;
			}
		}
		for (int x = 0; x < word.length(); x++){
			data[r+rowIncrement*x][c+colIncrement*x]=word.charAt(x);
		}
		return true;
	}
	
	public boolean addAllWords(){
		wordsAdded = new ArrayList<String>();
		int inc = 10000;
		while (inc > 0){
			if (wordsToAdd.size()==0){
				return true;
			}
			int r = randgen.nextInt(data.length);
			int c = randgen.nextInt(data[0].length);
			int ri = randgen.nextInt(3)-1;
			int ci = randgen.nextInt(3)-1;
			if (this.addWord(r, c, wordsToAdd.get(0), ri, ci)){
				wordsAdded.add(wordsToAdd.get(0));
				wordsToAdd.remove(0);
			}
			inc--;
		}
		return false;
	}

	public String getWords(){
		String s = "";
		for (int x = 0; x < wordsAdded.size(); x++){
			s=s+wordsAdded.get(x)+"   ";
			if (x%3==2){
				s+="\n";
			}
		}
		return s;
	}
	
	private void randletters(){
		String s = "abcdefghijklmnopqrstuvwxyz";
			for (int x = 0; x < data.length; x++){
				for (int y = 0; y < data[x].length; y++){
					if (data[x][y]=='_'){
						data[x][y]=s.charAt(randgen.nextInt(26));
					}
				}
			}
	}
	
	public static void directions(){
		System.out.println("Please enter the desired size of your word search and the name of the text file containing the words you wish to include in your word search as follows:");
		System.out.println("java WordSearch rows columns file.txt");
		System.out.println("");
		System.out.println("If you wish to recreate a word search, please enter the random seed of that word search as follows:");
		System.out.println("java WordSearch rows columns file.txt seed");
		System.out.println("");
		System.out.println("To view the answer key for a specific puzzle, please enter the following:");
		System.out.println("java WordSearch rows columns file.txt seed key");
	}
	
	public static void main(String[] args){
		if (args.length==3){
			try{
				if (Integer.parseInt(args[0]) > 0 && Integer.parseInt(args[1]) > 0){
					WordSearch puzzle = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
					puzzle.addAllWords();
					puzzle.randletters();
					System.out.println(puzzle.toString());
					System.out.println(puzzle.getWords());
					System.out.println("");
					System.out.println("Your seed is: "+puzzle.seed);
					System.exit(1);
				}
			}
			catch (NumberFormatException e){
				directions();
				System.exit(1);
			}
		}
		if (args.length==4){
			try{
				if (Integer.parseInt(args[0]) > 0 && Integer.parseInt(args[1]) > 0){
					WordSearch puzzle = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
					puzzle.addAllWords();
					puzzle.randletters();
					System.out.println(puzzle.toString());
					System.out.println(puzzle.getWords());
					System.out.println("");
					System.out.println("Your seed is: "+puzzle.seed);
					System.exit(1);
				}
			}
			catch(NumberFormatException e){
				directions();
				System.exit(1);
			}
		}
		if (args.length==5){
			if (args[4].equals("key")){
				try{
					if (Integer.parseInt(args[0]) > 0 && Integer.parseInt(args[1]) > 0){
						WordSearch puzzle = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
						puzzle.addAllWords();
						System.out.println(puzzle.toString());
						System.exit(1);
					}
				}
				catch(NumberFormatException e){
					directions();
					System.exit(1);
				}
			}
			else{
				directions();
				System.exit(1);
			}
		}
		else{
			directions();
		}
	}
}