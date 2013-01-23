package com.eatthatgame.examples;

/*
 * for full tutorial for this code go to:
 * http://docs.oracle.com/javase/tutorial/2d/images/loadimage.html
 * 
 * to test just this file, right click on the Projects panel in Netbeans
 * and select "Run File" from the options - or press Shift-F6
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class LoadImage extends Component {
          
    BufferedImage img;

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public LoadImage() {
       try {
           img = ImageIO.read(new File("images/Robo.jpg"));
       } catch (IOException e) {
           //System.out.println(e);
           //e.printStackTrace();
           System.out.println("Can't find the image at specified location");
       }

    }

    @Override
    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(640,431);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }

    public static void main(String[] args) {

        JFrame f = new JFrame("Robo Match Up");
            
        f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        f.add(new LoadImage());
        f.pack();
        f.setVisible(true);
    }
}

