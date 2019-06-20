package dev.codemore.tilegame.entities.statics;

import java.awt.Rectangle;
import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.entities.Entity;


public abstract class StaticEntity extends Entity {

	protected boolean vis = true;

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

	public boolean isSolid() {
		return false;
	}

	public boolean isVisible() {
		return vis;
	}

	public void setVisible(Boolean visible) {
		vis = visible;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, width, height);
	}

}
