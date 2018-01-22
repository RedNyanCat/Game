package me.RedNyanCat.display;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import me.RedNyanCat.main.game;

public class display extends Canvas {

	//Longs
	private static final long serialVersionUID = 1L;

	//Ints
	private final int WIDTH = 720, HEIGHT = WIDTH / 12 * 9, SCALE = 1; //WIDTH divided by 160 = 4.5
	public int tickCount = 0;
	
	//Strings
	protected String NAME = "RPG game demo"; //Games display name.
	
	//Floats
	
	//Doubles
	
	//Images
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	BufferStrategy bs;
	
	public void tick(game game) {
		
		tickCount++;
		
		for(int i = 0; i < pixels.length; i++) {
			
			pixels[i] = i + tickCount;
			
		}
		
	}
	
	public void render(game game) {
		
		bs = getBufferStrategy();
		
		if(bs == null) {
			
			createBufferStrategy(3);
			return;
			
		} 
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		bs.show();
		
	}
	
	public void setDisplayName(String name) {
		
		NAME = name;
		
	}

	public int getScale() {
		
		return SCALE;
		
	}
	
}
