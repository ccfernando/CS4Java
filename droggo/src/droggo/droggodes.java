package droggo;

import java.io.File;
import java.net.URL;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.sound.sampled.*;

public class droggodes extends MouseAdapter{
	public JLabel lblNewLabel;
	private JFrame frmDruggo;
	Boolean left=false,right=false;
	//URL sound1,image1, image2,image3,image4;
	URL sound0 = getClass().getClassLoader().getResource("sound/bongo0.wav");
	URL sound1 = getClass().getClassLoader().getResource("sound/bongo1.wav");

	/**
	 * Launch the application.
	 */
	
	
    public void playSound(URL soundFile)
    {
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
    
    
    
    
    
    public void play_sound() {
    	
    	if (right == true && left == true) {
    		
    		playSound(sound1);
    		playSound(sound0);
			lblNewLabel.setIcon(new ImageIcon("res/img/doggo4.png"));
			Timer  labelTimer = new javax.swing.Timer(100, updateLabel2());
			labelTimer.setRepeats(false);
	     	labelTimer.start();
	     	//JOptionPane.showMessageDialog(null, left +" "+ right);
    		
    	}
    	
    	else if (left == true ) {
    			playSound(sound0);
		      	lblNewLabel.setIcon(new ImageIcon("res/img/doggo2.png"));
		        Timer  labelTimer = new javax.swing.Timer(100, updateLabel2());
		     	labelTimer.setRepeats(false);
		        labelTimer.start();
		     //   JOptionPane.showMessageDialog(null, left +" "+ right);	
    	}
    	else if (right == true) {
    			playSound(sound1);
    			lblNewLabel.setIcon(new ImageIcon("res/img/doggo3.png"));
    			Timer  labelTimer = new javax.swing.Timer(100, updateLabel2());
    			labelTimer.setRepeats(false);
		     	labelTimer.start();
		     //	JOptionPane.showMessageDialog(null, left +" "+ right);
    	}
    	

    }
    
    
	public static void main(String[] args) {
		  
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					droggodes window = new droggodes();
					window.frmDruggo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public droggodes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmDruggo = new JFrame();
		frmDruggo.setResizable(false);
		frmDruggo.setTitle("Druggo");
		frmDruggo.setBounds(100, 100, 249, 451);
		
		ImageIcon img = new ImageIcon("res/img/doge.png");
		frmDruggo.setIconImage(img.getImage());
		frmDruggo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDruggo.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
	    panel.setBorder(new EmptyBorder(5, 5, 5, 5));	 
		
		panel.addKeyListener(new KeyListener() {
			
			
		      
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
            	char ch = e.getKeyChar();
       	     
                if (ch == 'q' ) {
                		left = false;
                }
                else if (ch =='w') {
                		right = false;
                }
            	
            }

            @Override
            public void keyPressed(KeyEvent event) {
            	  char ch = event.getKeyChar();
            	     
                  if (ch == 'q' ) {
                	  	
                	  left = true;
                   }
                  else if (ch =='w') {
                	  
                	  right = true;

                  }

                  
                  play_sound();
            }
            
           
        });
		
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		
		frmDruggo.getContentPane().add(panel, BorderLayout.CENTER);
		
		lblNewLabel = new JLabel("");
		
		lblNewLabel.setIcon(new ImageIcon("res/img/doggo1.png"));
		
		panel.add(lblNewLabel);
		lblNewLabel.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	lblNewLabel.setIcon(new ImageIcon("res/img/doggo5.png"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	lblNewLabel.setIcon(new ImageIcon("res/img/doggo1.png"));
		    }
		});
	
		JButton btnNewButton = new JButton("Left (Q)");
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent arg0) {
			    	 playSound(sound0);
			        	lblNewLabel.setIcon(new ImageIcon("res/img/doggo2.png"));
			        	 Timer  labelTimer = new javax.swing.Timer(100, updateLabel2());
			        	 labelTimer.setRepeats(false);
			               labelTimer.start();
			           	

			    }
			    });
		
		JButton btnNewButtonR = new JButton("Right (W)");
		panel.add(btnNewButtonR);
		
		btnNewButtonR.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		   	 playSound(sound1);
		        	lblNewLabel.setIcon(new ImageIcon("res/img/doggo3.png"));
		        	 Timer  labelTimer = new javax.swing.Timer(100, updateLabel2());
		        	 labelTimer.setRepeats(false);
		               labelTimer.start();
		    }
		    });
		
		JLabel lblNewLabel_1 = new JLabel("Computer Science 4");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 8));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SY 2020-2021");
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.PLAIN, 8));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ccfernando");
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.ITALIC, 8));
		panel.add(lblNewLabel_3);
		
		
		
	}
	
	
	
   

	private Action updateLabel2() {
        return new AbstractAction("Label action") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
            	lblNewLabel.setIcon(new ImageIcon("res/img/doggo1.png"));
            }
        };
    }



        
        
  
        
    }

