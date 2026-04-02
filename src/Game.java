public class Game {

	double radius = 0.025;
	int score = 0;
	int highScore = 0;
	long startTime;
	long deadTime;
	
	Balls balls = new Balls();
	Player player =  new Player();

	public void resetGame(){
		if(balls.collisionDetection(player.playerX, player.playerY)) {
			balls.ballsPositionUpdate();	
			score = 0;
			startTime = System.currentTimeMillis();
			deadTime = System.currentTimeMillis();
			player.playerX = 0.5;
			player.playerY = 0.5;
		}
	}

	public void run(){
		balls.ballsPositionUpdate();
		
		StdDraw.enableDoubleBuffering();
		
		startTime = System.currentTimeMillis();
		deadTime = System.currentTimeMillis();
		
		while (true) {
			
			StdDraw.clear();
			
			resetGame();
			
			player.checkKeyPress();
			
			player.outOfBoundsDetection();
			
			long now = System.currentTimeMillis();
			if(now > startTime + 1000) {
				score++;
				if(score > highScore) {
					highScore = score;
				}
				startTime = now;
			}
			
			if(now > deadTime + 10000) {
				balls.startOver();
				deadTime = now;
			}

			balls.drawBalls();
			player.drawPlayer();
			
			StdDraw.text(0.5, 0.1, "Score: " + score + " High Score: " + highScore);
			
			StdDraw.show();
			StdDraw.pause(10);
			
		}
	}
	public static void main(String[] args) {
		new Game().run();
	}
		

}
