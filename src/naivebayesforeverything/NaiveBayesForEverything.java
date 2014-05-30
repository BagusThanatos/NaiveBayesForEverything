/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package naivebayesforeverything;

/**
 *
 * @author BagusThanatos
 */
public class NaiveBayesForEverything {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainSet a = new MainSet("coba");
        a.addElement("a");
        ((Groups)a.getGroups().get(0)).addElement("1");
        System.out.println(((Groups)a.getGroups().get(0)).contains("2"));
        System.out.println(a.getGroups().contains("b"));
        DataSets d = ParseFromCSV.ParseFromCSV("a.csv");
        for (Object m : d.getMainSets()){
            MainSet M = (MainSet) m;
            System.out.println(M.getName());
            for (Object o :M.getGroups()){
                Groups g = (Groups) o;
                System.out.println(g.getName());
                for (Object O: g.getElements()){
                    Element e = (Element) O;
                    System.out.print(e.getName()+"="+e.getJumlah()+",");
                    
                }
                System.out.println();
            }
        }
        System.out.println(d.getTotal("x", "x1")+"");
    }
    
}
