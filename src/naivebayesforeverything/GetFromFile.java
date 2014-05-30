/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package naivebayesforeverything;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author BagusThanatos
 */
public class GetFromFile {
    public static DataSets getFrom(String path){
        try {
            ObjectInputStream ob = new ObjectInputStream(new FileInputStream(path));
            DataSets d = (DataSets)ob.readObject();
            ob.close();
            return d;
        } catch (IOException ex) {
            Logger.getLogger(GetFromFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetFromFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
