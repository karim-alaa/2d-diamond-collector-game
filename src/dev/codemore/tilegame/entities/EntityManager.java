package dev.codemore.tilegame.entities;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.entities.creatures.Player;
import dev.codemore.tilegame.entities.statics.Diamond;


public class EntityManager {

	private Player player;
	private Handler handler;
	private ArrayList<Entity> entities;
	private ArrayList<Diamond> diamond;
	private int[][] pos ;
//	private final int[][] pos = { { 200, 200 },{ 400, 400 },{ 500, 500 },{ 500, 700 },{ 300, 400 },{ 600, 500 } };
	public static int COUNTRE;
	public static int D_LEFT ;
	public static int TOTALSCORE;

	@SuppressWarnings("static-access")
	public EntityManager(Handler handler, Player player, int[][] pos) {
		this.pos = pos;
		
		this.handler = handler;
		D_LEFT = handler.getWorld().pos.length;
		
		
		this.player = player;
		entities = new ArrayList<Entity>();
		initDiamonds();
	}

	public void initDiamonds() {
		diamond = new ArrayList<>();
		for (int[] p : pos) {
			diamond.add(new Diamond(handler, p[0], p[1]));
		}
	}

	public void tick() {
		/*
		 * for(int i =0; i < entities.size();i++){ Entity e = entities.get(i);
		 * e.tick(); }
		 */
		checkCollisionsWithDiamond();
		player.tick();
	}

	/*public void drawNumber(Graphics g) {
		String msg1 = " You Have ";
		String msg2 = " Diamond ";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		g.setColor(Color.yellow);
		g.setFont(small);
		if (g instanceof Graphics2D) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g2d.drawString(msg1  + COUNTRE  + msg2, 20, 20); 
		}
	}*/

	public void render(Graphics g) {
		for (Diamond t : diamond) {
			if (t.isVisible()) {
				t.render(g);
			}
		//	drawNumber(g);
		}
		
		
		
		
		/*
		 * for(Entity e : entities){ e.render(g); }
		 */
		player.render(g);
	}

	/*
	 * public void addEntitiy(Entity e){ entities.add(e); }
	 */

	public void checkCollisionsWithDiamond() {

		Rectangle r3 = player.getBounds();
		for (Diamond t : diamond) {
			Rectangle r2 = t.getBounds();

			if (r3.intersects(r2) && t.isVisible()) {
				t.setVisible(false);
				COUNTRE++;
				TOTALSCORE++;
				D_LEFT--;
			}
		}

	}

	// GETTERS SETTERS

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

}
