/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package naivebayesforeverything;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author BagusThanatos
 */
public class ParseFromCSV {
    public static DataSets ParseFromCSV(FileReader f){
        BufferedReader br= null;
        ArrayList<String> lines;
        try {
            br = new BufferedReader(f);
            lines= new ArrayList<>();
            String n = br.readLine();
            while (n!=null){
                lines.add(n);
                n= br.readLine();
            }
            int size=0;
            DataSets d= new DataSets();
            ArrayList<String> l =new ArrayList<>();
            for ( int i =0; i<lines.size();i++){
                n= lines.get(i);
                if (i==0){
                    String a="";
                    while (!"".equals(n)){
                        if (n.contains(",")) {
                            a=n.substring(0,n.indexOf(","));
                            n=n.substring(n.indexOf(",")+1);
                        }
                        else {
                            a=n;
                            n="";
                        }
                        d.addColumn(a);
                        size+=1;
                    }
                    
                }
                else {
                    while (!n.equals("")) {
                        if (n.contains(",")){
                            l.add(n.substring(0,n.indexOf(",")));
                            n=n.substring(n.indexOf(",")+1);
                        }
                        else {
                            l.add(n);
                            n="";
                        }
                    }
                    if (l.size()<size) {
                        JOptionPane.showMessageDialog(null, "Terjadi error: Ada data yang kurang");
                        return null;
                    }
                    else {
                        if (!d.getMainSets().contains(l.get(l.size()-1))) {
                            d.addMainSet(l.get(l.size()-1));
                        }
                        Lists M = d.getMainSets();
                        
                        MainSet m = (MainSet)M.get(M.indexOf(l.get(l.size()-1)));
                        for (int j=0;j<l.size()-1;j++){
                            Groups g=m.getGroupAt(j);
                            if (!g.contains(l.get(j))) g.addElement(l.get(j));
                            ((Element)g.getElements().get(g.getElements().indexOf(l.get(j)))).add(1);
                        }
                    }
                    l.clear();
                }
            }
            return d;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ParseFromCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ParseFromCSV.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ParseFromCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    public static DataSets ParseFromCSV(String path){
        try {
            return ParseFromCSV(new FileReader(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ParseFromCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
