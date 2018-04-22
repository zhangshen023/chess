package cn.lym77.data;

import cn.lym77.sounds.Mp3Player;

public class MyMp3 {
	public static Mp3Player looser;
	public static Mp3Player win;
	public static Mp3Player bg1;
	public static Mp3Player bg2;
	public static Mp3Player eat;

	public static void initMp3() throws Exception {
		eat = new Mp3Player("cn/lym77/data/mp3/chess_eat.mp3");
		looser = new Mp3Player("cn/lym77/data/mp3/chess_lose.mp3");
		win = new Mp3Player("cn/lym77/data/mp3/chess_win.mp3");
		bg1 = new Mp3Player("cn/lym77/data/mp3/chess_bg_0.mp3");
		bg1.setLoop(true);
		bg2 = new Mp3Player("cn/lym77/data/mp3/chess_bg_1.mp3");
		bg2.setLoop(true);
	}
}
