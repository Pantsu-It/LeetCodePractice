package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printArray(int[][] nums) {
        for (int[] _nums : nums) {
            printArray(_nums);
        }
    }

    public static int[] getShuffledArray(int length) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; ++i) {
            list.add(i);
        }
        Collections.shuffle(list);

        int[] nums = new int[length];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = list.get(i);
        }

        System.out.println(list);
        return nums;
    }

    public static void print(Object object) {
        System.out.print(object);
    }

    public static void println(Object object) {
        System.out.println(object);
    }
}
