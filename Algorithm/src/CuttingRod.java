
public class CuttingRod {
	int[] price={0, 1,5,8,9,10,17,17,20};
	int length;
	
	public CuttingRod(int[] price, int length){
		this.price=price;
		this.length=length;
	}
	
	public void solve(){
		System.out.println("Max value recursion="+solve_r(length));
		System.out.println("Max value iterative="+ solve_i());
	}
	//iterative approach
	private int solve_i(){
		int[] max=new int[length+1];
		max[0]=price[0];
		max[1]=price[1];
		for (int i=1;i<max.length;i++){
			max[i]=Integer.MIN_VALUE;
			for(int j=0;j<i;j++){
				max[i]=Math.max(max[i], Math.max(price[i], max[j]+max[i-j]));	
			}
		}
		return max[length];
	}
	//recursive approach
	private int solve_r(int length){
		if(length==1){
			return price[1];
		}
		if(length==0){
			return 0;
		}
		
		int value=Integer.MIN_VALUE;
		for (int i=1;i<length+1;i++){
			//System.out.println(length+":"+i);
			value= Math.max(value, price[i]+solve_r(length-i)); 
		}
		return value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CuttingRod cr=new CuttingRod(new int[]{0,1,5,8,9,10,17,17,20},8);
		cr.solve();
	}

}
