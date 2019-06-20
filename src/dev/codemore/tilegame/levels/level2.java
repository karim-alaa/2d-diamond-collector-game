package dev.codemore.tilegame.levels;

import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.worlds.World;

public class level2 extends World {
	protected final static int[][] pos = { { 200, 200 }, { 400, 400 }, { 500, 500 }, { 500, 700 }, { 300, 400 },
			{ 600, 500 },{300,300} };

	private static String name = "LEVEL 2";
	
	public level2(Handler handler) {
		super(handler, "res/worlds/world2.txt", pos, name);
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
