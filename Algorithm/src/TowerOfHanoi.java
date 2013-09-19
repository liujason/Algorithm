
public class TowerOfHanoi {
	int n;
	int steps=0;
	public TowerOfHanoi(int n){
		this.n=n;
	}
	public void solve(){
		solve_r(n,1,3);
		System.out.println("Solved in "+steps+" steps");
	}
	private void solve_r(int n, int start, int target){
		if(n==0){
			return;
		}
		int pivot=6-start-target;
		solve_r(n-1,start,pivot);
		//System.out.println("Move disk "+n+" from "+start+" to "+target);
		steps++;
		solve_r(n-1,pivot,target);
	}
	public static void main(String[] args){
		TowerOfHanoi toh=new TowerOfHanoi(2);
		toh.solve();
	}
}
