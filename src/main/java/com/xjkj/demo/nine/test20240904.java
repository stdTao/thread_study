package com.xjkj.demo.nine;

import java.util.Arrays;

/**
 * @author tqq
 * @date 2024-09-04 15:40:44
 */
public class test20240904 {
    // 左闭右闭
    public static void test() {
        int[] arr = {-1,0,3,5,9,12};
        int left = 0;
        int target = 9;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] == target){
                System.out.println(mid);
                return;
            }else if (arr[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
    }
    // 左闭右开
    public static void test2(){
        int[] arr = {-1,0,3,5,9,12};
        int left = 0;
        int target = 9;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == target) {
                System.out.println(mid);
                return;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else { // nums[mid] > target
                right = mid;
            }
        }
    }

    //双指针
    public static void twoSum() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int val = 3;
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(slowIndex);
    }

    // 贪心算法 局部最优从而到达总体最优
    public static void findContentChildren() {
        int[] g = {1,2};
        int[] s = {1,2,3};
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0;
        int count = 0;
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (s[i] >= g[start]) {
                start++;
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        test();
        test2();
        twoSum();
        findContentChildren();
    }
}
