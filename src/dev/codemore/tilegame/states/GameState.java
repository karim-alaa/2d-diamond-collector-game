package dev.codemore.tilegame.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.entities.EntityManager;
import dev.codemore.tilegame.levels.level1;
import dev.codemore.tilegame.levels.level2;
import dev.codemore.tilegame.levels.level3;
import dev.codemore.tilegame.levels.level4;
import dev.codemore.tilegame.sounds.Sound;
import dev.codemore.tilegame.worlds.World;

public class GameState extends State {

	@SuppressWarnings("unused")
	private EntityManager entityManger;
	private World world;
	private level1 level1;
	private level2 level2;
	private level3 level3;
	private level4 level4;
	private Sound sound;
	private boolean GameOver = false;
    private String level1MusicPath, level2MusicPath, level3MusicPath, level4MusicPath, gameOver;

	@SuppressWarnings("static-access")
	public GameState(Handler handler) {
		super(handler);
		
		// for music
		sound = new Sound();
		
		// set levels 
		// this is for not error when i select level below this
		level1 = new level1(handler);
        level2 = new level2(handler);
        level3 = new level3(handler);
        level4 = new level4(handler);
		// set path of musics
        level1MusicPath = "C:\\Users\\karim\\workspace\\TileGame\\res\\music\\level.wav";
        level2MusicPath = "C:\\Users\\karim\\workspace\\TileGame\\res\\music\\level.wav";
        level3MusicPath = "C:\\Users\\karim\\workspace\\TileGame\\res\\music\\level.wav";
        level4MusicPath = "C:\\Users\\karim\\workspace\\TileGame\\res\\music\\level.wav";
        gameOver = "C:\\Users\\karim\\workspace\\TileGame\\res\\music\\gameOver.wav";
        
        
        // set it by hand to make the pos array selected as level 1 when game start
	    world = new level1(handler);
	    handler.getWorld().pos = level1.pos;
	    sound.play(level1MusicPath);
     //	handler.setWorld(world);
    	
    	
    
	}
	
	
	  
		

	@SuppressWarnings("static-access")
	@Override
	public  void tick() {
		
	
		// which world can be run rigth now
		if(EntityManager.COUNTRE == handler.getWorld().pos.length && level1.isRun() && handler.getKeyManager().skip ){
			EntityManager.COUNTRE = 0;
			level1.setRun(false);
			world = new level2(handler);
			sound.stop();
			sound.play(level2MusicPath);
		}else if((EntityManager.COUNTRE == handler.getWorld().pos.length && level2.isRun() && handler.getKeyManager().skip )){ // for not make an erroe here
			EntityManager.COUNTRE = 0;
			level2.setRun(false);
			world = new level3(handler);
			sound.stop();
			sound.play(level3MusicPath);
		}
		else if((EntityManager.COUNTRE == handler.getWorld().pos.length && level3.isRun() && handler.getKeyManager().skip  )){
			EntityManager.COUNTRE = 0;
			level3.setRun(false);
			world = new level4(handler);
			sound.stop();
			sound.play(level4MusicPath);
		}
		else if((EntityManager.COUNTRE == handler.getWorld().pos.length && level4.isRun() && handler.getKeyManager().skip )){
			EntityManager.COUNTRE = 0;
			level4.setRun(false);
		    GameOver = true;
			sound.stop();
			sound.play(gameOver);
		}
		
		 handler.setWorld(world);
         world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		if(GameOver){
			drawGameOver(g);
		}
		
		drawBarInfo(g);
		
		
		

	}
	
	public void drawBarInfo(Graphics g){
	
		Font small = new Font("Helvetica", Font.BOLD, 14);
	
		g.setFont(small);
		if (g instanceof Graphics2D) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g2d.setColor(Color.BLACK);
			g2d.fillRect(0, 0, 1500, 50);
			g2d.setColor(Color.yellow);
			g2d.drawString("You Have " + EntityManager.COUNTRE + " Diamond ", 22, 20); 
			g2d.drawString(handler.getWorld().name, 222, 20);
			g2d.drawString("Left " + EntityManager.D_LEFT + " Diamond", 333, 20);
			g2d.drawString("Total Score " + EntityManager.TOTALSCORE, 500, 20);
			g2d.setColor(Color.RED);
			g2d.drawString("By : Karim Alaa" , 650, 20);
			g2d.setColor(Color.BLUE);
			g2d.drawString("if you have all diamond press enter to go next" , 235,40);
		}
	}
	
	
	private void drawGameOver(Graphics g) { // for say game over
		String msg = "The End";
		Font small = new Font("Helvetica", Font.BOLD, 60);
		g.setColor(Color.yellow);
		g.setFont(small);
		if (g instanceof Graphics2D) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g2d.drawString(msg,handler.getGame().getWidth() / 2 - handler.getGameCamera().getxOffset() / 2,handler.getGame().getHeight() / 2 ); // to// be// in// the// center// for// ever	
		}
	}

}
