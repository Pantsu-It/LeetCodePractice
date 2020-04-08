package leetcode.editor.en;

//Given an array nums of n integers and an integer target, are there elements a,
// b, c, and d in nums such that a + b + c + d = target? Find all unique quadruple
//ts in the array which gives the sum of target. 
//
// Note: 
//
// The solution set must not contain duplicate quadruplets. 
//
// Example: 
//
// 
//Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
//A solution set is:
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics Array Hash Table Two Pointers


import java.util.*;

public class P18FourSum {
    public static void main(String[] arg) {
        Solution solution = new P18FourSum().new Solution();
        int[] nums = {1, 0, -1, 0, -2, 2};
        solution.fourSum(nums, 0);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Set<List<Integer>> resultSet = new HashSet<>();
            Arrays.sort(nums);

            Index indexS = new Index();
            List<Index> indexList = new ArrayList<>();
            for (int i = 0; i < nums.length - 1; ++i) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int sum = nums[i] + nums[j];
                    indexS.sum = sum;
                    int putIndex = Collections.binarySearch(indexList, indexS);

                    Set<List<Integer>> putList;
                    if (putIndex >= 0) {
                        putList = indexList.get(putIndex).indexes;
                    } else {
                        putList = new HashSet<>();

                        Index index = new Index();
                        index.sum = sum;
                        index.indexes = putList;
                        indexList.add(-putIndex - 1, index);
                    }

                    List<Integer> list = new ArrayList<>(2);
                    list.add(i);
                    list.add(j);
                    putList.add(list);
                }
            }

            int i = 0, j = indexList.size() - 1;
            while (i <= j) {
                Index index1 = indexList.get(i);
                Index index2 = indexList.get(j);

                if (index1.sum + index2.sum < target) {
                    ++i;
                } else if (index1.sum + index2.sum > target) {
                    --j;
                } else {
                    for (List<Integer> indexes1 : index1.indexes) {
                        for (List<Integer> indexes2 : index2.indexes) {
                            if (indexes1.get(0) != indexes2.get(0)
                                    && indexes1.get(0) != indexes2.get(1)
                                    && indexes1.get(1) != indexes2.get(0)
                                    && indexes1.get(1) != indexes2.get(1)) {
                                resultSet.add(getIntegerList(nums, indexes1.get(0), indexes1.get(1), indexes2.get(0), indexes2.get(1)));
                            }
                        }
                    }
                    ++i;
                    --j;
                }
            }
            return new ArrayList<>(resultSet);
        }

        class Index implements Comparable<Index> {
            int sum;
            Set<List<Integer>> indexes = new HashSet<>();

            void addIndex(List<Integer> integers) {
                indexes.add(integers);
            }

            @Override
            public int compareTo(Index o) {
                return this.sum - o.sum;
            }
        }

        private List<Integer> getIntegerList(int[] nums, int x, int y, int i, int j) {
            List<Integer> result = new ArrayList<>(4);
            if (j < x) {
                result.add(nums[i]);
                result.add(nums[j]);
                result.add(nums[x]);
                result.add(nums[y]);
            } else if (i > y) {
                result.add(nums[x]);
                result.add(nums[y]);
                result.add(nums[i]);
                result.add(nums[j]);
            } else {
                if (x < i) {
                    result.add(nums[x]);
                    result.add(nums[i]);
                } else {
                    result.add(nums[i]);
                    result.add(nums[x]);
                }
                if (j < y) {
                    result.add(nums[j]);
                    result.add(nums[y]);
                } else {
                    result.add(nums[y]);
                    result.add(nums[j]);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}