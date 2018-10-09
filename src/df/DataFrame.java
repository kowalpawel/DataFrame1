package df;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Object;


public class DataFrame {
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> type = new ArrayList<>();
    ArrayList<Kolumna> cols = new ArrayList<>();

    public DataFrame(String[] names, String[] types) {
        for (int i = 0; i < names.length; i++) {
            name.add(names[i]);
        }
        for (int i = 0; i < types.length; i++) {
            type.add(types[i]);
        }
    }

    public DataFrame(){

    }

    public void add(Kolumna col){
        this.cols.add(col);
    }

    /*public int size(){

    }*/

    public DataFrame get(String colname){
        for(int i=0; i<this.name.size(); i++){
            if(colname == name.get(i)){
                DataFrame tmpdf = new DataFrame(new String[]{colname}, new String[]{this.type.get(i)});
                tmpdf.cols.add(this.cols.get(i));
            }

        }
        return tmpdf;
    }

    public DataFrame get(String [] cols, boolean copy){
        ArrayList<Integer> ind = new ArrayList<>();
        for(int i=0; i<cols.length; i++){
            if(this.name.contains(cols[i])){
                ind.add(i);
            }
        }
        String[] typeList = new String[ind.size()];
        for(int i=0; i<ind.size(); i++){
            typeList[i]=this.type.get(ind.get(i));
        }
        DataFrame tmpdf = new DataFrame(cols, typeList);
        for (int i=0; i<tmpdf.name.size(); i++){
            tmpdf.cols.add(this.cols.get(ind.get(i)));
        }
        return tmpdf;
    }

    public DataFrame iloc(int i){
        DataFrame tmpdf = new DataFrame();
        for (int j=0; j<this.name.size(); j++){
            tmpdf.name.add(this.name.get(j));
            tmpdf.type.add(this.type.get(j));
        }
        Kolumna tmp = new Kolumna();
        for (int j=0; j<this.name.size(); j++) {
            tmp.kol.add(this.cols.get(j).kol.get(i));
        }
        return tmpdf;
    }

    public DataFrame iloc(int from, int to){
        DataFrame tmpdf = new DataFrame();
        for (int j=0; j<this.name.size(); j++){
            tmpdf.name.add(this.name.get(j));
            tmpdf.type.add(this.type.get(j));
        }
        Kolumna tmp = new Kolumna();
        for (int j=0; j<this.name.size(); j++) {
            for (int n=from; n<to; n++) {
                tmp.kol.add(this.cols.get(j).kol.get(n));
            }
        }
        return tmpdf;
    }

    public void printDF(){
        for(int i=0; i<this.name.size(); i++){
            System.out.println(this.name.get(i) + " " + this.type.get(i));
            for(int j=0; j<this.cols.get(i).kol.size(); j++){
                System.out.print(this.cols.get(i).kol.get(j) + " ");
            }
        }
    }

}