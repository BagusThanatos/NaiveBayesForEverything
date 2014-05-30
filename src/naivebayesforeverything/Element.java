/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package naivebayesforeverything;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author BagusThanatos
 */
public class Element implements Serializable{
    private String name;
    private int n;
    
    public Element(String name){
        this.name=name;
        this.n=0;
    }
    public void add(int i){
        this.n+=i;
    }
    public boolean equals(String n){
        return this.name.equals(n);
    }
    public String getName(){
        return this.name;
    }
    public int getJumlah(){
        return this.n;
    }
    @Override
    public boolean equals(Object e){
        return this.name.equals(e);
    }

    
}
