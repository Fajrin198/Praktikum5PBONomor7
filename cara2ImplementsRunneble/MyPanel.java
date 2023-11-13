package cara2ImplementsRunneble;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements Runnable {
    int xo = 40;
    int yo = 60;
    volatile boolean running = true;
    Thread thread;
    
    public void update(){
        xo += 2;
        yo += 2;
    }

    @Override
    public void addNotify() {
        super.addNotify();
        thread = new Thread(this);
        thread.start();
    }
    
    
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.fillOval(xo, yo, 80, 80);
        g2d.dispose();
    }
    
    private void delay(long l){
        try {
            Thread.sleep(l);
        } catch (InterruptedException ex) {
            
        }
    }
    
    @Override
    public void run() {
        while(running){
            update();
            repaint();
            delay(100);
        }
    }
    
}
