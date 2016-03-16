import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.Timer;
class snake implements KeyListener,ActionListener
{
	boolean updir = false;
	boolean downdir = false;
	boolean rightdir = true;
	boolean leftdir = false;
	int width = 20; 
	static int height = 20;
	int x1=50,y1=50;
	int x,y;
	int score = 0;
	int time_keeper = 0;
	JFrame f;
	Timer time;
	JLabel l,food;
	snake()
	{
		f = new JFrame("Snake");
		f.setLayout(null);
		f.setSize(850,750);
		l = new JLabel();
		food = new JLabel();
		l.setBounds(x1,y1,width,height);
		l.setBackground(Color.black);
		generate();
		food.setBackground(Color.black);
		food.setOpaque(true);
		l.setOpaque(true);
		f.add(l);
		f.add(food);
		time = new Timer(1000,this);
		time.start();
		f.addKeyListener(this);
		f.setVisible(true);
	}
	public static void main(String arg[])
	{
		new snake();
	}
	public  void actionPerformed( ActionEvent e)
	{
		time_keeper++;
		if(time_keeper==135)
		{

			generate();
			time_keeper=0;
		}
		if((x1<=x+15 && y1>=y && y1<=y+15)||(x1<=x+15 && y1+50>=y && y1+50<=y+15))
		{
			score++;
			System.out.println("Score" + " " + score);
			generate();
			time_keeper = 0;
		}
		if(updir)
		{
			l.setBounds(x1,y1-30,width,height);
			y1 = y1 - 30;
			l.setBackground(Color.black);
			l.setOpaque(true);
		}
		else if(downdir)
		{
			l.setBounds(x1,y1+30,width,height);
			y1 = y1 + 30;
			l.setBackground(Color.black);
			l.setOpaque(true);
		}
		else if(leftdir)
		{
			l.setBounds(x1-30,y1,width,height);
			x1 = x1-30;
			l.setBackground(Color.black);
			l.setOpaque(true);
		}
		else
		{
			l.setBounds(x1+30,y1,width,height);
			x1 = x1 + 30;
			l.setBackground(Color.black);
			l.setOpaque(true);
		}
	}
	public void keyTyped(KeyEvent e) 
	{

	}	
	public void collide()
	{

	}
	public void generate()
	{
		 x = 100 + (int)(Math.random() * ((500 - 10) + 1));
		System.out.println(x);
		 y = 100 + (int)(Math.random() * ((500 - 10) + 1));
		System.out.println(y);
		food.setBounds(x,y,15,15);
		food.setBackground(Color.black);
		food.setOpaque(true);
	}
      	public void keyPressed(KeyEvent e) 
      	{
      		System.out.println("Key pressed");
		int key = e.getKeyCode();   
		if ((key == KeyEvent.VK_LEFT) && (!rightdir)) 
		{
             	 	leftdir = true;
                		updir = false;
               		downdir = false;
            		}

            		else if ((key == KeyEvent.VK_RIGHT) && (!leftdir)) 
            		{
                		rightdir = true;
               	 	updir = false;
                		downdir = false;
            		}

            		else if ((key == KeyEvent.VK_UP) && (!downdir)) 
            		{
              		updir = true;
              		rightdir = false;
              		leftdir = false;
          		 }

            		else if ((key == KeyEvent.VK_DOWN) && (!updir)) 
            		{
                		downdir = true;
                		rightdir = false;
                		leftdir = false;
            		}      
         	}
      	public void keyReleased(KeyEvent e) 
      	{

      	}    
}