package hordinhaPackage;

import java.util.*;

public class Horda {
    private final Map<String, List<Monster>> grups = new LinkedHashMap<>();

    public void addGrup (String baseName, int count, int ca, int hpMax){
        List<Monster> mosnters = new ArrayList<Monster>();

        for(int i = 0; i < count; i++){
            Monster m = new Monster(baseName + " " + i,ca,hpMax);
            mosnters.add(m);
        }

        grups.put(baseName,mosnters);
    }

    public void showGrups (){
        System.out.println("--Grupos------------");
        for(String name: grups.keySet()){
            System.out.println("--" + name + "------------");
            for(int i = 0; i < grups.get(name).size(); i++){
                System.out.println(grups.get(name).get(i).toString());
            }
            System.out.println("--------------");
        }
    }

    public void showGrup (String baseName){
        System.out.println("--"+ baseName + "------------");
        for(int i = 0; i < grups.get(baseName).size(); i++){
            System.out.println(grups.get(baseName).get(i).toString());
        }
        System.out.println("--------------");
    }

    public void removeGrup (String baseName){
        grups.remove(baseName);
    }

    public void removeInGrup (String baseName, int index){
        grups.get(baseName).remove(index);
    }

    public void addInGrup (String baseName){
        grups.get(baseName).add(new Monster(
                baseName + grups.get(baseName).size(),
                grups.get(baseName).getFirst().getCa(),
                grups.get(baseName).getFirst().getHpMax()));
    }

    public void editNameGrup (String baseName, String newName){
        List<Monster> m = grups.get(baseName);

        for(int i = 0; i < m.size(); i++){
            m.get(i).setName(newName + " " + i);
        }
        grups.put(newName,m);
        grups.remove(baseName);
    }

    public void editHpMaxGrup (String baseName,int vaule){
        for(int i = 0; i < grups.get(baseName).size(); i++){
            grups.get(baseName).get(i).setHpMax(vaule);
        }
    }

    public void editCaMaxGrup (String baseName,int vaule){
        for(int i = 0; i < grups.get(baseName).size(); i++){
            grups.get(baseName).get(i).setCa(vaule);
        }
    }

    public void modfyHpInGrup (String baseName, int index, int vaule) {
        grups.get(baseName).get(index).setHp(vaule);
    }

    public void addHpBonusInGrup (String baseName, int index, int vaule) {
        grups.get(baseName).get(index).setHpBonus(vaule);
    }
}
