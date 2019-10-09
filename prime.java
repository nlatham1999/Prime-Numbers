import java.util.*;
import java.io.*;

class prime
{
    private static long getPrimesV1(int n){
		//Empty String
       
        long timeFirst = System.nanoTime();
		int i =0;
		int num =0;

        ArrayList<Integer> list = new ArrayList<Integer>();

		for (i = 2; i <= n; i++)  	   
		{ 		 
            int size = list.size();
            boolean isPrime = true;
            double square = Math.sqrt(i);
            for(int j = 0; j < size && isPrime && list.get(j) <= square; j++)
                if(i%list.get(j)==0)
                    isPrime = false;
            if(isPrime)
                list.add(i);
		}	
        
        
        long timeSecond = System.nanoTime();
        return timeSecond - timeFirst;
		// System.out.println(list);
		
	}
	
	private static long getPrimesV2(int n){

        long timeFirst = System.nanoTime();

        int last;

		ArrayList<Integer> list = new ArrayList<Integer>();
		if(n >= 2){
			list.add(2);
            if(n >= 3){
                list.add(3);
                last = 3;
                for(int i = 2; last < n; i++){
                    int prime = 3*i - 1 - i%2;
                    int size = list.size();
                    boolean isPrime = true;
                    double square = Math.sqrt(prime);
                    for(int j = 0; j < size && isPrime && list.get(j) <= square; j++)
                        if(prime%list.get(j)==0)
                            isPrime = false;
                    if(isPrime && prime < n)
                        list.add(prime);
                    last = prime;
                }
            }
        }
        long timeSecond = System.nanoTime();
        return timeSecond - timeFirst;
		// System.out.println(list);
    }

	public static void main (String[] args)
	{		
        Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n = scanner.nextInt();
		scanner.close();

        while(true){
            System.out.println("V1: " + getPrimesV1(n));
            System.out.println("V2: " + getPrimesV2(n));
        }
	}
   
	
}