package dev.codemore.tilegame;


import java.awt.Graphics;
import java.awt.image.BufferStrategy;


import dev.codemore.tilegame.display.Display;
import dev.codemore.tilegame.gfx.Assets;
import dev.codemore.tilegame.gfx.GameCamera;

import dev.codemore.tilegame.input.KeyManager;
import dev.codemore.tilegame.states.GameState;
import dev.codemore.tilegame.states.State;
import dev.codemore.tilegame.states.MenuState;

public class Game implements Runnable { // the main class over game

	private Display display;
	private int width;
	private int height;
	private String title;
	private  Thread thread;
	public static boolean running = false;

	private BufferStrategy bs;
	private Graphics g;

	// State
	private State gameState;
	@SuppressWarnings("unused")
	private State MenuState;

	// Input2

	private KeyManager keyManager;

	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	
	// private BufferedImage test;
	// private SpriteSheet sheet;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}

	private void init() { // game loop over game // intilizetion
		display = new Display(title, width, height);
		// test = imageLoader.loadImage("/textures/sheet.png");
		// sheet = new SpriteSheet(test);
		display.getFrame().addKeyListener(keyManager);

		Assets.init();
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);

		
		
		gameState = new GameState(handler); // i can't make an opject from abstract
											// class it's foorbiden // but i can
											// make an opject from class that
											// extends this abstract class and
											// call all function in abstract
											// class and itself class
		MenuState = new MenuState(handler);
		State.setState(gameState); // function and variable in abstract class
									// must be static for able to access

	}
	private void tick() { // for update every thing
		keyManager.tick(); // why i must use it

		if (State.getState() != null)
			State.getState().tick();
	}

	private void render() { // for draw every thing
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics(); // your paint

		// Clear Screen
		g.clearRect(0, 0, width, height);

		// DRAW HERE

		if (State.getState() != null)
			State.getState().render(g);

		// g.drawImage(sheet.crop(0, 0, 30, 50), 5, 5, null); //null !!
		// g.drawImage(sheet.crop(30, 50, 30, 50), 50, 5, null); //null !!
		// END DRAW

		bs.show();
		g.dispose(); // for good way and arrangment
	}

	@SuppressWarnings("unused")
	public void run() {
		init();

		int fps = 100;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		long ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if (timer >= 1000000000) {
				// System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public synchronized  void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start(); // run the run method
	}
	public synchronized  void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
