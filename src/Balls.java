import java.awt.Color;

public class Balls {
    double lowerVelocity = 0.005;
	double upperVelocity = 0.01;
    int NumBalls = 3;
    double radius = 0.025;
    double[] ballsX = new double[NumBalls];
	double[] ballsY = new double[NumBalls];
	double[] ballsXVelocity = new double[NumBalls];
	double[] ballsYVelocity = new double[NumBalls];

    public void ballsPositionUpdate(){
        for(int i = 0; i < NumBalls; i++) {
			ballsX[i] = Math.random();
			ballsY[i] = Math.random();
			ballsXVelocity[i] = Math.random() * (upperVelocity - lowerVelocity) + lowerVelocity;
			ballsYVelocity[i] = Math.random() * (upperVelocity - lowerVelocity) + lowerVelocity;
		}
    }

    public boolean collisionDetection(double playerX, double playerY){
			for(int i = 0; i < NumBalls; i++) {
				
			
				ballsX[i] = ballsX[i] + ballsXVelocity[i];
				ballsY[i] = ballsY[i] + ballsYVelocity[i];
				if(ballsX[i] + radius > 1 || ballsX[i] - radius < 0) { 
					ballsXVelocity[i] = -ballsXVelocity[i];
				}
				if(ballsY[i] + radius > 1 || ballsY[i] - radius < 0) { 
					ballsYVelocity[i] = -ballsYVelocity[i];
				}
				for(int j = 0; j < NumBalls; j++) {
					if(i != j) {
						double d = Math.sqrt(Math.pow(ballsX[i] - ballsX[j], 2) + Math.pow(ballsY[i] - ballsY[j], 2));
						if(d < 2 * radius) {
							ballsXVelocity[i] = -ballsXVelocity[i];
							ballsYVelocity[i] = -ballsYVelocity[i];
						}
					}
				}
				
				double d = Math.sqrt(Math.pow(ballsX[i] - playerX, 2) + Math.pow(ballsY[i] - playerY, 2));
				if(d < 2 * radius) {
					return true;
				}
            }
        return false;
        }

        public void startOver(){
            NumBalls++;
            double[] ballXnew = new double[NumBalls];
			double[] ballYnew = new double[NumBalls];
			double[] ballXVnew = new double[NumBalls];
			double[] ballYVnew = new double[NumBalls];
			for(int i = 0; i < NumBalls - 1; i++) {
				ballXnew[i] = ballsX[i];
				ballYnew[i] = ballsY[i];
				ballXVnew[i] = ballsXVelocity[i];
				ballYVnew[i] = ballsYVelocity[i];
			}
			ballXnew[NumBalls-1] = Math.random();
			ballYnew[NumBalls-1] = Math.random();
			ballXVnew[NumBalls-1] = Math.random() * (upperVelocity - lowerVelocity) + lowerVelocity;
			ballYVnew[NumBalls-1] = Math.random() * (upperVelocity - lowerVelocity) + lowerVelocity;
			ballsX = ballXnew;
			ballsY = ballYnew;
			ballsXVelocity = ballXVnew;
			ballsYVelocity = ballYVnew;
        }

        public void drawBalls(){
            StdDraw.setPenColor(Color.red);
			for(int i = 0; i < NumBalls; i++) {
				StdDraw.filledCircle(ballsX[i], ballsY[i], radius);
			}
        }
}