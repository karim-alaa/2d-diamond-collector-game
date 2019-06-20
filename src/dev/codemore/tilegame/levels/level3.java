package dev.codemore.tilegame.levels;

import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.worlds.World;

public class level3 extends World {
	protected final static int[][] pos = { { 200, 200 }, { 400, 400 }, { 500, 500 }, { 500, 700 }, { 300, 400 },
			{ 600, 500 }, {600,300} };

	private static String name = "LEVEL 3";
	
	public level3(Handler handler) {
		super(handler, "res/worlds/world3.txt", pos, name );
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
