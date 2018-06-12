package gui;

import java.awt.Graphics;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.Gunfight;

@SuppressWarnings("serial")
public class Draw extends JPanel {
	public static final int GAME_SPEED = 10000;
	boolean first = true;
	public void rpaint() {
		this.repaint();
	}
	public Draw() {
		startTime = System.currentTimeMillis();
	}
	private long startTime;
	private long currentTime;
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		try {
			
			if (Gunfight.game != null && !Gunfight.paused) {
				Gunfight.game.run(g);
			}
			if (first) {
				ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
				exec.scheduleAtFixedRate(new Runnable() {
				  @Override
				  public void run() {
					  rpaint();
				  }
				}, 0, 5, TimeUnit.MILLISECONDS);
				first = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("PaintComponent ERROR catch");
		}
	}
}
