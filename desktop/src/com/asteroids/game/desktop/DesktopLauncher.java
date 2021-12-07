/*
Gattolfo98
Braggio Amedeo
2021
69
*/


package com.asteroids.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.asteroids.game.Astro;
// small pixel games
public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "PONG by Braggio Amedeo";
                config.width = 1920;
		config.height = 1080;
                config.useGL30 = false;
                config.fullscreen = true;
		new LwjglApplication(new Astro(), config);
	}
}
