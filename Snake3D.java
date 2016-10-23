import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import java.lang.Math;

/** @see http://stackoverflow.com/q/30011564/230513 */
public class Snake3D extends JFrame {
	

	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	private static final Apple mainApple = new Apple();
    public MyPanel one = new MyPanel(mainApple);
    public MyPanel2 two = new MyPanel2(mainApple);
    public MyPanel3 three = new MyPanel3(mainApple);
    public MyPanel4 four = new MyPanel4(mainApple);
    public Empty five = new Empty();
    public Empty six = new Empty();
    public Empty seven = new Empty();
    public Empty eight = new Empty();
    public Empty nine = new Empty();
    public EmptyToo ten = new EmptyToo();
    public EmptyToo eleven = new EmptyToo();
    public EmptyToo twelve = new EmptyToo();
    public EmptyToo thirteen = new EmptyToo();
    public EmptyToo fourteen = new EmptyToo();
    public EmptyToo fifteen = new EmptyToo();
    private static final String MOVE_UP = "move up";
    private static final String MOVE_DOWN = "move down";
    private static final String MOVE_LEFT = "move left";
    private static final String MOVE_RIGHT = "move right";
    private static final String C = "c";
    private static final String S = "s";
    private static final String R = "r";
    private static final String SPACE = "space";
    
    
    

