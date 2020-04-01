package app;

import java.util.*;
import java.awt.datatransfer.*;
import java.awt.*;

class ResourceRead{
    private int[] resource=new int[5];//燃料/弾薬/鋼材/ボーキ/家具コインの順番の配列
    private int[] nowResource=new int[5];
    private ArrayList<Integer> free = new ArrayList<Integer>();
    private int emotion;
    private int item;
    private int normalCount;
    private int specialCount;
    private ArrayList<String> equipment = new ArrayList<String>();
    ResourceRead(int[] resource,int[] nowResource,ArrayList<Integer> free,int emotion,int item,int normalCount,int specialCount,ArrayList<String> equipment){
        this.resource=resource;
        this.nowResource=nowResource;
        this.free=free;
        this.emotion=emotion;
        this.item=item;
        this.normalCount=normalCount;
        this.specialCount=specialCount;
        this.equipment=equipment;
    }
    public void resourceInit(){
        Scanner scanner=new Scanner(System.in);
        start:while(true){
            System.out.println("燃料/弾薬/鋼材/ボーキ/家具コインのような形で現在の鎮守府資材を入力してください");
            String inputResource=scanner.next();
            try{
                String[] inputLine=inputResource.split("/");
                if(inputLine.length!=5){
                    System.out.println("入力された値が違います");
                    continue start;
                }
                for(int i=0;i<nowResource.length;i++){
                    nowResource[i]=Integer.parseInt(inputLine[i]);
                }

            }catch (Exception e) {
                System.out.println("入力された値が違います");
                e.printStackTrace();
                continue start;
            }
            break;
        }
    }

    public void setEmotion(int emotion){
        this.emotion=emotion;
    }

    public void setItem(int item){
        this.item=item;
    }

    public void setNormalCount(int normalCount){
        this.normalCount=normalCount;
    }

    public void setSpecialCount(int specialCount){
        this.specialCount=specialCount;
    }

    public void setCoin(int coin,int nowCoin){
        this.resource[4]=coin;
        this.nowResource[4]=nowCoin;
    }

    public void addResource(int num){
        Scanner scanner=new Scanner(System.in);
        System.out.println("出た量を入力してEnter");
        int addResource=scanner.nextInt();
        resource[num-1]+=addResource;
        nowResource[num-1]+=addResource;
    }

    public void all3Resource(){
        for(int i=0;i<4;i++){
            resource[i]+=3;
            nowResource[i]+=3;
        }
    }

    public void addFree(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("出た量を入力してEnter");
        int addFree=scanner.nextInt();
        free.add(addFree);
    }

    public void developmentTable(String[] table){
        Scanner scanner=new Scanner(System.in);
        System.out.println("開発表の出目は？");
        int developmentNum=scanner.nextInt();
        switch(table.length){
            case 21:
                equipment.add(table[developmentNum-4]);
                System.out.println(table[developmentNum-4]+"が追加されました");
                break;
            case 11:
                equipment.add(table[developmentNum-2]);
                System.out.println(table[developmentNum-2]+"が追加されました");
                break;
        }
    }

    public void printResource(){
        System.out.println("獲得した資材:"+resource[0]+"/"+resource[1]+"/"+resource[2]+"/"+resource[3]+" 任意:"+Arrays.asList(free)+" 感情:"+emotion+" 家具コイン:"+resource[4]);
        System.out.println("現在資材:"+nowResource[0]+"/"+nowResource[1]+"/"+nowResource[2]+"/"+nowResource[3]+" コイン:"+nowResource[4]);
        System.out.println("アイテム:"+item);
        System.out.println("出た装備:"+Arrays.asList(equipment));
        System.out.println("通常:"+normalCount+"回 特殊:"+specialCount+"回");
    }

    public void copyToClipboard(){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection("獲得した資材:"+resource[0]+"/"+resource[1]+"/"+resource[2]+"/"+resource[3]+" 任意:"+Arrays.asList(free)+" 感情:"+emotion+" 家具コイン:"+resource[4]+"\n現在資材:"+nowResource[0]+"/"+nowResource[1]+"/"+nowResource[2]+"/"+nowResource[3]+" コイン:"+nowResource[4]+"\nアイテム:"+item+"\n出た装備:"+Arrays.asList(equipment)+"\n通常:"+normalCount+"回 特殊:"+specialCount+"回");
        clipboard.setContents(selection, selection);
        System.out.println("クリップボードにコピーしました");
    }
}