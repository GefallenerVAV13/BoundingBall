import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball extends JPanel implements ActionListener {
    private int ballX = 50;
    private int ballY = 50;
    private int ballDiameter = 100;
    private int ballDeltaX = 2;
    private int ballDeltaY = 2;

    private Timer timer;

    public Ball() {
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(ballX, ballY, ballDiameter, ballDiameter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ballX += ballDeltaX;
        ballY += ballDeltaY;

        if (ballX < 0 || ballX + ballDiameter > getWidth()) {
            ballDeltaX *= -1;
        }
        if (ballY < 0 || ballY + ballDiameter > getHeight()) {
            ballDeltaY *= -1;
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        Ball bouncingBall = new Ball();
        frame.add(bouncingBall);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

