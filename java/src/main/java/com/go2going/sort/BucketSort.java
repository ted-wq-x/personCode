package com.go2going.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  BucketSort<br>
 * 描述：桶排序
 *
 * @author wangqiang
 * 创建时间：  2017/11/14 0014 14:28
 */
public class BucketSort {

    /**
     * @param a 待排序数组元素
     * @param step 步长(桶的宽度/区间),具体长度可根据情况设定
     * @return 桶的位置/索引
     */
    private int indexFor(int a,int step){
        return a/step;
    }

    public void bucketSort(int []arr){

        int max=arr[0],min=arr[0];
        for (int a:arr) {
            if (max<a)
                max=a;
            if (min>a)
                min=a;
        }
        //该值也可根据实际情况选择
        int bucketNum=max/10-min/10+1;

        List<List<Integer>> buckList= new ArrayList<>();

        //create bucket
        for (int i=1;i<=bucketNum;i++){
            buckList.add(new ArrayList<>());
        }

        //push into the bucket
        for (int i=0;i<arr.length;i++){
            //将元素放到不同的桶当中
            int index=indexFor(arr[i],10);
            buckList.get(index).add(arr[i]);
        }

        ArrayList<Integer> bucket;
        int index=0;
        for (int i=0;i<bucketNum;i++){
            bucket=(ArrayList<Integer>)buckList.get(i);
            //对每个桶中的元素进行排序
            insertSort(bucket);

            //还原数组
            for (int k : bucket) {
                arr[index++]=k;
            }
        }

    }
    //把桶内元素插入排序
    private void insertSort(List<Integer> bucket){
        for (int i=1;i<bucket.size();i++){
            int temp=bucket.get(i);
            int j=i-1;
            for (; j>=0 && bucket.get(j)>temp;j--){
                bucket.set(j+1,bucket.get(j));
            }
            bucket.set(j+1,temp);
        }
    }
}
