package dev.codemore.tilegame.sounds;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.*;

public class Sound {

	private static AudioStream as = null;
	private static InputStream in;

	public void play(String path) {

		try {
			in = new FileInputStream(path);
			as = new AudioStream(in);
		} catch (FileNotFoundException e) {
			System.out.println("Audio file not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Incorrect input.");
			e.printStackTrace();
		}
		AudioPlayer.player.start(as);
	}

	public void stop() {
		AudioPlayer.player.stop(as);
	}

}