    public Snake3D() {
        super("Snake3D");
        this.setMinimumSize(this.getPreferredSize());
        
        one.getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), MOVE_UP);
        one.getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), MOVE_DOWN);
        one.getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), MOVE_LEFT);
        one.getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), MOVE_RIGHT);
        one.getInputMap(IFW).put(KeyStroke.getKeyStroke("C"), C);
        one.getInputMap(IFW).put(KeyStroke.getKeyStroke("SPACE"), SPACE);
        one.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), S);
        two.getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), MOVE_DOWN);
        two.getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), MOVE_LEFT);
        two.getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), MOVE_RIGHT);
        two.getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), MOVE_UP);
        two.getInputMap(IFW).put(KeyStroke.getKeyStroke("C"), C);
        two.getInputMap(IFW).put(KeyStroke.getKeyStroke("SPACE"), SPACE);
        two.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), S);
        two.getInputMap(IFW).put(KeyStroke.getKeyStroke("R"), R);
        three.getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), MOVE_DOWN);
        three.getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), MOVE_LEFT);
        three.getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), MOVE_RIGHT);
        three.getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), MOVE_UP);
        three.getInputMap(IFW).put(KeyStroke.getKeyStroke("C"), C);
        three.getInputMap(IFW).put(KeyStroke.getKeyStroke("SPACE"), SPACE);
        three.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), S);
        four.getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), MOVE_DOWN);
        four.getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), MOVE_LEFT);
        four.getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), MOVE_RIGHT);
        four.getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), MOVE_UP);
        four.getInputMap(IFW).put(KeyStroke.getKeyStroke("C"), C);
        four.getInputMap(IFW).put(KeyStroke.getKeyStroke("SPACE"), SPACE);
        four.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), S);
      
        
        two.getActionMap().put(MOVE_DOWN, new MoveAction(2, 2));
        two.getActionMap().put(MOVE_UP, new MoveAction(2, 1));
        two.getActionMap().put(MOVE_LEFT, new MoveAction(2, 3));
        two.getActionMap().put(MOVE_RIGHT, new MoveAction(2, 4));
        two.getActionMap().put(C, new MoveAction(2, 5));
        two.getActionMap().put(S, new StartTime(2));
        two.getActionMap().put(R, new game());
        two.getActionMap().put(SPACE, new MoveAction(2, 6));
       
       
        
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(3, 4));
        panel.add(eleven);
        panel.add(five);
        panel.add(one);
        panel.add(six);
        panel.add(twelve);
        panel.add(thirteen);
        panel.add(four);
        panel.add(seven);
        panel.add(three);
        panel.add(fourteen);
        panel.add(ten);
        panel.add(eight);
        panel.add(two);
        panel.add(nine);
        panel.add(fifteen);
        
        
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
    
    
    private class StartTime extends AbstractAction {
    	int panel;
    	StartTime(int a){
    		this.panel = a;
    		
    	}
    	public void actionPerformed(ActionEvent e){
    		one.start();
    		two.start();
    		three.start();
    		four.start();
    		
    	}
    }
    
    private class game extends AbstractAction {
    	game(){
    		
    	}
    	public void actionPerformed(ActionEvent e){
    		Snake3D t = new Snake3D();
    		
    	}
    }
    
    private class MoveAction extends AbstractAction {
    	int incr;
    	int panel;
    	MoveAction(int a, int b){
    		this.incr = b;
    		this.panel = a;
    		
    	}
    	
    	public void actionPerformed(ActionEvent e){
    		if (this.panel == 2 && this.incr == 1){
    			if(one.downDirection == false){
    				one.upDirection = true;
    				one.downDirection = false;
	    			one.leftDirection = false;
	    			one.rightDirection = false;
	    			one.inDirection = false;
	    			one.outDirection = false;
    			}
    			if(two.downDirection == false){
	    			two.upDirection = true;
	    			two.downDirection = false;
	    			two.leftDirection = false;
	    			two.rightDirection = false;
	    			two.inDirection = false;
	    			two.outDirection = false;
    			}
    			if (three.downDirection == false){
	    			three.upDirection = true;
	    			three.downDirection = false;
	    			three.leftDirection = false;
	    			three.rightDirection = false;
	    			three.inDirection = false;
	    			three.outDirection = false;
    			}
    			if(four.downDirection == false){
	    			four.upDirection = true;
	    			four.downDirection = false;
	    			four.leftDirection = false;
	    			four.rightDirection = false;
	    			four.inDirection = false;
	    			four.outDirection = false;
    			}
    			
    		}else if(this.panel == 2 && this.incr == 2){
    			if(one.upDirection == false){ 
	    			one.upDirection = false;
	    			one.downDirection = true;
	    			one.leftDirection = false;
	    			one.rightDirection = false;
	    			one.inDirection = false;
	    			one.outDirection = false;
    			}
    			if(two.upDirection == false){
	    			two.downDirection = true;
	    			two.upDirection = false;
	    			two.leftDirection = false;
	    			two.rightDirection = false;
	    			two.inDirection = false;
	    			two.outDirection = false;
    			}
    			if(three.upDirection == false){
	    			three.downDirection = true;
	    			three.upDirection = false;
	    			three.leftDirection = false;
	    			three.rightDirection = false;
	    			three.inDirection = false;
	    			three.outDirection = false;
    			}
    			if(four.upDirection == false){
	    			four.downDirection = true;
	    			four.upDirection = false;
	    			four.leftDirection = false;
	    			four.rightDirection = false;
	    			four.inDirection = false;
	    			four.outDirection = false;
    			}
    		}else if (this.panel == 2 && this.incr ==3){
    			if(one.rightDirection == false){
	    			one.upDirection = false;
	    			one.downDirection = false;
	    			one.leftDirection = true;
	    			one.rightDirection = false;
	    			one.inDirection = false;
	    			one.outDirection = false;
    			}
    			if(two.rightDirection == false){
	    			two.downDirection = false;
	    			two.upDirection = false;
	    			two.leftDirection = true;
	    			two.rightDirection = false;
	    			two.inDirection = false;
	    			two.outDirection = false;
    			}
    			if(three.rightDirection == false){
	    			three.downDirection = false;
	    			three.upDirection = false;
	    			three.leftDirection = true;
	    			three.rightDirection = false;
	    			three.inDirection = false;
	    			three.outDirection = false;
    			}
    			if(four.rightDirection == false){
	    			four.downDirection = false;
	    			four.upDirection = false;
	    			four.leftDirection = true;
	    			four.rightDirection = false;
	    			four.inDirection = false;
	    			four.outDirection = false;
    			}
    		}else if (this.panel == 2 && this.incr == 4){
    			if (one.leftDirection == false){
	    			one.upDirection = false;
	    			one.downDirection = false;
	    			one.leftDirection = false;
	    			one.rightDirection = true;
	    			one.inDirection = false;
	    			one.outDirection = false;
    			}
    			if(two.leftDirection ==false){
	    			two.downDirection = false;
	    			two.upDirection = false;
	    			two.leftDirection = false;
	    			two.rightDirection = true;
	    			two.inDirection = false;
	    			two.outDirection = false;
    			}
    			if(three.leftDirection == false){
	    			three.downDirection = false;
	    			three.upDirection = false;
	    			three.leftDirection = false;
	    			three.rightDirection = true;
	    			three.inDirection = false;
	    			three.outDirection = false;
    			}
    			if(four.leftDirection == false){
	    			four.downDirection = false;
	    			four.upDirection = false;
	    			four.leftDirection = false;
	    			four.rightDirection = true;
	    			four.inDirection = false;
	    			four.outDirection = false;
    			}
    		}else if (this.panel == 2 && this.incr == 5){
    			if(one.outDirection ==  false){
	    			one.upDirection = false;
	    			one.downDirection = false;
	    			one.leftDirection = false;
	    			one.rightDirection = false;
	    			one.inDirection = true;
	    			one.outDirection = false;
    			}
    			if(two.outDirection == false){
	    			two.inDirection = true;
	    			two.outDirection = false;
	    			two.downDirection = false;
	    			two.upDirection = false;
	    			two.leftDirection = false;
	    			two.rightDirection = false;
    			}	
    			if(three.outDirection == false){
	    			three.inDirection = true;
	    			three.outDirection = false;
	    			three.downDirection = false;
	    			three.upDirection = false;
	    			three.leftDirection = false;
	    			three.rightDirection = false;
    			}
    			if(four.outDirection ==false){
	    			four.inDirection = true;
	    			four.outDirection = false;
	    			four.downDirection = false;
	    			four.upDirection = false;
	    			four.leftDirection = false;
	    			four.rightDirection = false;
    			}
    		}else if (this.panel == 2 && this.incr == 6){
    			if(one.inDirection == false){
	    			one.upDirection = false;
	    			one.downDirection = false;
	    			one.leftDirection = false;
	    			one.rightDirection = false;
	    			one.inDirection = false;
	    			one.outDirection = true;
    			}
    			if(two.inDirection == false){
	    			two.inDirection = false;
	    			two.outDirection = true;
	    			two.downDirection = false;
	    			two.upDirection = false;
	    			two.leftDirection = false;
	    			two.rightDirection = false;
    			}
    			if(three.inDirection == false){
	    			three.inDirection = false;
	    			three.outDirection = true;
	    			three.downDirection = false;
	    			three.upDirection = false;
	    			three.leftDirection = false;
	    			three.rightDirection = false;
    			}
    			if(four.inDirection == false){
	    			four.inDirection = false;
	    			four.outDirection = true;
	    			four.downDirection = false;
	    			four.upDirection = false;
	    			four.leftDirection = false;
	    			four.rightDirection = false;
    			}
    		}
    	}
    }
    public static class Empty extends JPanel {

        private final int B_WIDTH = 360;
        private final int B_DEPTH = 360;
        private final int B_HEIGHT = 360;

        public Empty() {
            
            this.setLayout(new GridLayout());
            setBackground(Color.black);
            setFocusable(true);
            setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
            this.setVisible(true);
        }
    }
    
    public static class EmptyToo extends JPanel {

        
        private final int B_WIDTH = 360;
        private final int B_DEPTH = 360;
        private final int B_HEIGHT = 360;

        public EmptyToo() {
            
            this.setLayout(new GridLayout());
            setBackground(Color.black);
            setFocusable(true);

            setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        }

    }  
    public static class Apple{
    	private final int RAND_POS = 30;
        private final int DOT_SIZE = 10;
        private final int B_WIDTH = 333;
        private int a;
        private int apple_x;
        private int apple_y;
        private int apple_z;
        private boolean check;
        private int dots;
    	public Apple(){
    		dots = 1;   
    	}
    	private void locateApple(int x) {
    		
            int r = (int) (Math.random() * RAND_POS);
            apple_x = ((r * DOT_SIZE));

            r = (int) (Math.random() * RAND_POS);
            apple_y = ((r * DOT_SIZE));
            
            r = (int) (Math.random() * RAND_POS);
            apple_z = ((r * DOT_SIZE));
            
            
        }
    	public int getDots(){
    		return dots;
    	}
    	
    	public boolean checkApple(int x, int y, int z){
    		check = false;
    		if ((java.lang.Math.abs(x - apple_x()) < 20) && (java.lang.Math.abs(y - apple_y()) < 20) && (java.lang.Math.abs(z - apple_z()) < 20)) {
    			dots++;
    			check = true;
            }
    		return check;
    	}
    	
    	
    	public int apple_x(){
    		return apple_x;
    	}
    	public int apple_y(){
    		return apple_y;
    	}
    	public int apple_z(){
    		return apple_z;
    	}
    	
    }
    public static class MyPanel extends JPanel implements ActionListener {
        private final int B_WIDTH = 360;
        private final int B_HEIGHT = 360;
        private final int B_DEPTH = 360;
        
        private final int DOT_SIZE = 10;
        private final int ALL_DOTS = 360;
        private final int RAND_POS = 20;
        private final int DELAY = 300;

        private final int x[] = new int[ALL_DOTS];
        private final int y[] = new int[ALL_DOTS];
        private final int z[] = new int[ALL_DOTS];

        private int dots;
        private Apple newApple;

        public boolean leftDirection = false;
        public boolean rightDirection = true;
        public boolean upDirection = false;
        public boolean downDirection = false;
        public boolean inDirection = false;
        public boolean outDirection = false;
        public boolean inGame = true;

        private Timer timer;
        private Image ball;
        private Image apple;
        private Image head;

        public MyPanel(Apple apple) {
        	newApple = apple;
            this.setLayout(new GridLayout());
            this.setFocusable(true);
            addKeyListener(new TAdapter());
            setBackground(Color.black);
            setFocusable(true);

            setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
            loadImages();
        }

        public boolean inGame(){
        	return inGame;
        }

    private void loadImages() {

        ImageIcon iid = new ImageIcon("dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("head.png");
        head = iih.getImage();
    }

    private void start() {

        dots = newApple.getDots();

        for (int a = 0; a < dots; a++) {
            x[a] = 175;
            y[a] = 175;
            z[a] = 175;
        }

        newApple.locateApple(1);

        timer = new Timer(DELAY, this);
        timer.start();
    }

     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (inGame) {

            g.drawImage(apple, newApple.apple_x(), newApple.apple_y(), this);

            for (int a = 0; a < dots; a++) {
                if (a == 0) {
                	if(!(x[a] == newApple.apple_x() && y[a] == newApple.apple_y())){
                		g.drawImage(head, x[a], y[a], this);
                	}else if ((x[a] == newApple.apple_x() || y[a] == newApple.apple_y()) && z[a] <= newApple.apple_z()){
                		g.drawImage(head, x[a], y[a], this);
                	}
                } 
                else {
                	if(!(x[a] == newApple.apple_x() && y[a] == newApple.apple_y())){
                		g.drawImage(ball, x[a], y[a], this);
                	}else if (x[a] == newApple.apple_x() || y[a] == newApple.apple_y() && z[a] <= newApple.apple_z()){
                		g.drawImage(ball, x[a], y[a], this);
                	}
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }        
    }

    private void gameOver(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }

    private void checkApple() {
    	if (newApple.checkApple(x[0], y[0], z[0])) {
    		dots = newApple.getDots();
            newApple.locateApple(1);
    	}
    }

    private void move() {

        for (int a = dots; a > 0; a--) {
            x[a] = x[(a - 1)];
            y[a] = y[(a - 1)];
            z[a] = z[(a - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        } 

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
        if (inDirection) {
        	z[0] += DOT_SIZE;
        }
        if (outDirection) {
        	z[0] -= DOT_SIZE;
        }
       
    }

    private void checkCollision() {

        for (int a = dots; a > 0; a--) {

            if ((a > 4) && (x[0] == x[a]) && (y[0] == y[a]) && (z[0] == z[a])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }
        
        if (z[0] >= B_DEPTH){
        	inGame = false;
        }
        
        if(z[0] < 0){
        	inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
        
        if(!inGame) {
            timer.stop();
        }
    }

    
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }

    public class TAdapter extends KeyAdapter {

        
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
                inDirection = false;
                outDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
                inDirection = false;
                outDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
                inDirection = false;
                outDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
                inDirection = false;
                outDirection = false;
            }
            if ((key == KeyEvent.VK_C && (!outDirection))) {
                downDirection = false;
                rightDirection = false;
                leftDirection = false;
                inDirection = true;
                upDirection = false;
            }
            if ((key == KeyEvent.VK_SPACE && (!inDirection))) {
                downDirection = false;
                rightDirection = false;
                leftDirection = false;
                upDirection = false;
                outDirection = true;
            }
            
        }
    }

    }
    public static class MyPanel2 extends JPanel implements ActionListener {

        
        private final int B_WIDTH = 360;
        private final int B_DEPTH = 360;
        private final int B_HEIGHT = 360;
        private final int DOT_SIZE = 10;
        private final int ALL_DOTS = 360;
        private final int RAND_POS = 20;
        private final int DELAY = 300;

        private final int x[] = new int[ALL_DOTS];
        private final int y[] = new int[ALL_DOTS];
        private final int z[] = new int[ALL_DOTS];

        private int dots;
        private Apple newApple;

        private boolean leftDirection = false;
        private boolean rightDirection = true;
        private boolean upDirection = false;
        private boolean downDirection = false;
        private boolean inDirection = false;
        private boolean outDirection = false;
        
        private boolean inGame = true;

        private Timer timer;
        private Image ball;
        private Image apple;
        private Image head;

        public MyPanel2(Apple apple) {
            this.newApple = apple;
            this.setLayout(new GridLayout());
            this.setFocusable(true);
            addKeyListener(new TAdapter2());
            setBackground(Color.black);
            setFocusable(true);

            setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
            loadImages();
            
        }
        
       

    private void loadImages() {

        ImageIcon iid = new ImageIcon("dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("head.png");
        head = iih.getImage();
    }

    private void start() {

        dots = newApple.getDots();

        for (int a = 0; a < dots; a++) {
            x[a] = 175;
            y[a] = 175;
            z[a] = 175;
            
        }

        newApple.locateApple(2);
        timer = new Timer(DELAY, this);
        timer.start();
        
    }

     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (inGame) {

            g.drawImage(apple, newApple.apple_x, B_WIDTH - newApple.apple_y, this);

            for (int a = 0; a < dots; a++) {
                if (a == 0) {
                	g.drawImage(head, x[a], y[a], this);
                	
                } 
                else {
                	g.drawImage(ball, x[a], y[a], this);
                	
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }        
    }

    private void gameOver(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }

    private void checkApple() {

    	if (newApple.checkApple(x[0], y[0], z[0])) {
            newApple.locateApple(2);
    	}
    	dots = newApple.getDots();
    }

    private void move() {

        for (int a = dots; a > 0; a--) {
            x[a] = x[(a - 1)];
            y[a] = y[(a - 1)];
            z[a] = z[(a - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] += DOT_SIZE;
        }

        if (downDirection) {
            y[0] -= DOT_SIZE;
        }
        
        if (inDirection) {
            z[0] -= DOT_SIZE;
        }
        if (outDirection) {
            z[0] += DOT_SIZE;
        }
    }

    private void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }
        if (z[0] >= B_DEPTH){
        	inGame = false;
        }
        
        if(z[0] < 0){
        	inGame = false;
        }
        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
        
        if(!inGame) {
            timer.stop();
        }
    }

   

    
    public void actionPerformed(ActionEvent a) {

        if (inGame) {

            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }
    public class TAdapter2 extends KeyAdapter {

        
        public void keyPressed(KeyEvent a) {

            int key = a.getKeyCode();
           

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
                inDirection = false;
                outDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
                inDirection = false;
                outDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
                inDirection = false;
                outDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
                inDirection = false;
                outDirection = false;
            }
            if ((key == KeyEvent.VK_C) && (!outDirection)) {
                downDirection = false;
                rightDirection = false;
                leftDirection = false;
                inDirection = true;
                upDirection = false;
                
            }
            if ((key == KeyEvent.VK_SPACE) && (!inDirection)) {
                leftDirection = false;
                rightDirection = false;
                leftDirection = false;
                inDirection = false;
                outDirection = true;
            }
        }
    }
  

    }
    
    public static class MyPanel3 extends JPanel implements ActionListener {

        private final int B_WIDTH = 360;
        private final int B_DEPTH = 360;
        private final int B_HEIGHT = 360;
        private final int DOT_SIZE = 10;
        private final int ALL_DOTS = 360;
        private final int RAND_POS = 20;
        private final int DELAY = 300;

        private final int x[] = new int[ALL_DOTS];
        private final int y[] = new int[ALL_DOTS];
        private final int z[] = new int[ALL_DOTS];

        private int dots;
        private Apple newApple;

        private boolean leftDirection = false;
        private boolean rightDirection = true;
        private boolean upDirection = false;
        private boolean downDirection = false;
        private boolean inDirection = false;
        private boolean outDirection = false;
        
        private boolean inGame = true;

        private Timer timer;
        private Image ball;
        private Image apple;
        private Image head;

        public MyPanel3(Apple apple) {
            this.newApple = apple;
            this.setLayout(new GridLayout());
            this.setFocusable(true);
            addKeyListener(new TAdapter3());
            setBackground(Color.black);
            setFocusable(true);

            setPreferredSize(new Dimension(B_HEIGHT, B_HEIGHT));
            loadImages();
        }
        
       

    private void loadImages() {

        ImageIcon iid = new ImageIcon("dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("head.png");
        head = iih.getImage();
    }

    private void start() {

        dots = newApple.getDots();

        for (int a = 0; a < dots; a++) {
            x[a] = 175;
            y[a] = 175;
            z[a] = 175;
            
        }

        newApple.locateApple(3);

        timer = new Timer(DELAY, this);
        timer.start();
    }

     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (inGame) {

            g.drawImage(apple, B_WIDTH - newApple.apple_y, newApple.apple_z, this);

            for (int a = 0; a < dots; a++) {
                if (a == 0) {
                	if(!(y[a] == newApple.apple_y() || z[a] == newApple.apple_z())){
                		g.drawImage(head, y[a], z[a], this);
                	}else if (y[a] == newApple.apple_x() && z[a] == newApple.apple_y() && x[a] > newApple.apple_z()){
                		g.drawImage(head, y[a], z[a], this);
                	}
                } 
                else {
                	if(!(y[a] == newApple.apple_x() || z[a] == newApple.apple_y())){
                		g.drawImage(ball, y[a], z[a], this);
                	}else if (y[a] == newApple.apple_x() && z[a] == newApple.apple_y() && x[a] > newApple.apple_z()){
                		g.drawImage(ball, y[a], z[a], this);
                	}
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }        
    }

    private void gameOver(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }

    private void checkApple() {

    	if (newApple.checkApple(x[0], y[0], z[0])) {
            newApple.locateApple(3);
    	}
    	dots = newApple.getDots();
    }

    private void move() {

        for (int a = dots; a > 0; a--) {
            x[a] = x[(a - 1)];
            y[a] = y[(a - 1)];
            z[a] = z[(a - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] += DOT_SIZE;
        }

        if (downDirection) {
            y[0] -= DOT_SIZE;
        }
        
        if (inDirection) {
            z[0] += DOT_SIZE;
        }

        if (outDirection) {
            z[0] -= DOT_SIZE;
        }
    }

    private void checkCollision() {

        for (int a = dots; a > 0; a--) {

            if ((a > 4) && (x[0] == x[a]) && (y[0] == y[a]) && (z[0] == z[a])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }
        if (z[0] >= B_DEPTH){
        	inGame = false;
        }
        
        if(z[0] < 0){
        	inGame = false;
        }
        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
        
        if(!inGame) {
            timer.stop();
        }
    }

   

    
    public void actionPerformed(ActionEvent a) {

        if (inGame) {

            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }
    public class TAdapter3 extends KeyAdapter {

        
        public void keyPressed(KeyEvent a) {

            int key = a.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
                inDirection = false;
                outDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
                inDirection = false;
                outDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
                inDirection = false;
                outDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
                inDirection = false;
                outDirection = false;
            }
            if ((key == KeyEvent.VK_C) && (!outDirection)) {
                upDirection = false;
                rightDirection = false;
                leftDirection = false;
                inDirection = true;
                downDirection = false;
                
            }
            if ((key == KeyEvent.VK_SPACE) && (!inDirection)) {
                upDirection = false;
                rightDirection = false;
                leftDirection = false;
                downDirection = false;
                outDirection = true;
            }
        }
    }
  

    }
    public static class MyPanel4 extends JPanel implements ActionListener {
        private final int B_WIDTH = 360;
        private final int B_DEPTH = 360;
        private final int B_HEIGHT = 360;
        private final int DOT_SIZE = 10;
        private final int ALL_DOTS = 360;
        private final int RAND_POS = 33;
        private final int DELAY = 300;

        private final int x[] = new int[ALL_DOTS];
        private final int y[] = new int[ALL_DOTS];
        private final int z[] = new int[ALL_DOTS];

        private int dots;
        private Apple newApple;

        private boolean leftDirection = false;
        private boolean rightDirection = true;
        private boolean upDirection = false;
        private boolean downDirection = false;
        private boolean inDirection = false;
        private boolean outDirection = false;
        
        private boolean inGame = true;

        private Timer timer;
        private Image ball;
        private Image apple;
        private Image head;

        public MyPanel4(Apple apple) {
            this.newApple = apple;
            this.setLayout(new GridLayout());
            this.setFocusable(true);
            addKeyListener(new TAdapter4());
            setBackground(Color.black);
            setFocusable(true);

            setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
            loadImages();
        }
        

    private void loadImages() {

        ImageIcon iid = new ImageIcon("dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("head.png");
        head = iih.getImage();
    }

    private void start() {

        dots = newApple.getDots();

        for (int a = 0; a < dots; a++) {
            x[a] = 175;
            y[a] = 175;
            z[a] = 175;
            
        }

        newApple.locateApple(4);

        timer = new Timer(DELAY, this);
        timer.start();
    }

     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (inGame) {

            g.drawImage(apple, newApple.apple_y, newApple.apple_z, this);

            for (int a = 0; a < dots; a++) {
                if (a == 0) {
                	if(!(y[a] == newApple.apple_y() || z[a] == newApple.apple_z())){
                		g.drawImage(head, y[a], z[a], this);
                	}else if (y[a] == newApple.apple_x() && z[a] == newApple.apple_y() && x[a] <= newApple.apple_z()){
                		g.drawImage(head, y[a], z[a], this);
                	}
                } 
                else {
                	if(!(y[a] == newApple.apple_x() || z[a] == newApple.apple_y())){
                		g.drawImage(ball, y[a], z[a], this);
                	}else if (y[a] == newApple.apple_x() && z[a] == newApple.apple_y() && x[a] <= newApple.apple_z()){
                		g.drawImage(ball, y[a], z[a], this);
                	}
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }        
    }

    private void gameOver(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }

    private void checkApple() {

    	if (newApple.checkApple(x[0], y[0], z[0])) {
            newApple.locateApple(4);
    	}
    	dots = newApple.getDots();
    }

    private void move() {

        for (int a = dots; a > 0; a--) {
            x[a] = x[(a - 1)];
            y[a] = y[(a - 1)];
            z[a] = z[(a - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
        
        if (inDirection) {
            z[0] += DOT_SIZE;
        }
        if (outDirection) {
            z[0] -= DOT_SIZE;
        }
    }

    private void checkCollision() {

        for (int a = dots; a > 0; a--) {

            if ((a > 4) && (x[0] == x[a]) && (y[0] == y[a]) && (z[0] == z[a])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }
        if (z[0] >= B_DEPTH){
        	inGame = false;
        }
        
        if(z[0] < 0){
        	inGame = false;
        }
        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
        
        if(!inGame) {
            timer.stop();
        }
    }

   

    
    public void actionPerformed(ActionEvent a) {

        if (inGame) {

            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }
    public class TAdapter4 extends KeyAdapter {

        
        public void keyPressed(KeyEvent a) {

            int key = a.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
                inDirection = false;
                outDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
                inDirection = false;
                outDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
                inDirection = false;
                outDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
                inDirection = false;
                outDirection = false;
            }
            if ((key == KeyEvent.VK_C) && (!outDirection)) {
                downDirection = false;
                rightDirection = false;
                leftDirection = false;
                inDirection = true;
                upDirection = false;
                
            }
            if ((key == KeyEvent.VK_SPACE) && (!inDirection)) {
                downDirection = false;
                rightDirection = false;
                leftDirection = false;
                outDirection = true;
                upDirection = false;
            }
        }
    }
    
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            
            public void run() {
                Snake3D t = new Snake3D();	
                }
            
        });
    }
}