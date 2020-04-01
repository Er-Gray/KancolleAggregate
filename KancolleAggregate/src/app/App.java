package app;

import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        int[] resource=new int[5];//燃料/弾薬/鋼材/ボーキ/家具コインの順番の配列
        int[] nowResource=new int[5];
        ArrayList<Integer> free = new ArrayList<Integer>();
        int item=0;
        int normalCount=0;
        int specialCount=0;
        ArrayList<String> equipment = new ArrayList<String>();
        ResourceRead resourceRead= new ResourceRead(resource,nowResource,free,item,normalCount,specialCount,equipment);

        Arrays.fill(resource,0);
        Arrays.fill(nowResource,0);
        String[] guns=readCSV("Guns.csv");
        String[] aircraft=readCSV("Aircraft.csv");
        String[] special=readCSV("Special.csv");
        resourceRead.resourceInit();
        while(true){
            System.out.println("出た資材に応じて値を入力してEnter");
            System.out.println("資材の確認:0\n燃料追加:1\n弾薬追加:2\n鋼材追加:3\nボーキ追加:4\n任意追加:5\n感情追加:6\n特殊戦果表:7");
        }
    }

    public static String[] readCSV(String fileName){
        FileInputStream fi = null;
        InputStreamReader is = null;
        BufferedReader br = null;
        try{
            fi = new FileInputStream(fileName);
            is = new InputStreamReader(fi);
            br = new BufferedReader(is);

            String line = br.readLine();//読み込み行

            String[] list = line.split(",");
            br.close();
            return list;
        }catch (Exception e) {
            e.printStackTrace();
            
        }
        return null;

    }
}