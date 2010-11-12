package gui;

import javax.swing.JWindow;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class Splash_Screen extends JWindow
{
//Get transparent image that will be use as splash screen image.
Image bi=Toolkit.getDefaultToolkit().getImage("C:/Users/Felipe/Desktop/batman.png");

ImageIcon ii=new ImageIcon(bi);

public Splash_Screen()
{
try
{
setSize(ii.getIconWidth(),ii.getIconHeight());
setLocationRelativeTo(null);
show();
Thread.sleep(10000);
dispose();
JOptionPane.showMessageDialog(null,"This program will exit !!!","<>",JOptionPane.INFORMATION_MESSAGE);
}
catch(Exception exception)
{
exception.printStackTrace();
}
}

//Paint transparent image onto JWindow
public void paint(Graphics g)
{
g.drawImage(bi,0,0,this);
}

public static void main(String[]args)
{
Splash_Screen tss=new Splash_Screen();
}
}
