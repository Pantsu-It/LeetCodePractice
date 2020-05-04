package practice;

import java.util.Arrays;

import static practice.Utils.swap;

public class AllOfSort {

    public static void main(String[] args) {
        Utils.printArray(quickSort(Utils.getShuffledArray(10)));
        Utils.printArray(quickSort3(Utils.getShuffledArray(10)));
        Utils.printArray(mergeSort(Utils.getShuffledArray(10)));
        Utils.printArray(heapSort(Utils.getShuffledArray(10)));
        Utils.printArray(shellSort(Utils.getShuffledArray(10)));
        Utils.printArray(insertSort(Utils.getShuffledArray(10)));
        Utils.printArray(bubbleSort(Utils.getShuffledArray(10)));
    }

    private static int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int start, int end) {
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
        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);
    }

    private static int[] quickSort3(int[] nums) {
        quickSort3(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort3(int[] array, int start, int end) {
        //初始化三指针
        //小于主元的指针和等于主元的指针都初始化为下标为数组第二个
        //大于主元的指针初始化为尾元
        int smaller = start + 1;
        int equal = smaller;
        int bigger = end;
        //设置退出条件
        if (smaller > bigger) return;
        //选择主元，一般为首元
        int num = array[start];
        /*
         * 当smaller扫描到的数字小于主元，则下标为smaller和equal的需要交换数据，这样就又将小于主元的放在一起了，然后smaller和equal都要自增
         * 当smaller扫描到的数字等于主元，直接将smaller自增
         * 当smaller扫描到的数字大于主元，就将小标为smaller和bigger上的数据交换，bigger再自减(和单向扫描分区法处理一样）
         */
        while (smaller <= bigger) {
            if (array[smaller] < num) {
                swap(array, equal, smaller);
                equal++;
                smaller++;
            } else if (array[smaller] == num) {
                smaller++;
            } else if (array[smaller] > num) {
                swap(array, smaller, bigger);
                bigger--;
            }
        }
        //交换首元与right上的数
        swap(array, start, equal - 1);
        //继续将right两边的数组进行快速排序
        quickSort3(array, start, equal - 2);
        quickSort3(array, bigger + 1, end);
    }

    public static int[] mergeSort(int[] array) {
        int length = array.length;
        int middle = length / 2;

        if (length > 1) {
            int[] left = Arrays.copyOfRange(array, 0, middle);//拷贝数组array的左半部分
            int[] right = Arrays.copyOfRange(array, middle, length);//拷贝数组array的右半部分
            mergeSort(left);//递归array的左半部分
            mergeSort(right);//递归array的右半部分
            merge(array, left, right);//数组左半部分、右半部分合并到Array
        }
        return array;
    }

    //合并数组，升序
    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0, l = 0, r = 0;

        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                result[i] = left[l];
                i++;
                l++;
            } else {
                result[i] = right[r];
                i++;
                r++;
            }
        }

        while (r < right.length) {//如果右边剩下合并右边的
            result[i] = right[r];
            r++;
            i++;
        }

        while (l < left.length) {
            result[i] = left[l];
            l++;
            i++;
        }
    }


    private static int[] heapSort(int[] nums) {
        // 构建最大堆
        for (int i = nums.length / 2 - 1; i >= 0; --i) {
            maxHeapify(nums, i, nums.length - 1);
        }
        // 调整最大堆
        for (int i = nums.length - 1; i > 0; --i) {
            swap(nums, 0, i);
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
            swap(nums, dad, son);
            dad = son;
            son = dad * 2 + 1;
        }
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

    private static int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length - 1; ++i) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > temp) {
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
                    swap(nums, i, j);
                }
            }
        }
        return nums;
    }


}
