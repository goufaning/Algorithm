package offer;

/**问题：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 思路：
 * 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
 * 因此从左下角开始查找，当要查找数字比左下角数字大时。右移
 * 要查找数字比左下角数字小时，上移
 *
 * Created by gfn on 2017/5/26.
 */
public class Problem03 {
    public static boolean find(int target, int [][] array) {
		if(array==null)
			return false;
		int column = array[0].length-1;
		int row = 0;
		while(row<array.length&&column>=0) {
			if(array[row][column]==target) {
				return true;
			}
			if(array[row][column]>target) {
				column--;
			}else{
				row++;
			}
		}
		return false;
	}

	public static void main(String args[]){
		int[][] testarray=new int[4][4];
		testarray[0][0]=1;
		testarray[0][1]=2;
		testarray[0][2]=8;
		testarray[0][3]=9;
		testarray[1][0]=2;
		testarray[1][1]=4;
		testarray[1][2]=9;
		testarray[1][3]=12;
		testarray[2][0]=4;
		testarray[2][1]=7;
		testarray[2][2]=10;
		testarray[2][3]=13;
		testarray[3][0]=6;
		testarray[3][1]=8;
		testarray[3][2]=11;
		testarray[3][3]=15;
		System.out.println(find(1,testarray));
	}
}
