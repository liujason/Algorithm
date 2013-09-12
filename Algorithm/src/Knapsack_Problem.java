/**
 * This class solves the knapsack problem. 
 * Provide an array of values
 * Provide an array of weights
 * The length of both arrays must match.
 * Provide a capacity
 * 
 * The problem computes the maximum value of items to pick. 
 * 
 * @author jason
 *
 */
public class Knapsack_Problem {
	int v[];
	int w[];
	int c;
	public Knapsack_Problem(int value[], int weight[], int capacity){
		v=value;
		w=weight;
		c=capacity;
	}
	
	public void solve(){
		System.out.println("Knapsack total value of "+ks(c,0));
	}
	/**
	 * Recursively figure out the max value of the knapsack problem
	 * @param c
	 * @param i
	 * @return
	 */
	private int ks(int c, int i){
		if (i==v.length-1){
			return 0;
		}
		if (c<w[i]){
			return ks(c, w[i+1]);
		}else{
			return Math.max(ks(c, i+1), v[i]+ks(c-w[i], i+1));
		}
		
	}
	public static void main(String[] args){
		int v[]=new int[]{7,2,1,6,12};
		int w[]=new int[]{3,1,2,4,6};
		int c=10;
		
		Knapsack_Problem p=new Knapsack_Problem(v,w,c);
		p.solve();
	}
}
