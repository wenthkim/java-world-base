package com.wenthkim.leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 计算数组中两数之和
 * leetcode_1 两数之和
 * 给定nums = [2,7,11,15],target = 9
 * 因为nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0,1]
 */
public class TwoSumSimple_1 {

    public static void main(String[] args) {

        int[] nums = {2,7,11,15};
        int target = 9;
        
        System.out.println(twoSum2n(nums,target));

    }

    /**
     * 双重for循环
     * @param nums
     * @param target
     */
    public static String twoSum(int[] nums, int target) {
         if (nums == null || nums.length < 2) {
             return "数组至少包括两数";
         }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return "[" + i + "," + j + "]";
                }
            }
        }
        return "not found";
    }


    /**
     * 单循环，用map,空间换时间
     * @param nums
     * @param target
     * @return
     */
    public static String twoSumWithMap(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return "数组至少包括两数";
        }

        Map<String,Integer> maps = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int sub = target - value;
            String s = sub + "";
            if (maps.get(s) != null) {
                return "[" + maps.get(s) + "," + i + "]";
            }else {
                maps.put(value+"",i);
            }
        }
        return "not found";
    }

    /**
     *  2* n 复杂度
     * @param nums
     * @param target
     * @return
     */
    public static String twoSum2n(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return "数组至少包括两数";
        }

        Map<String,Integer> maps = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i] + "", i);
        }
        for (int i = 0; i < nums.length; i++) {

            int sub = target - nums[i];
            if (maps.get(sub + "") != null) {
                return "[" + i + "," + maps.get(sub + "") + "]";
            }
        }
        return "not found";
    }



}
