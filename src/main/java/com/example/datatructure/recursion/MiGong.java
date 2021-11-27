package com.example.datatructure.recursion;

public class MiGong {
    public static void main(String[] args) {
        //构建迷宫
        int map[][] = new int[8][7];
        for (int i=0;i<7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i=0;i<8;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1]=1;
        map[3][2]=1;

        setWay(map,1,1);

        for (int i=0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }


    /**
     * 递归找路，找到就返回true
     * 通路坐标标为2 ，不通标为3
     * 下右上左
     * @param map 迷宫
     * @param i 行
     * @param j 列
     * @return
     */
    public static boolean setWay(int[][] map,int i,int j){
        if (map[6][5]==2){
            return true;
        }else {
            if (map[i][j]==0){
                map[i][j] = 2;
                if (setWay(map,i+1,j)){
                    return true;
                }
                if (setWay(map,i,j+1)){
                    return true;
                }
                if (setWay(map,i-1,j)){
                    return true;
                }
                if (setWay(map,i,j-1)){
                    return true;
                }
                else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
