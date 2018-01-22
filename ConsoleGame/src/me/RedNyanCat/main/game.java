package me.RedNyanCat.main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import me.RedNyanCat.data.playerData;
import me.RedNyanCat.data.saved_class;
import me.RedNyanCat.display.display;
import me.RedNyanCat.entities.entity;
import me.RedNyanCat.entities.entityType;

public class game extends Canvas implements Runnable {

	//Other
	private static final long serialVersionUID = 1L;

	//Classes
	private static saved_class savedObjects = new saved_class(new ArrayList<entity>());
	private display canvas = new display();

	//Booleans
	//private boolean gameLoaded = false; //character and world loading
	private boolean running = true; //thread loading

	//Ints

	//Floats

	//Doubles
	private double ticksps = 90;
	
	//JFrame
	private JFrame frame;

	//Methods
	public game() {
		
		frame = new JFrame(canvas.getName());
		
		frame.setMinimumSize(new Dimension(canvas.getWidth() * canvas.getScale(), canvas.getHeight() * canvas.getScale()));
		frame.setMaximumSize(new Dimension(canvas.getWidth() * canvas.getScale(), canvas.getHeight() * canvas.getScale()));
		frame.setPreferredSize(new Dimension(canvas.getWidth() * canvas.getScale(), canvas.getHeight() * canvas.getScale()));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
		
	}
	
	public synchronized void start() {
		
		running = true;
		new Thread(this).start();

	}

	public synchronized void stop() {

		running = false;

	}

	public static void main(String[] args) {

		new game().start();

	}

	//@Override
	public void run() {

		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D/ticksps;
		
		int frames = 0;
		int ticks = 0;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		
		while (running){
			
			long now = System.nanoTime();
			
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			
			boolean shouldRender = false;
			
			while(delta >= 1) {
				
				ticks++;
				delta -= 1;
				
				shouldRender = true;
				
				canvas.tick(this);
				
			}
			
			if (shouldRender) {
				
				frames++;
				
				canvas.render(this);
				
			}
			
			if(System.currentTimeMillis() - lastTimer >= 1000){
				
				lastTimer += 1000;
				//System.out.println(ticks + " ticks, " + frames + " frames");
				
				debugging.print(ticks + " ticks, " + frames + " frames");
				canvas.setDisplayName(ticks + " ticks, " + frames + " frames");
				
				frames = 0;
				ticks = 0;
				
			}
			
		} stop();

	}

	//New (default) Character data
	protected entity newPlayerCharacter() {

		return new entity(50.00, 1.25, 0.00, 1, 10.00, entityType.PLAYER);

	}

	//edit later, Load (old) Character data from a save file
	protected List<entity> loadPlayerCharacter(String file) {

		return playerData.load(file); //Loading and saving functions yet to be implemented properly

	}

	//Edit this HARD later

	/*public game() {

		//canvas.tick(this);

		if(!gameLoaded) {

			//ADD load function + default character
			//ADD save function

			entity e = newPlayerCharacter();

			e.getInventory().setStack(0, new item(2, itemType.BREAD));

			gameLoaded = true;

		}

		if(savedObjects != null) {

			debugging.print(savedObjects.getSavedEntities().toString());

		}

	}*/

	public static void safeAddToSavedObjects(entity e) {

		savedObjects.addToSavedEntities(e);

	}

}
