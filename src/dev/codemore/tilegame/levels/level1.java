package dev.codemore.tilegame.levels;

import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.worlds.World;

public class level1 extends World {

	public static final  int[][] pos = {{20,20} , {300,300}, {900,300} , {200,700} , {800,800} , {900,900} , {460,700} };
	private static String name = "LEVEL 1";

	public level1(Handler handler) {
		super(handler, "res/worlds/world1.txt", pos, name);
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
