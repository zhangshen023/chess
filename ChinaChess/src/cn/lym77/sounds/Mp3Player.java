package cn.lym77.sounds;

import javazoom.jl.player.Player;

public class Mp3Player implements Runnable {
	private Player player;
	private String filename;
	private boolean isPlayed;
	private boolean isLoop;

	public Mp3Player(String filename) {
		this.filename = filename;
	}

	public void play() {
		if (!isPlayed) {
			new Thread(this).start();
			isPlayed = true;
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				player = new Player(ClassLoader.getSystemResourceAsStream(filename));
				player.play();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (!isLoop) {
				break;
			}
		}
		close();
	}

	public void setLoop(boolean loop) {
		this.isLoop = loop;
	}

	public void close() {
		new Thread(() -> {
			isLoop = false;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			if (player != null) {
				player.close();
			}
			isPlayed = false;
		}).start();
	}
}
