package offer;

/**
 * Created by gfn on 2017/5/29.
 */
public class Problem12 {


	public int RectCover(int target) {
      if(target  < 1){
            return 0;
        }
        if(target*2 == 2){
            return 1;
        }else if(target*2 == 4){
            return 2;
        }else{
            return RectCover((target-1))+RectCover(target-2);
        }
    }
}
