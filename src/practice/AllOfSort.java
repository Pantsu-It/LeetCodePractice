package practice;

import java.util.HashMap;

public class AllOfSort {

    public static void main(String[] args) {
        int[] nums = Utils.getShuffledArray(10);
        Utils.printArray(quickSort(nums));
        Utils.printArray(shellSort(nums));
        Utils.printArray(heapSort(nums));
        Utils.printArray(insertSort(nums));
        Utils.printArray(bubbleSort(nums));
        HashMap map = new HashMap<>();
    }

    private static int[] quickSort(int[] nums) {
        quickSortS(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSortS(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int compare = nums[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && nums[j] >= compare) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= compare) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = compare;
        quickSortS(nums, start, i - 1);
        quickSortS(nums, i + 1, end);
    }


    private static int[] shellSort(int[] nums) {
        int gap = nums.length;
        while (true) {
            gap /= 2;
            for (int i = 0; i < nums.length; ++i) {
                for (int j = i + gap; j < nums.length; j += gap) {
                    int temp = nums[j];
                    int k = j - gap;
                    while (k >= 0 && nums[k + gap] < nums[k]) {
                        nums[k + gap] = nums[k];
                        k -= gap;
                    }
                    nums[k + gap] = temp;
                }
            }
            if (gap == 1) {
                break;
            }
        }
        return nums;
    }


    private static int[] heapSort(int[] nums) {
        // 构建最大堆
        for (int i = nums.length / 2 - 1; i >= 0; --i) {
            maxHeapify(nums, i, nums.length - 1);
        }
        // 调整最大堆
        for (int i = nums.length - 1; i > 0; --i) {
            Utils.swapArray(nums, 0, i);
            maxHeapify(nums, 0, i - 1);
        }
        return nums;
    }

    private static void maxHeapify(int[] nums, int start, int end) {
        int dad = start;
        int son = start * 2 + 1;
        while (son <= end) {
            if (son + 1 <= end && nums[son] < nums[son + 1]) {
                son++;
            }
            if (nums[dad] >= nums[son]) {
                return;
            }
            Utils.swapArray(nums, dad, son);
            dad = son;
            son = dad * 2 + 1;
        }
    }

    private static int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length - 1; ++i) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > nums[j + 1]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
        return nums;
    }

    private static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] > nums[j]) {
                    Utils.swapArray(nums, i, j);
                }
            }
        }
        return nums;
    }


}
