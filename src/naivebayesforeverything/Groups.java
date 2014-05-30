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
public class Groups implements Serializable{
    private String name;
    private Lists elements;
    
    public Groups(String n){
        this.name=n;
        elements= new Lists();
    }
    public void addElement(String n){
        this.elements.add(new Element(n));
    }
    public Element getElementAt(int index){
        return (Element)this.elements.get(index);
    }
    public void incElement(String n){
        for (int i=0; i< elements.size();i++ ){
            if (elements.get(i).equals(n)) ((Element)elements.get(i)).add(1);
        }
    }
    public boolean contains(String n){
        return elements.contains(n);
    }
    public Lists getElements(){
        return this.elements;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public boolean equals(Object o){
        return this.name.equals(o);
    }

    
}
