package com.leetcode.solution.zuo;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 搜索树后序遍历还原
 *
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2020/12/5
 * @since 1.0
 */
public class BSTLRD {

    public Tree treeifyByLRD(int[] lrd) {
        return lrd == null ? null : treeify(lrd, 0, lrd.length - 1);
    }

    /**
     *      5
     *  3       7
     * 2  4   6  8
     *
     * 2,4,3,6,8,7,5
     *
     * @param lrd
     * @param l
     * @param r
     * @return Tree
     */
    public Tree treeify(int[] lrd, int l, int r) {
        if (l > r) {
            return null;
        }
        // 最右边永远都是头节点
        Tree head = new Tree(lrd[r]);
        if(l == r){
            return head;
        }
        // 为什么 M = l - 1;
        // 只有 > 如果 M = L 那么 setL(lrd, l, m == l) 死循环
        // 只有 < M 肯定会更新为 i 没问题
        // 既有 > 又有 < 肯定会更新为 i 没问题
        int M = l - 1;
        for (int i = l; i < r; i++) {
            if(lrd[i] < head.getData()){
                M = i;
            }else {
                break;
            }
        }
        head.setL(treeify(lrd, l, M));
        head.setR(treeify(lrd, M + 1, r - 1));
        return head;

    }

    public static void main(String[] args) {
        int[] lrd = new int[]{2,4,3,6,8,7,5};
        Tree tree = new BSTLRD().treeifyByLRD(lrd);
        System.out.println(tree);
    }

    public class Tree {

        int data;

        private Tree l;

        private Tree r;

        public Tree(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Tree getL() {
            return l;
        }

        public void setL(Tree l) {
            this.l = l;
        }

        public Tree getR() {
            return r;
        }

        public void setR(Tree r) {
            this.r = r;
        }
    }
}
