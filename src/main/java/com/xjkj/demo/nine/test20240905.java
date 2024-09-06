package com.xjkj.demo.nine;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author tqq
 * @date 2024-09-05 09:46:05
 */
public class test20240905 {

    // 摆动序列
    public static void test(int[] arr) {
        if(arr.length<=1){
            System.out.println(arr.length);
        }
        // 当前差值
        int curDiff = 0;
        // 上一个差值
        int perDiff = 0;
        int count = 1;
        for(int i=1;i<arr.length;i++){
            curDiff = arr[i]-arr[i-1];
            if((curDiff>0&&perDiff<=0)||(curDiff<0&&perDiff>=0)){
                count++;
                perDiff = curDiff;
            }
        }
        System.out.println(count);
    }

    //最大子序和
    public static void test1(int[] arr){
        int sum = Integer.MIN_VALUE;
        int count = 0;
        if(arr.length<=1){
            System.out.println(arr[0]);
        }
        for (int j : arr) {
            count += j;
            sum = Math.max(sum, count);
            if (count <= 0) {
                count = 0;
            }
        }
        System.out.println(sum);
    }

    // 买股票的最佳时机
    public static void test2(int[] arr){
        if(arr.length<=1){
            System.out.println(0);
        }
        int curMin = 0;
        int sum = 0;
        for (int i = 1; i < arr.length; i++){
            curMin = arr[i]-arr[i-1];
            if(curMin>0){
                sum+=curMin;
            }
        }
        System.out.println(sum);
    }

    // 单调栈
    // 每日温度
    public static void test3(int[] arr){
        int length = arr.length;
        int []res = new int[length];
        /*
         如果当前遍历的元素 大于栈顶元素，表示 栈顶元素的 右边的最大的元素就是 当前遍历的元素，
         所以弹出 栈顶元素，并记录
         如果栈不空的话，还要考虑新的栈顶与当前元素的大小关系
         否则的话，可以直接入栈。
         注意，单调栈里 加入的元素是 下标。
         */
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < length; i++){
            if(arr[i]<=arr[stack.peek()]){
                stack.push(i);
            }else{
                while(!stack.isEmpty()&&arr[i]>arr[stack.peek()]){
                    res[stack.peek()]=i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }


    }

    public static void main(String[] args) {
        int[] a={1,7,4,9,2,5};
        int[] b={1,17,5,10,13,15,10,5,16,8};
        int[] c={1,2,3,4,5,6,7,8,9};
        int[] d={-2,1,-3,4,-1,2,1,-5,4};
        int[] e={-1,-1,-1};
        int[] f={7,1,5,3,6,4};
        int[] g={1,2,3,4,5};
        int[] h={7,6,4,3,1};
        test(a);
        test(b);
        test(c);
        System.out.println("=======================");
        test1(d);
        test1(e);
        System.out.println("=======================");
        test2(f);
        test2(g);
        test2(h);
    }
}
