/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import fjleecher.FJLeecherView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class Repository implements Serializable{

    private List<Site> siteList;
    private static Repository _instance;
    private FJLeecherView view;

    public Repository() {
        load();
        if(siteList == null){
            siteList = new ArrayList<Site>();
            persist();
        }
    }
    
    /**
     * @return the siteList
     */
    public List<Site> getSiteList() {
        return siteList;
    }

    /**
     * @param siteList the siteList to set
     */
    public void setSiteList(List<Site> siteList) {
        this.siteList = siteList;
    }
    
    public void addSite(Site site){
        this.siteList.add(site);
        persist();
        view.loadSites();
    }
    
    public void removeSite(Site site){
        this.siteList.remove(site);
        persist();
        view.loadSites();
    }

    /**
     * @return the _instance
     */
    public static Repository getInstance() {
        if(_instance == null)
            _instance = new Repository();
        return _instance;
    }
 
    private void load(){
        FileInputStream f_in;
        Object obj = null;
        try {
            f_in = new FileInputStream ("fjdata.fj");
            ObjectInputStream obj_in = new ObjectInputStream (f_in);
            obj = obj_in.readObject ();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex){
            JOptionPane.showMessageDialog(null,"Error");
        } catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Error");
        }
        this.siteList = (List<Site>)obj;
    }
    
    public final void persist(){
        FileOutputStream f_out;
        try {
            f_out = new FileOutputStream ("fjdata.fj");
            ObjectOutputStream obj_out = new ObjectOutputStream (f_out);
            obj_out.writeObject (this.siteList);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error");
        } catch (IOException ex){
            JOptionPane.showMessageDialog(null,"Error");
        }
    }

    /**
     * @param view the view to set
     */
    public void setView(FJLeecherView view) {
        this.view = view;
    }
    
}
