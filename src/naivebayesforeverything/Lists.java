/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package naivebayesforeverything;

import java.util.ArrayList;

/**
 *
 * @author BagusThanatos
 */
public class Lists extends ArrayList{
    
    public Lists(){
        super();
    }
    @Override 
    public int indexOf(Object o){
        int index=-1;
        Element e;
        Groups g;
        MainSet m;
        int i=0;
        while(i<size()){
            if (get(i) instanceof Element){
                e= (Element) get(i);
                if (e.equals(o)) {
                    index=i;
                    break;
                }
            }
            else if (get(i) instanceof Groups){
                g= (Groups) get(i);
                if (g.equals(o)) {
                    index=i;
                    break;
                }
            }
            else if (get(i) instanceof MainSet){
                m= (MainSet) get(i);
                if (m.equals(o)) {
                    index=i;
                    break;
                }
            }
            i++;
        }
        return index;
    }
    @Override
    public boolean contains(Object o){
        Element e;
        Groups g;
        MainSet m;
        boolean b=false;
        int i=0;
        while(!b && i<size()){
            if (get(i) instanceof Element){
                e= (Element) get(i);
                b= e.equals(o);
            }
            else if (get(i) instanceof Groups){
                g= (Groups) get(i);
                b= g.equals(o);
            }
            else if (get(i) instanceof MainSet){
                m= (MainSet) get(i);
                b= m.equals(o);
            }
            i++;
        }
        return b;
    }
}
