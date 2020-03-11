package Sort;

/**
 * Created by gfn on 2017/4/25.
 */
public class BucketSort {
    /**
     * 桶排序
     * @param a 待排序的数组
     * @param max 数组a中最大值的范围
     */
    public static void bucketSort(int[] a, int max) {
        int[] buckets;

        if (a==null || max<1)
            return ;
        buckets = new int[max];
        for(int i = 0; i < a.length; i++)
            buckets[a[i]]++;
        for (int i = 0, j = 0; i < max; i++) {
            while( (buckets[i]--) >0 ) {
                a[j++] = i;
            }
        }
        buckets = null;
    }

    public static void main(String[] args) {
        int i;
        int a[] = {8,2,3,4,3,6,6,3,9};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        bucketSort(a, 10); // 桶排序

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
