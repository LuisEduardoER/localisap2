/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import util.WebUtils;

/**
 *
 * @author Felipe
 */
public class Leecher{
    
    private JTextArea resultList;
    private Site site;
    private volatile Integer position=1;
    private int threads;
    private List<Worker> threadList = new ArrayList<Worker>();
    private boolean stop = false;
    private JProgressBar pb;
    private JLabel statusLabel;
    private JLabel numberLeecher;
    private JSlider js;
    private int timeout;
    private JButton startButton;
    private JButton stopButton;
    private boolean login;
    
    //
    
    public Leecher(JTextArea resultList, Site site, int threads,JProgressBar pb, JLabel statusLabel,JLabel numberLeeched,JSlider js, int timeout, JButton startButton, JButton stopButton) {
        this.resultList = resultList;
        this.site = site;
        this.threads = threads;
        this.pb = pb;
        this.statusLabel = statusLabel;
        this.numberLeecher = numberLeeched;
        this.js = js;
        this.timeout = timeout;
        this.startButton = startButton;
        this.stopButton = stopButton;
        position = site.getFirstPage();
    }
    
    public void runLeecher(){
        stop = false;
        pb.setMinimum(1);
        pb.setMaximum(site.getPages());
        resultList.setText("");
        statusLabel.setText("- - Leeching "+site.getName()+" - -");
        pb.setStringPainted(true);
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        new LoginThreadB().start();
    }
    
    public void stopLeecher(){
        stop = true;
        new Worker2().start();
    }
    
    public void addLeeched(String leeched){
        synchronized(resultList){
            resultList.append(leeched+"\n");
            numberLeecher.setText(resultList.getLineCount()+"");
        }
    }
    
    public void processPage(String pageC){
        String aux = "";
        while(pageC.contains(site.getFistParseA())){
            if (site.getParseType().equals(Site.Parse.SINGLE)){
                pageC = pageC.substring(pageC.indexOf(site.getFistParseA())+site.getFistParseA().length());
                if(pageC.contains(site.getFistParseB())){
                    aux = pageC.substring(0, pageC.indexOf(site.getFistParseB()));
                    addLeeched(aux);
                }
            }
            else{
                pageC = pageC.substring(pageC.indexOf(site.getFistParseA())+site.getFistParseA().length());
                if(pageC.contains(site.getFistParseB())){
                    aux = pageC.substring(0, pageC.indexOf(site.getFistParseB()));
                    if(aux.contains(site.getSecoundParseA()) && aux.contains(site.getSecoundParseB()))
                        aux = aux.substring(aux.indexOf(site.getSecoundParseA())+site.getSecoundParseA().length(), aux.indexOf(site.getSecoundParseB()));
                    addLeeched(aux);
                }
            }
        }
    }
    
    public class LoginThreadB extends Thread{
        @Override
        public void run() {
           if (site.isLogin()){
               LoginThread lt = new LoginThread();
               lt.start();
                   try{
                       synchronized(lt){
                           lt.wait();
                       }
                   }catch(Exception e){
                       JOptionPane.showMessageDialog(null, "Fail to login!");
                   }
           }
           
           if((site.isLogin() && statusLabel.getText().equals("- - Login OK! - -")) || !site.isLogin()){  
               statusLabel.setText("- - Leeching "+site.getName()+" - -");
               for(int i = 0 ; i < threads ; i++){
                   threadList.add(new Worker(i));
               }
               for(Worker w : threadList)
                   w.start();
           }else{
               stopLeecher();
           }
        }
        
    }
    
    public class LoginThread extends Thread{

        private WebUtils web = new WebUtils(timeout);
        
        @Override
        public void run() {
            pb.setIndeterminate(true);
            statusLabel.setText("- - Login stage... - -");
            try {
                if(web.login(site.getLoginPostURL(), site.getLoginPostData().replace("[user]", site.getLoginUser()).replace("[pass]", site.getLoginPass()), site.getLoginSuccess())){
                    statusLabel.setText("- - Login OK! - -");
                    pb.setIndeterminate(false);
                }
                else
                {
                    pb.setIndeterminate(false);
                    statusLabel.setText("- - Login Fail! - -");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Fail to login!");
                
            }
        }
        
        
    }
 
    public class Worker2 extends Thread{
        
        private int threadNumber(){
            int result = 0;
            for(Worker w : threadList)
                if(w.isAlive())
                    result++;
            return result;
        }
        
        @Override
        public void run() {
            while(true){
                try {
                    sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Leecher.class.getName()).log(Level.SEVERE, null, ex);
                }
                int number = threadNumber();
                if(number == 0)
                    break;
                statusLabel.setText("- - Waiting for "+number+" threads to stop - -");
            }
            statusLabel.setText("- - Job finished! - -");
            js.setEnabled(true);
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
        }
        
    }
    
    public class Worker extends Thread{
        
        private int id;
        private WebUtils web = new WebUtils(timeout);
        
        public Worker(int id) {
            this.id = id;
        }
       
       @Override
       public void run() {
           String url="";
           while(!stop){                   
               synchronized(position){
                   url = site.getHost()+site.getGetString().replace("[inc]", position+++"");
                   if(!url.contains("http://"))
                       url="http://"+url;
                   if(position > site.getPages()){
                       if(!stop){
                           stopLeecher();
                       }
                       break;
                   }
               }
               while(position <= site.getPages()){
                   try{
                       processPage(web.downloadPage(url));
                       pb.setValue(position);
                       pb.setString("Page "+position+" of "+site.getPages());
                       break;
                   }catch(Exception e){
                       System.out.println(e.getMessage());
                       continue;
                   }
               }
           }
           stopLeecher();
       }
    }
    
}
