package dev.codemore.tilegame.worlds;

import java.awt.Graphics;

import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.entities.Entity;
import dev.codemore.tilegame.entities.EntityManager;
import dev.codemore.tilegame.entities.creatures.Player;
import dev.codemore.tilegame.tiles.Tile;
import dev.codemore.tilegame.utils.Utils;

public class World {

	
	private  Handler handler; /////////////////////////////////////////////////
	private int width, height;
	private  int spawnX; // x,y from file
	private  int spawnY;
	private int[][] tiles;
	protected   boolean run ;
	

	public static int[][] pos ;
	public  String name;

	// set the level visablity

	public   boolean isRun(){
		return run;
	}
	
    public  void setRun(boolean run){
		this.run = run;
	}
    
   
	
	// Entities
	private static EntityManager entityManager;

	@SuppressWarnings("static-access")
	public World(Handler handler, String path, int[][] pos, String name) {
		this.pos = pos;
		this.name = name;
           run = true;
	
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 0000,0000),pos); // want to delete 100 100
		//	entityManager.addEntitiy(new Tree(handler, 400, 300));
		loadWorld(path);
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	

	
	public void worldMusic(){
		// here open the music
	}


	public  void tick() {
       entityManager.tick();
	}

	
	public  void render(Graphics g) {

		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//Entities
		entityManager.render(g);
		// Tree.render(g);
		
		
	
		
		
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.dirtTile;
		Tile t = Tile.tiles[tiles[x][y]];
		
		if (t == null)
			return Tile.dirtTile;
		return t;
	}
	
	public Entity getEntity(){
		return null;
		
		
	}

	private void loadWorld(String path) { // get it from files
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]); // where i can make it work
		spawnY = Utils.parseInt(tokens[3]); // where i can make it work
		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
