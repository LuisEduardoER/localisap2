/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import fjleecher.FJLeecherView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

/**
 *
 * @author Felipe
 */
public class WordListUtil {
    
    private JProgressBar pb;
    private JLabel statusLabel;
    private JTextArea resultArea;
    private JLabel numberWords;
    private String lineSeparator = System.getProperty("line.separator");
    
    public WordListUtil(JProgressBar pb, JLabel statusLabel, JTextArea resultArea, JLabel numberWords) {
        this.pb = pb;
        this.statusLabel = statusLabel;
        this.resultArea = resultArea;
        this.numberWords = numberWords;
    }
    
//    public void  removeDuplicates(){
//        HashSet h = new HashSet(arrayStrings);
//        arrayStrings.clear();
//        arrayStrings.addAll(h);
//    }
    
    public void doWork(boolean dups, boolean onlyNumbers, boolean lengthLessThan, boolean lengthGreaterThan, boolean contains, boolean notContains){
        new Worker(dups, onlyNumbers, lengthLessThan, lengthGreaterThan, contains, notContains).start();
    }
    
    public void loadFile(File file){
        pb.setIndeterminate(true);
        statusLabel.setText("..Loading file..");
        new LoadFile(file).start();
    }
    
    private class Worker extends Thread{
        
        private boolean dups = false;
        private boolean onlyNumbers = false;
        private boolean lengthLessThan = false;
        private boolean lengthGreaterThan = false;
        private boolean contains = false;
        private boolean notContains = false;

        public Worker(boolean dups, boolean onlyNumbers, boolean lengthLessThan, boolean lengthGreaterThan, boolean contains, boolean notContains) {
            this.contains = contains;
            this.dups = dups;
            this.onlyNumbers = onlyNumbers;
            this.lengthGreaterThan = lengthGreaterThan;
            this.notContains = notContains;
            this.lengthLessThan = lengthLessThan;
        }
        
        @Override
        public void run() {
            pb.setIndeterminate(true);
            if(this.dups){         
                statusLabel.setText("Removing dups..");
                ArrayList<String> arrayWords = new ArrayList<String>();
                StringReader sr = new StringReader(resultArea.getText()); 
                BufferedReader br = new BufferedReader(sr); 
                String nextLine = ""; 
                try {
                    while ((nextLine = br.readLine()) != null){ 
                        arrayWords.add(nextLine);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(WordListUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
                HashSet h = new HashSet(arrayWords);
                arrayWords.clear();
                arrayWords.addAll(h);
                StringBuilder b = new StringBuilder();
                for(String s : arrayWords)
                    b.append(s).append(lineSeparator);
                resultArea.setText(b.toString());
                resultArea.setText(resultArea.getText().substring(0, resultArea.getText().length()-lineSeparator.length()));
                numberWords.setText(resultArea.getLineCount()+"");
            }
            pb.setIndeterminate(false);
            statusLabel.setText("Work done!");
        }
        
    }
    
    private class LoadFile extends Thread{
        private File file;

        public LoadFile(File file) {
            this.file = file;
        }

        private void loadFileWorker() throws IOException{
            FileReader in = null;
            BufferedReader is = null;
            String result = "";
            String lineSeparator = System.getProperty("line.separator");
            try{
                in = new FileReader(file);
                is = new BufferedReader(in,1000000);
                StringBuilder lines = new StringBuilder();
                String line;
                while((line = is.readLine())!=null){
                    lines.append(line+lineSeparator);
                }
                if(!resultArea.getText().equals(""))
                    resultArea.setText(resultArea.getText()+lineSeparator);
                resultArea.setText(resultArea.getText()+lines.toString());
                //resultArea.setText(resultArea.getText().substring(0, resultArea.getText().length()-lineSeparator.length()));
                pb.setIndeterminate(false);
                statusLabel.setText("Done!");
                numberWords.setText(resultArea.getLineCount()+"");
            } catch (IOException ex) {
                throw new IOException(ex);
            } finally {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(FJLeecherView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        @Override
        public void run() {
            try {
                loadFileWorker();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Failed to load file!");
            }
        }
    }
}
