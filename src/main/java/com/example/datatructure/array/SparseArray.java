package com.example.datatructure.array;


/**
 * 稀疏数组
 *
 * 表示棋盘
 */
public class SparseArray {
    public static void main(String[] args) {
        int oldArr[][] = new int[11][11];

        oldArr[1][2] = 1;
        oldArr[2][3] = 2;
        oldArr[4][5] = 2;


        System.out.println("输出二维数组.....");
        for (int[] ints : oldArr) {
            for (int anInt : ints) {
                System.out.print(anInt +"\t");
            }
            System.out.println();
        }

        //记录二维数组不为0的个数
        int sum=0;
        for (int[] ints : oldArr) {
            for (int anInt : ints) {
               if (anInt!=0){
                   sum++;
               }
            }
        }

        //定义稀疏数组
        int newArr[][] = new int[sum+1][3];
        newArr[0][0] = 11;
        newArr[0][1] = 11;
        newArr[0][2] = sum;

        int count=0;
        for (int i =0;i<11;i++){
            for (int j=0;j<11;j++){
                if (oldArr[i][j]!=0){
                    count++;
                    newArr[count][0] = i;
                    newArr[count][1] = j;
                    newArr[count][2] = oldArr[i][j];
                }
            }
        }

        System.out.println("输出稀疏数组.....");
        for (int i =0;i<sum+1;i++){
            for (int j=0;j<3;j++){
                System.out.print(newArr[i][j]+"\t");
            }
            System.out.println();
        }


        System.out.println("稀疏数组转成二维数组.....");

        int arr[][]= new int[newArr[0][0]][newArr[0][1]];

        for (int i=1;i< newArr.length;i++){
            arr[newArr[i][0]][newArr[i][1]] = newArr[i][2];
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt +"\t");
            }
            System.out.println();
        }

    }
}
