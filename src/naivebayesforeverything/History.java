/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package naivebayesforeverything;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BagusThanatos
 */
public class History implements Serializable{
    private final String path="history.hnb";
    ArrayList<String[]> his;
    public History(){
        his = new ArrayList<>();
    }
    public ArrayList<String[]> getHis(){
        return this.his;
        
    }
    public void read(){
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(path));
            Object a = o.readObject();
            if (a!=null) this.his = ((History)a).getHis();
            o.close();
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            Logger.getLogger(History.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(History.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void write(){
        try {
            ObjectOutputStream i = new ObjectOutputStream(new FileOutputStream(path));
            i.writeObject(this);
            i.flush();
            i.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(History.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(History.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void addHistory(String[] a){
        this.his.add(a);
    }
}
