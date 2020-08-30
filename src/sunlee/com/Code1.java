package sunlee.com;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那
 * 两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * @author sunlee
 * @date 2020/8/28 23:34
 */
public class Code1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] ints = twoSum2(nums, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target){
                    return new int[]{nums[i],nums[j]};
                }
            }
        }
        throw new IllegalArgumentException("not exist");
    }

    public static int[] twoSum2(int[] nums, int target)  {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp=target-nums[i];
            if (map.containsKey(temp)&&map.get(temp)!=i){
                return new int[]{i,map.get(temp)};
            }
        }
        throw new IllegalArgumentException("not exist");
    }
}




