package Sort;

public class CountingSort {
    /**
     * @param arr 正数数组
     * @param k 数组中的最大值
     */
    public static void sort(int[] arr,int k) {
        int[] C = new int[k+1];
        for (int i = 0; i < arr.length; i++) {
            C[arr[i]]++;
        }
        int z = 0;
        for (int i = 0; i <= k; i++)
        {
            while (C[i]-- > 0)
            {
                arr[z++] = i;
            }
        }
    }
}
