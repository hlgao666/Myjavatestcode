package mytest;


import java.util.Arrays;

public class test {

    public static void main(String[] args){

        //1
        int[][] temp1 = new int[][]{
                {1, 2},
                {4, 5}
        };
        System.out.println(Arrays.toString(temp1[1]));


        //2
        Object[][] tableData;
        tableData = new Object[][]{
                {1,2,"at"},
                {8,9,"d"},
                {3,6,"e"}
        };
        System.out.println(Arrays.toString(tableData[0]));


        //3测试冒泡排序
        int[] values = {3,1,6,2,9,0,7,4,5,8};

        int temp;
        for(int i=0;i<values.length-1;i++){

            boolean flag = false;
            for(int j=0; j<values.length-1-i; j++){

                if(values[j]>values[j+1]){
                    temp = values[j];
                    values[j]= values[j+1];
                    values[j+1]= temp;
                    flag = true;
                }

            }

            if(!flag){
                break;
            }
        }
        System.out.println(Arrays.toString(values));


        //测试二分查找
        int[] temp3 = {7,8,9,10,12,30,40,50,80,100};
        int des= 80;
        int left = 0;
        int right = temp3.length-1;
        int center = 0;
        while(left<right){
            center = (left + right)/2;
            if(temp3[center]>des){
                right = center;

            }
            if(temp3[center]<des){
                left = center;
            }
            if(temp3[center] == des){
                break;
            }
        }
        System.out.println(center);


        //

    }
}
