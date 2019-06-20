package dev.codemore.tilegame.levels;

import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.worlds.World;

public class level4 extends World {
	protected final static int[][] pos = {  { 300, 400 },
			{ 600, 500 } };

	private static String name = "LEVEL 4";
	
	public level4(Handler handler) {
		super(handler, "res/worlds/world4.txt", pos, name);
	}

	/*
	 * public void tick(){
	 * 
	 * }
	 * 
	 * public void render(Graphics g){
	 * 
	 * }
	 */

}
