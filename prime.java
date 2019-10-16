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
	
	private static long getPrimesV3(int n){

        long timeFirst = System.nanoTime();

        int last;

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(n >= 2){
			list.add(2);
            if(n >= 3){
                list.add(3);
				if(n >= 5){
					list.add(5);
					heap.add(5*5);
					last = 5;
					for(int i = 3; last < n; i++){
						int prime = 3*i - 1 - i%2;
						if(heap.peek() == null || prime != heap.peek()){
							list.add(prime);
							int size = list.size();
							boolean inRange = true;
							for(int j = 2; j < size && inRange; j++){
								int temp = list.get(j)*prime;
								if(temp <= n) // (temp <= n) ? head.add(temp) : inRange = false;
									heap.add(temp);
								else
									inRange = false;
							}
						}else{
							long temp = heap.poll();
						}
						last = prime;
					}
				}
            }
        }
        long timeSecond = System.nanoTime();
		//System.out.println(list);
		
        return timeSecond - timeFirst;
    }

	public static void main (String[] args)
	{		
        Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n = scanner.nextInt();
		scanner.close();

        for(int i = 0; i < 3; i++){
            System.out.println("V1: " + getPrimesV1(n));
            System.out.println("V2: " + getPrimesV2(n));
            System.out.println("V3: " + getPrimesV3(n));
            System.out.println(" ");
        }
	}
   
	
}