/* package whatever; // don't place package name! */
//Tested https://ideone.com/YKxrO6
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Sort
{
	public final static int[] DATA = new int[]{5,8,6,0,7,1,2,4,3,9};
	
	public static int[] mergeSort(int[] data){
		if(data.length<2){
			return data;
		}
		int[] a1 = new int[data.length/2];
		int[] a2 = new int[data.length - a1.length];
		for (int i=0;i<a1.length;i++){
			a1[i]=data[i];	
		}
		for (int i=0;i<a2.length;i++){
			a2[i]=data[i+a1.length];
		}
		return merge(mergeSort(a1), mergeSort(a2));
	}
	private static int[] merge (int[] a1, int[] a2){
		int[] result = new int[a1.length+a2.length];
		int i1=0;
		int i2=0;
		int ir=0;
		while(i1<a1.length||i2<a2.length){
			if(i1==a1.length){
				result[ir]=a2[i2];
				i2++;
				ir++;
				continue;
			}
			if (i2==a2.length){
				result[ir]=a1[i1];
				i1++;
				ir++;
				continue;
			}
			
			if (a1[i1]<a2[i2]){
				result[ir]=a1[i1];
				i1++;
			}else{
				result[ir]=a2[i2];
				i2++;
			}
			ir++;
		}
		return result;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] result = Sort.mergeSort(DATA);
		for (int r:result){
			System.out.print(r+" ");
		}
	}
}
