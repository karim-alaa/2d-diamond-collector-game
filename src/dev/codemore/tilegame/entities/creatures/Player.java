package dev.codemore.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.gfx.Animation;
import dev.codemore.tilegame.gfx.Assets;

public class Player extends Creature {

	//Animations
	private Animation animDown, animUp, animLeft, animRight; 
	
	
	 private boolean upDirection = false, downDirection = false, leftDirection = false, rightDirection = false;
		
	
	

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		

		bounds.x = 16;
		bounds.y = 28;
		bounds.width = 32;
		bounds.height = 32;
		
		

		staticBounds.x = 16;
		staticBounds.y = 25;
		staticBounds.width = 37;
		staticBounds.height = 35;
		
		
		
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
		handler.getGameCamera().centerOnEntity(this);
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
	public void render(Graphics g) { // ooooofff
		// to move with tiles
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width , height, null);
	
//	g.setColor(Color.BLUE);
	//g.fillRect((int)(x+staticBounds.x - handler.getGameCamera().getxOffset()),(int)(y + staticBounds.y - handler.getGameCamera().getyOffset()),staticBounds.width ,staticBounds.height);
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
