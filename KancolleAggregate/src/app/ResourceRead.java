package app;

import java.util.*;

class ResourceRead{
    private int[] resource=new int[5];//燃料/弾薬/鋼材/ボーキ/家具コインの順番の配列
    private int[] nowResource=new int[5];
    private ArrayList<Integer> free = new ArrayList<Integer>();
    private int item=0;
    private int normalCount=0;
    private int specialCount=0;
    private ArrayList<String> equipment = new ArrayList<String>();
    ResourceRead(int[] resource,int[] nowResource,ArrayList<Integer> free,int item,int normalCount,int specialCount,ArrayList<String> equipment){
        this.resource=resource;
        this.nowResource=nowResource;
        this.free=free;
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
}