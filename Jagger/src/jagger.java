import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.sound.sampled.*;
import java.net.URL;

public class jagger extends JFrame {

	/**
	 * CS4 Chardy C. Fernando 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel image_jagger, image_jiggy;
	
	//Jagger Guitar Sounds
	private final URL sound0 = getClass().getClassLoader().getResource("sound/guitar/q.wav");
	private final URL sound1 = getClass().getClassLoader().getResource("sound/guitar/w.wav");
	private final URL sound2 = getClass().getClassLoader().getResource("sound/guitar/e.wav");
	private final URL sound3 = getClass().getClassLoader().getResource("sound/guitar/a.wav");
	private final URL sound4 = getClass().getClassLoader().getResource("sound/guitar/s.wav");
	
	
	//Jiggy Drum Sounds
	private final URL highhat = getClass().getClassLoader().getResource("sound/drum/hh.wav");
	private final URL kick = getClass().getClassLoader().getResource("sound/drum/kick.wav");
	private final URL snare = getClass().getClassLoader().getResource("sound/drum/snare.wav");
	private final URL ride = getClass().getClassLoader().getResource("sound/drum/ride.wav");
	private final URL tom = getClass().getClassLoader().getResource("sound/drum/tom2.wav");
	private final URL floortom = getClass().getClassLoader().getResource("sound/drum/floortom.wav");
	
    public void playSound(URL soundFile){
      try 
      {
       AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
       Clip clip = AudioSystem.getClip();
       clip.open(audioInputStream);
       clip.start();
      }
      catch(Exception ex)
      {
        System.out.println("Error with playing sound.");
        ex.printStackTrace( );
      }
    }
    
    
	public void iconchange(int duration,String jagger) {
		//image_jagger.setIcon(new ImageIcon("res/img/jagger/"+jagger+".png"));
		image_jagger.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/jagger/"+jagger+".png")));
   	 	Timer  labelTimer = new javax.swing.Timer(duration, updateLabel2());
   	 	labelTimer.setRepeats(false);
        labelTimer.start();
	}
	
	public void iconchange_jiggy(int duration,String jiggy) {
		//image_jiggy.setIcon(new ImageIcon("res/img/jiggy/"+jiggy+".png"));
		image_jiggy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/jiggy/"+jiggy+".png")));
   	 	Timer  labelTimer = new javax.swing.Timer(duration, updateLabel3());
   	 	labelTimer.setRepeats(false);
        labelTimer.start();
	}
	
	
	private Action updateLabel2() {
        return new AbstractAction("Label action") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
            	//image_jagger.setIcon(new ImageIcon("res/img/jagger/jagger1.png"));
            	image_jagger.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/jagger/jagger1.png")));
           	 	
            }
        };
    }
	
	private Action updateLabel3() {
        return new AbstractAction("Label action") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
            	//image_jiggy.setIcon(new ImageIcon("res/img/jiggy/jiggy1.png"));
            	image_jiggy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/jiggy/jiggy1.png")));
           	 	
            }
        };
    }
    
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jagger frame = new jagger();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the app
	 */
	public jagger() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(jagger.class.getResource("icon.png")));
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1173, 739);
		setTitle("Scratchbeat"); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 0, 1159, 589);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		//Set Image of Jigger as an Icon for a JLabel
		image_jagger = new JLabel("");
		image_jagger.setIcon(new ImageIcon(jagger.class.getResource("/img/jagger/jagger1.png")));
		panel.add(image_jagger);
		
		//Set Image of Jiggy as an Icon for a JLabel
		image_jiggy = new JLabel("");
		image_jiggy.setIcon(new ImageIcon(jagger.class.getResource("/img/jiggy/jiggy1.png")));
		panel.add(image_jiggy);
		

		
		

		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 599, 1159, 118);
		contentPane.add(panel_1);
		
		
		panel_1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Handle key presses within the panel
            	char ch = e.getKeyChar();
                if (ch=='q'){
                	playSound(sound0);  
    				iconchange(300,"jagger2");
                }
                else if (ch=='w'){
                	playSound(sound1);  
    				iconchange(300,"jagger2");
                }
                else if (ch=='e'){
                	playSound(sound2);  
    				iconchange(500,"jagger2");
                }
                else if (ch=='a'){
                	playSound(sound3);  
    				iconchange(300,"jagger2");
                }
                else if (ch=='s'){
                	playSound(sound4);  
    				iconchange(1200,"jagger3");
                }
                else if (ch=='d'){
                	playSound(sound0);  
    				iconchange(300,"jagger2");
                	playSound(sound1);  
    				iconchange(1200,"jagger2");
    				playSound(sound2);  
    				iconchange(300,"jagger2");
                }
                else if (ch=='u'){
                	
    				playSound(ride);
    				iconchange_jiggy(400,"jiggy3");
    				
                }
                else if (ch=='i'){
                	
    				playSound(tom); 
    				iconchange_jiggy(400,"jiggy5");
                }
                else if (ch=='o'){
                	
    				playSound(tom); 
    				iconchange_jiggy(400,"jiggy4");
                }
                else if (ch=='p'){
                	
    				playSound(highhat); 
    				iconchange_jiggy(400,"jiggy2");
                }
                else if (ch=='j'){
                	
    				playSound(floortom); 
    				iconchange_jiggy(400,"jiggy7");
                }
                else if (ch=='k'){
	
                	playSound(kick); 
                }
                else if (ch=='l'){
	
                	playSound(snare);
                	iconchange_jiggy(400,"jiggy6");
                }
                	
            }
        });
		
		JButton btnNewButton = new JButton("Press (Q)");
		btnNewButton.setBounds(98, 10, 105, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound(sound0);  
				iconchange(300,"jagger2");							
			}
		});
		panel_1.setLayout(null);
		btnNewButton.setFocusable(false);

		
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Press (W)");
		btnNewButton_1.setBounds(221, 10, 105, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound(sound1); 
				iconchange(300,"jagger2");
				
			}
		});
		btnNewButton_1.setFocusable(false);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Press (E)");
		btnNewButton_2.setBounds(344, 10, 105, 21);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound(sound2); 
				iconchange(500,"jagger2");
			}
		});
		btnNewButton_2.setFocusable(false);
		panel_1.add(btnNewButton_2);

		
		
		JButton btnNewButton_2_1 = new JButton("Press (A)");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound(sound3); 
				iconchange(300,"jagger2");
			}
		});
		
		btnNewButton_2_1.setFocusable(false);
		btnNewButton_2_1.setBounds(98, 41, 105, 21);
		panel_1.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Press (S)");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound(sound4); 
				iconchange(1200,"jagger3");
			}
		});
		btnNewButton_2_2.setFocusable(false);
		btnNewButton_2_2.setBounds(221, 41, 105, 21);
		panel_1.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("Press (D)");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound(sound0); 
				iconchange(300,"jagger2");
				
				
			}
		});
		btnNewButton_2_3.setFocusable(false);
		btnNewButton_2_3.setBounds(344, 41, 105, 21);
		panel_1.add(btnNewButton_2_3);
		panel_1.setFocusable(true);
		
		JLabel lblNewLabel = new JLabel("Ride (U)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(703, 14, 53, 28);
		panel_1.add(lblNewLabel);
		
		JLabel lblTomi = new JLabel("Tom 1 (I)");
		lblTomi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTomi.setBounds(775, 14, 68, 28);
		panel_1.add(lblTomi);
		
		JLabel lblTomo = new JLabel("Tom 2 (O)");
		lblTomo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTomo.setBounds(861, 14, 68, 28);
		panel_1.add(lblTomo);
		
		JLabel lblHighHatp = new JLabel("High Hat (P)");
		lblHighHatp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHighHatp.setBounds(942, 14, 68, 28);
		panel_1.add(lblHighHatp);
		
		JLabel lblFloorTomj = new JLabel("Floor Tom (J)");
		lblFloorTomj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFloorTomj.setBounds(754, 55, 89, 28);
		panel_1.add(lblFloorTomj);
		
		JLabel lblKickk = new JLabel("Kick (K)");
		lblKickk.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKickk.setBounds(871, 55, 89, 28);
		panel_1.add(lblKickk);
		
		JLabel lblSnarel = new JLabel("Snare (L)");
		lblSnarel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSnarel.setBounds(952, 55, 89, 28);
		panel_1.add(lblSnarel);
		panel_1.requestFocusInWindow();
		
	}
	}
	


