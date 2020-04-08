package practice;

public class PrintNumber {
    public static void main(String[] args) {
        printNumberRect(5);
        printFibonacci(1, 1, 0, 20);
    }

    // 建议使用for循环
    private static void printNumberRect(int maxNumber) {
        int width = maxNumber * 2 - 1;
        int[][] nums = new int[width][width];
        int i = 0, j = 0;
        int number = 1;
        while (number <= maxNumber) {
            int gap = number -1;

            if (i==j && i == maxNumber -1) {
                nums[i][j] = maxNumber;
                break;
            }
            do {
                nums[i][j] = number;
            } while (++i < width - 1 - gap);
            do {
                nums[i][j] = number;
            } while (++j < width - 1- gap);
            do {
                nums[i][j] = number;
            } while (--i > gap);
            do {
                nums[i][j] = number;
            } while (--j >gap);
            ++i;
            ++j;
            ++number;
        }
        Utils.printArray(nums);
    }

    private static void printFibonacci(int a, int b, int count, int total) {
        if (count >= total) {
            return;
        }
        System.out.print(a + " ");
        printFibonacci(b, a + b, ++count, total);
    }

}