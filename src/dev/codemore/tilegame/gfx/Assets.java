package dev.codemore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 31 , height = 48 ;
	private static final int width1 = 85 , height1 = 87 ;
//	private static final int width2 = 32 , height2 = 32;
	
	
	public static BufferedImage otherPlayer1,otherPlayer2,otherPlayer3,otherPlayer4,otherPlayer5,otherPlayer6,otherPlayer7,otherPlayer8;
	public static BufferedImage player ,dirt, grass, stone, tree;
	public static BufferedImage diamond;
	public static BufferedImage[] player_down,player_up, player_left, player_right;
	
	public static void init(){ // load everything in the which can use once // don't need to update 
		
		//START PLAYER
	
    	//Other Player
    	
    	SpriteSheet sheet2 = new SpriteSheet(imageLoader.loadImage("/textures/sheet2.png"));
    	//Down
    	otherPlayer1 = sheet2.crop(0, 0, width, height);
    	otherPlayer2 = sheet2.crop(width, 0, width, height);
    	//Up
    	otherPlayer3 = sheet2.crop(width * 2, 0, width, height);
    	otherPlayer4 = sheet2.crop(width * 3, 0, width, height);
    	//Left
    	otherPlayer1 = sheet2.crop(0, height, width, height);
    	otherPlayer2 = sheet2.crop(width,height , width, height);
    	//Right
    	otherPlayer3 = sheet2.crop(width * 2, height, width, height);
    	otherPlayer4 = sheet2.crop(width * 3, height, width, height);
    	
    	
    	SpriteSheet sheet = new SpriteSheet(imageLoader.loadImage("/textures/sheet.png"));
    	//player down
    	player_down = new BufferedImage[4];
    	player_down[0] = sheet.crop(0, 0, width, height);
    	player_down[1] = sheet.crop(width, 0, width, height);
    	player_down[2] = sheet.crop(width * 2, 0, width, height);
    	player_down[3] = sheet.crop(width * 3, 0, width, height);
    	//player up
    	player_up = new BufferedImage[4];
    	player_up[0] = sheet.crop(0, height *3, width, height);
    	player_up[1] = sheet.crop(width, height *3, width, height);
    	player_up[2] = sheet.crop(width *2, height *3, width, height);
    	player_up[3] = sheet.crop(width *3, height *3, width, height);
    	//player left
    	player_left = new BufferedImage[4];
    	player_left[0] = sheet.crop(0, height, width, height);
    	player_left[1] = sheet.crop(width, height, width, height);
    	player_left[2] = sheet.crop(width *2, height, width, height);
    	player_left[3] = sheet.crop(width *3, height, width, height);
    	//player right
    	player_right = new BufferedImage[4];
    	player_right[0] = sheet.crop(0, height * 2, width, height);
    	player_right[1] = sheet.crop(width, height *2 , width, height);
    	player_right[2] = sheet.crop(width * 2, height *2, width, height);
    	player_right[3] = sheet.crop(width * 3, height *2, width, height);
		
    	
    	//END PLAYER
    	
    	//Diamond
    	SpriteSheet sheet3 = new SpriteSheet(imageLoader.loadImage("/textures/Diamond_Sprite.png"));
    	// 500 353
    	diamond = sheet3.crop(0,0,500,353);
    	
    	//START TILE
    	SpriteSheet sheet1 = new SpriteSheet(imageLoader.loadImage("/textures/sheet1.png"));
    	player = sheet1.crop(0, 0, width1, height1);
    	dirt = sheet1.crop(width1, 0, width1, height1);
    	stone = sheet1.crop(width1 * 3, 0, width1, height1);
    	tree = sheet1.crop(0, height1, width1, height1);
    	grass = new SpriteSheet(imageLoader.loadImage("/textures/GrassTile.png")).crop(0, 0, 64, 64);
    	//END TILE
	}
	
}
