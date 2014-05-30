/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package naivebayesforeverything;

import java.io.Serializable;



/**
 *
 * @author BagusThanatos
 */
public class MainSet implements Serializable{
    private Lists groups;
    private String name;
    public MainSet(String n){
        this.name=n;
        this.groups= new Lists();
    }
    public void addElement(String n){
        this.groups.add(new Groups(n));
    }
    public Groups getGroupAt(int index){
        return (Groups)this.groups.get(index);
    }
    public boolean contains(String n){
        return groups.contains(n);
    }
    public Lists getGroups(){
        return this.groups;
    }
    public String getName(){
        return this.name;
    }
    public int getTotal(){
        int i=0;
        for (Object G : getGroups()){
            Groups g= (Groups) G;
            for (Object E: g.getElements()){  
                Element e= (Element) E;
                i+=e.getJumlah();
            }
        }
        return i;
    }
    @Override
    public boolean equals(Object e){
        return this.name.equals(e);
    }
}
