/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package naivebayesforeverything;

import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author BagusThanatos
 */
public class DataSets implements Serializable{
    private Lists main;
    private ArrayList<String> columns;
    public DataSets(){
        this.main=new Lists();
        this.columns= new ArrayList();
    }
    public void addMainSet(String n){
        MainSet m=new MainSet(n);
        
        for (String c : columns){
            m.addElement(c);
        }
        this.main.add(m);
    }
    public void addColumn(String n){
        this.columns.add(n);
    }
    public String getColumnAt(int i){
        return columns.get(i);
    }
    public int getColumnSize(){
        return columns.size();
    }
    public Lists getMainSets(){
        return this.main;
    }
    public ArrayList<String> getAllColumns(){
        return this.columns;
    }
    public int getTotal(String a,String gr){
        int i=0;
        for (Object O: getMainSets()){
            MainSet M = (MainSet) O;
            for (Object G : M.getGroups()){
                Groups g= (Groups) G;
                for (Object E: g.getElements()){
                     Element e = (Element) E;
                     if (e.equals(a) && g.equals(gr)) i+=e.getJumlah();
                }
            }
        }
        
        return i;
    }
    public int getTotalMain(){
        int i=0;
        for (Object M: getMainSets()){
            i+=((MainSet)M).getTotal();
        }
        
        return i;
    }
}
