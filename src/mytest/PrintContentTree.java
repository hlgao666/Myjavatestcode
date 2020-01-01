package mytest;

import java.io.File;

public class PrintContentTree {

    public  static void main(String[] args){
        File file = new File("D:\\IJ2019WORKSPACE");
        Printfile(file,0);
    }

    public static void Printfile(File file,int level){

        for(int i=0;i<level;i++){
            System.out.print("-");
        }

        System.out.println(file.getName());

        if(file.isDirectory()){
            File[] files = file.listFiles();

            for(File temp:files){
                Printfile(temp,level+1);        //利用递归打印文件目录树
            }
        }
    }
}
