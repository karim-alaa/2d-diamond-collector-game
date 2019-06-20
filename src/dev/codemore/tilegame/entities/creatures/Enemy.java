package dev.codemore.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.gfx.Animation;
import dev.codemore.tilegame.gfx.Assets;

public class Enemy extends Creature {

	//Animations
	private Animation animDown, animUp, animLeft, animRight; 
	
	
    private boolean upDirection = false, downDirection = false, leftDirection = false, rightDirection = false;
	
	public Enemy(Handler handler,float x, float y) {
		super(handler,x, y, Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		this.handler = handler;
		this.setX(x);
		this.setY(y);
		//Animations
		animDown = new Animation(250, Assets.player_down);
		animUp = new Animation(250, Assets.player_up);
		animLeft = new Animation(250, Assets.player_left);
		animRight = new Animation(250, Assets.player_right);
	}

	@Override
	public void tick() {
		//Animation
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		//Movement
		getDirection();
		getInput();
		move();
	}




	
	private void getDirection() {
		

		if (handler.getKeyManager().up1 || handler.getKeyManager().up2) {
			upDirection = true;
			leftDirection = false;
			rightDirection= false;
			downDirection= false;
		}
		if (handler.getKeyManager().down1 || handler.getKeyManager().down2) {
			upDirection = false;
			leftDirection = false;
			rightDirection= false;
			downDirection= true;
		}
		if (handler.getKeyManager().left1 || handler.getKeyManager().left2) {
			upDirection = false;
			leftDirection = true;
			rightDirection= false;
			downDirection= false;
		}
		if (handler.getKeyManager().right1 || handler.getKeyManager().right2) {
			upDirection = false;
			leftDirection = false;
			rightDirection= true;
			downDirection= false;
		}
	

	}
	
	
	private void getInput() {
		
		xMove = 0;
		yMove = 0;
		
		if (upDirection) {
			yMove = -speed;
			upDirection = false;
		}
		if (downDirection) {
			yMove = speed;
			downDirection = false;
		}
		if (leftDirection) {
			xMove = -speed;
			leftDirection = false;
		}
		if (rightDirection) {
			xMove = speed;
			rightDirection = false;
		}
	}
	
	

	@Override
	public void render(Graphics g) { 
		// to move with tiles
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width , height, null);
	
      }
	
	
	private BufferedImage getCurrentAnimationFrame(){
         if(xMove < 0){
        	return animLeft.getCurrentFrame(); 
         }else if(xMove > 0){
         	return animRight.getCurrentFrame(); 
          }else if(yMove < 0){
          	return animUp.getCurrentFrame(); 
          }else{
          	return animDown.getCurrentFrame(); 
          }
		
	}
	

	
}
