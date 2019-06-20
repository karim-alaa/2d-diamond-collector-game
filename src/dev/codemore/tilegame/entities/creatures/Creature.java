package dev.codemore.tilegame.entities.creatures;


import java.awt.Rectangle;
import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.entities.Entity;
import dev.codemore.tilegame.tiles.Tile;

public abstract class Creature extends Entity {

	public static final int DEFAUIT_HEALTH = 10;
	public static final float DEFAUIT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;


	
	protected int health;
	protected float speed;
	protected float xMove, yMove;

	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height); // must do it for lead to Entity
												// class constracture
		health = DEFAUIT_HEALTH;
		speed = DEFAUIT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	public void move() {
		moveX();
		moveY();
	}
	
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int) y, width, height);
	}


	public void moveX() {
		if (xMove > 0) {// MOVEING RIGHT
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
               int y1 = (int) (y + bounds.y) / Tile.TILEHEIGHT ;
               int y2 = (int) (y + bounds.y + bounds.height) / Tile.TILEWIDTH;
               
			if ((!collisionWithTile(tx,y1 )&& !collisionWithTile(tx, y2))) {
				x += xMove;
			} else {
					x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;	
			}
		} else if (xMove < 0) {// MOVEING LEFT
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
            int y3 = (int) (y + bounds.y) / Tile.TILEHEIGHT;
            int y4 = (int) (y + bounds.y + bounds.height) / Tile.TILEWIDTH;
            
			if (!collisionWithTile(tx,y3 ) && !collisionWithTile(tx,y4)) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}

		}
	}

	public void moveY() {// UP
		if (yMove < 0) {
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
            int x1 = (int) (x + bounds.x) / Tile.TILEWIDTH;
            int x2 = (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH;
            
			if (!collisionWithTile(x1, ty) && !collisionWithTile(x2, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		} else if (yMove > 0) {// DOWN
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
            int x3 = (int) (x + bounds.x) / Tile.TILEWIDTH;
            int x4 = (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH;
            
			if (!collisionWithTile(x3, ty)
					&& !collisionWithTile(x4, ty)) {
				y += yMove;
			} else {
					y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}

		}

	}

	protected boolean collisionWithTile(int x, int y) {			
		return handler.getWorld().getTile(x, y).isSolid();
	}


	


	// GETTERS & SETTERS

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
