package offer;

/**
 * Created by gfn on 2017/5/29.
 */
public class Problem11 {
	public int JumpFloorII(int target) {
		if (target <= 0) {
			return -1;
		} else if (target == 1) {
			return 1;
		} else {
			return 2 * JumpFloorII(target-1);
		}
	}


}
