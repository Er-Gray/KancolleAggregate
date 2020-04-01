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
        int emotion=0;
        ArrayList<String> equipment = new ArrayList<String>();
        ResourceRead resourceRead= new ResourceRead(resource,nowResource,free,emotion,item,normalCount,specialCount,equipment);

        Arrays.fill(resource,0);
        Arrays.fill(nowResource,0);
        String[] guns=readCSV("Guns.csv");
        String[] aircraft=readCSV("Aircraft.csv");
        String[] special=readCSV("Special.csv");
        resourceRead.resourceInit();
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("出た資材に応じて値を入力してEnter");
            System.out.println("資材の確認:0\n燃料追加:1\n弾薬追加:2\n鋼材追加:3\nボーキ追加:4\n任意追加:5\n感情追加:6\n特殊戦果表:7\n任意資材の振り分け:8\n結果をクリップボードにコピー:9");
            try{
                int num=scanner.nextInt();
                switch(num){
                    case 0:
                        resourceRead.printResource();
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        resourceRead.addResource(num);
                        resourceRead.setNormalCount(++normalCount);
                        break;
                    case 5:
                        resourceRead.addFree();
                        resourceRead.setNormalCount(++normalCount);
                        break;
                    case 6:
                        resourceRead.setEmotion(++emotion);
                        resourceRead.setNormalCount(++normalCount);
                        break;
                    case 7:
                        System.out.println("特殊戦果表\nすべての資材+3:1\nアイテム:2\n家具コイン:3\n砲類開発表:4\n艦載機開発表:5\n新特殊開発表:6");
                        int spNum=scanner.nextInt();
                        switch(spNum){
                            case 1:
                                resourceRead.all3Resource();
                                resourceRead.setSpecialCount(++specialCount);
                                break;
                            case 2:
                                resourceRead.setItem(++item);
                                resourceRead.setSpecialCount(++specialCount);
                                break;
                            case 3:
                                resourceRead.setCoin(++resource[4],++nowResource[4]);
                                resourceRead.setSpecialCount(++specialCount);
                                break;
                            case 4:
                                resourceRead.developmentTable(guns);
                                resourceRead.setSpecialCount(++specialCount);
                                break;
                            case 5:
                                resourceRead.developmentTable(aircraft);
                                resourceRead.setSpecialCount(++specialCount);
                                break;
                            case 6:
                                resourceRead.developmentTable(special);
                                resourceRead.setSpecialCount(++specialCount);
                                break;
                            default:
                                System.out.println("入力された値が違います");
                        }
                        break;
                    case 8:
                        resourceRead.sortingFree();
                        break;
                    case 9:
                        resourceRead.copyToClipboard();
                        break;
                    default:
                        System.out.println("入力された値が違います");
                }
            }catch(Exception e){
                System.out.println("入力された値が違います");
                e.printStackTrace();
            }
        }
    }

    public static String[] readCSV(String fileName){
        FileInputStream fi = null;
        InputStreamReader is = null;
        BufferedReader br = null;
        try{
            fi = new FileInputStream(fileName);
            is = new InputStreamReader(fi,"UTF-8");
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