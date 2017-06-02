package offer;

/**
 * Created by gfn on 2017/5/29.
 */
public class Problem09 {
	/**
	 * 题目：
	 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
	 * n<=39
	 *
	 * 思路：
	 * 递归，迭代，尾递归，等方法，
	 * @param n
	 * @return
	 */
	public int Fibonacci(int n) {
        int preNum=1;
        int prePreNum=0;
        int result=0;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        for(int i=2;i<=n;i++){
            result=preNum+prePreNum;
            prePreNum=preNum;
            preNum=result;
        }
        return result;
 
    }
}
