package dev.codemore.tilegame;




public class Launcher {

	

	private static Game game;
	private static int width;
	private static int height;
	private static String title;
	
	public static void main(String[] args){
		width=800;
		height=600;
		title="TileGame";
		game = new Game(title,width,height);
		//display = new Display(title,width,height);
		game.start();
	}
	
}
