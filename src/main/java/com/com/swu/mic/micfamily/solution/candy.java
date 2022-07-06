package com.com.swu.mic.micfamily.solution;

/**
 * @ 作者： 闫士博
 * @ 日期： 2022/7/5 星期二 21:23
 * @ package name： com.com.swu.mic.micfamily.solution
 * @ Project name： MicFamily
 * @ Description：
 */

//n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
//
//        你需要按照以下要求，给这些孩子分发糖果：
//
//        每个孩子至少分配到 1 个糖果。
//        相邻两个孩子评分更高的孩子会获得更多的糖果。
//        请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目

//    如果你们有n个人来唱歌，排成一排坐在KTV的沙发上
//            本系统可以自动生成KTV唱歌奖励的最小数
//            要求：相邻来唱歌的朋友获得到更多奖励，每个人至少有一个奖励
//
//    请输入每个人的唱歌得分：（自动获取）
//            您好，所需要的最少的奖励数为：


//常数空间遍历法
public class candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }

}
