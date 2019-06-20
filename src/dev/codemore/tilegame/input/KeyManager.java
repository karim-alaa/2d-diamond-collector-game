package dev.codemore.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean up1, down1, left1, right1, jump1, up2, down2, left2, right2, jump2, stop, skip;

	public KeyManager(){
		keys = new boolean[256];
	}
	
	public void tick(){
		up1 = keys[KeyEvent.VK_W];
		up2 = keys[KeyEvent.VK_UP];
		down1 = keys[KeyEvent.VK_S];
		down2 = keys[KeyEvent.VK_DOWN];
		left1 = keys[KeyEvent.VK_A];
		left2 = keys[KeyEvent.VK_LEFT];
		right1 = keys[KeyEvent.VK_D];
		right2 = keys[KeyEvent.VK_RIGHT];
		stop = keys[KeyEvent.VK_SPACE];
		skip = keys[KeyEvent.VK_ENTER];
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	//	System.out.println("Pressed!");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	


	
	
	
}
