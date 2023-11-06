import java.util.*;

public class Knapsack{
	public static int max(int a,int b){
		return a>b?a:b;
	}
		
		
	public static int knap(int W,int[] wt,int[] val, int n){
		int i,w;
		int[][] k = new int[n+1][W+1];
		boolean[][] selected = new boolean[n+1][W+1];
		
		
		
		for(i=0;i<=n;i++){
			for(w=0;w<=W;w++){
				if(i==0 || w==0)
					k[i][w]=0;
				else if(wt[i-1]<=w){
					//k[i][w] = max(val[i-1]+k[i-1][w-wt[i-1]], k[i-1][w]);
					int includeItem = val[i-1]+k[i-1][w-wt[i-1]];
					int excludeItem = k[i-1][w];
					
					if(includeItem>excludeItem){
						k[i][w] = includeItem;
						selected[i][w] = true;
					}
					else
						k[i][w] = excludeItem;
				}	
				else
					k[i][w] = k[i-1][w];
				System.out.print(k[i][w]+" ");
			}System.out.println();
		} 
		int remainingWeight = W;
        List<Integer> selectedItems = new ArrayList<>();

        for (i = n; i > 0; i--) {
            if (selected[i][remainingWeight]) {
                selectedItems.add(i - 1);
                remainingWeight -= wt[i - 1];
            }
        }

        System.out.print("Selected items with their weights: ");
        for (int itemIndex : selectedItems) {
            System.out.print("Item " + (itemIndex + 1) + " (Weight: " + wt[itemIndex] + ") ");
        }
        System.out.println();
		return k[n][W];
	}

	static int RecursiveknapSack(int W, int wt[], int val[], int n) 
    { 
        // Base Case 
        if (n == 0 || W == 0) 
            return 0; 
  
        // If weight of the nth item is 
        // more than Knapsack capacity W, 
        // then this item cannot be included 
        // in the optimal solution 
        if (wt[n - 1] > W) 
            return RecursiveknapSack(W, wt, val, n - 1); 
  
        // Return the maximum of two cases: 
        // (1) nth item included 
        // (2) not included 
        else
            return max(val[n - 1] + RecursiveknapSack(W - wt[n - 1], wt, val, n - 1), RecursiveknapSack(W, wt, val, n - 1)); 
    } 
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of items : ");
		int n = sc.nextInt();
		int val[] = new int[n];
        int wt[] = new int[n];
		System.out.println();
		System.out.print("Enter the maximum weight : ");
        int W = sc.nextInt();
		
		System.out.println("Enter the values : ");
		for(int i=0;i<n;i++){
			val[i] = sc.nextInt();
		}
		
		System.out.println("Enter the weight : ");
		for(int i=0;i<n;i++){
			wt[i] = sc.nextInt();
		}
       // int n = val.length;
	   long start = System.currentTimeMillis();
        System.out.println(knap(W, wt, val, n));
		long end = System.currentTimeMillis();
		System.out.println("The time required is : "+(end-start)+" ms");
		
		System.out.println("****************");
		start = System.currentTimeMillis();
        System.out.println(RecursiveknapSack(W, wt, val, n));
		end = System.currentTimeMillis();
		System.out.println("The time required is : "+(end-start)+" ms");
	}
}