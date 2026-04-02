import java.awt.Color;
import java.awt.event.KeyEvent;

public class Player {
    double playerX = 0.5;
	double playerY = 0.5;
	double playerSpeed = 0.01;
    double radius = 0.025;


    public void checkKeyPress(){
        if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			playerY = playerY + playerSpeed;
		}
		if(StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			playerY = playerY - playerSpeed;
		}
		if(StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			playerX = playerX - playerSpeed;
		}
		if(StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			playerX = playerX + playerSpeed;
		}
    }

    public void outOfBoundsDetection(){
        if(playerX > 1) {
			playerX = 1;
		}
		if(playerX < 0) {
			playerX = 0;
		}
		if(playerY > 1) {
			playerY = 1;
		}
		if(playerY < 0) {
			playerY = 0;
		}
    }

    public void drawPlayer(){
        StdDraw.setPenColor(Color.black);
		StdDraw.filledCircle(playerX, playerY, radius);
    }
}
