package dev.codemore.tilegame.entities.statics;

import java.awt.Graphics;
import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.gfx.Assets;
import dev.codemore.tilegame.tiles.Tile;




public class Diamond extends StaticEntity {
	


	public  Diamond(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT );
	}

	@Override
	public void tick() {

	}
	
	

	@Override
	public   void render(Graphics g) {
		g.drawImage(Assets.diamond,(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}



}
