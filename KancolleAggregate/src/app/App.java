package app;

import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        int[] resource=new int[4];
        int[] nowResource=new int[4];
        int coin=0;
        int nowCoin=0;
        int item=0;
        int normalCount=0;
        int specialCount=0;
        ArrayList<String> equipment = new ArrayList<String>();

        Arrays.fill(resource,0);
        Arrays.fill(nowResource,0);
        String[] guns=readCSV("Guns.csv");
        String[] aircraft=readCSV("Aircraft.csv");
        String[] special=readCSV("Special.csv");
        System.out.println(Arrays.asList(guns));
        System.out.println(Arrays.asList(aircraft));
        System.out.println(Arrays.asList(special));
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