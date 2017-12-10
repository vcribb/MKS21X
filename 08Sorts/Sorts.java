import java.util.Arrays;

public class Sorts{
	
	public static String name(){
		return "10,Cribb,Vivian";
	}
	
	public static void selectionSort(int[]data){
		for (int x = 0; x < data.length; x++){
			for (int y = x + 1; y < data.length; y++){
				if (data[y] < data[x]){
					int temp = data[x];
					data[x] = data[y];
					data[y] = temp;
				}
			}
		}
	}
	
	public static void insertionSort(int[]data){
		for (int x = 0; x < data.length; x++){
			for (int y = x; y > 0; y--){
				if (data[y] < data[y - 1]){
					int temp = data[y];
					data[y] = data[y - 1];
					data[y - 1] = temp;
				}
			}
		}
	}
	
	public static void bubbleSort(int[]data){
		int n = 0;
		boolean exit = false;
		while (n < (data.length - 1) && !exit){
			int swaps = 0;
			for (int x = 0; x < (data.length - 1 - n); x++){
				if (data[x] > data[x + 1]){
					int temp = data[x];
					data[x] = data[x + 1];
					data[x + 1] = temp;
					swaps++;
				}
			}
			if (swaps == 0){
				exit = true;
			}
			n++;
		}		
	}
}