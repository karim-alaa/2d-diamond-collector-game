package dev.codemore.tilegame.tiles;



import dev.codemore.tilegame.gfx.Assets;

public class GrassTile extends Tile {

	public GrassTile(int id) {
		super(Assets.grass, id);
	}
	
	
	public boolean canDelelte(){
		return true;
	}
	
	

}
