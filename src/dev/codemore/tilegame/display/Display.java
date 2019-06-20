package dev.codemore.tilegame.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {

	private JFrame frame;
	private Canvas canvas; // for graphics
	private String title;
	private int width,height;
	
	public Display(String title, int width, int height){
		this.title=title;
		this.width=width;
		this.height=height;
		
		createDisplay();
	}
	
	private void createDisplay(){
		frame = new JFrame(title);
	    frame.setSize(width, height);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	  // frame.pack();  // what is this
	    
	    canvas = new Canvas();
	    canvas.setPreferredSize(new Dimension(width,height));
	    canvas.setMaximumSize(new Dimension(width,height));
	    canvas.setMinimumSize(new Dimension(width,height));
	    canvas.setFocusable(false);
	    
	    frame.add(canvas);
	    frame.pack(); // if you don't have evary thimg will work but you can't see it
	    
	
	}
	
	 public Canvas getCanvas(){
	    	return canvas;
	    }
	 
	 public JFrame getFrame(){
		 return frame;
	 }
	
}
