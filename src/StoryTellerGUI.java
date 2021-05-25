package texttospeech;

import java.io.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.event.*;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class StoryTellerGUI {

	private JFrame frmStoryteller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoryTellerGUI window = new StoryTellerGUI();
					window.frmStoryteller.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StoryTellerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStoryteller = new JFrame();
		frmStoryteller.setTitle("StoryTeller");
		frmStoryteller.setBounds(100, 100, 521, 453);
		frmStoryteller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStoryteller.getContentPane().setLayout(null);
		
		JTextPane txtpane = new JTextPane();
		txtpane.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtpane.setText("You can write in this text field to convert to speech or select one of the stories.");
		txtpane.setBounds(10, 200, 480, 164);
		frmStoryteller.getContentPane().add(txtpane);
		
		JButton story_button2 = new JButton("The Fox & the grapes");
		story_button2.setBackground(new Color(220, 220, 220));
		story_button2.setFont(new Font("Rockwell", Font.PLAIN, 18));
		story_button2.setBounds(268, 11, 222, 48);
		frmStoryteller.getContentPane().add(story_button2);
		story_button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String story = get_story(2);
				txtpane.setText(story);
		
			}
		});
		
		JButton story_button4 = new JButton("The Quack Toad");
		story_button4.setBackground(new Color(220, 220, 220));
		story_button4.setFont(new Font("Rockwell", Font.PLAIN, 18));
		story_button4.setBounds(268, 70, 222, 48);
		frmStoryteller.getContentPane().add(story_button4);
		story_button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String story = get_story(4);
				txtpane.setText(story);
		
			}
		});
		
		JButton story_button3 = new JButton("The Plane Tree");
		story_button3.setBackground(new Color(220, 220, 220));
		story_button3.setFont(new Font("Rockwell", Font.PLAIN, 18));
		story_button3.setBounds(10, 70, 222, 48);
		frmStoryteller.getContentPane().add(story_button3);
		story_button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String story = get_story(3);
				txtpane.setText(story);
		
			}
		});
		
		JButton read_btn = new JButton("Read");
		read_btn.setBackground(new Color(220, 220, 220));
		read_btn.setFont(new Font("Rockwell", Font.PLAIN, 18));
		read_btn.setBounds(173, 375, 139, 23);
		frmStoryteller.getContentPane().add(read_btn);
		
		JButton story_button5 = new JButton("The Cat & the Fox");
		story_button5.setFont(new Font("Rockwell", Font.PLAIN, 18));
		story_button5.setBackground(new Color(220, 220, 220));
		story_button5.setBounds(10, 129, 222, 48);
		frmStoryteller.getContentPane().add(story_button5);
		story_button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String story = get_story(5);
				txtpane.setText(story);
		
			}
		});
		
		JButton story_button6 = new JButton("The Old Lion");
		story_button6.setFont(new Font("Rockwell", Font.PLAIN, 18));
		story_button6.setBackground(new Color(220, 220, 220));
		story_button6.setBounds(268, 129, 222, 48);
		frmStoryteller.getContentPane().add(story_button6);
		story_button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String story = get_story(6);
				txtpane.setText(story);
		
			}
		});
		
		JButton story_button1 = new JButton("Belling The Cat");
		story_button1.setFont(new Font("Rockwell", Font.PLAIN, 18));
		story_button1.setBackground(new Color(220, 220, 220));
		story_button1.setBounds(10, 11, 222, 48);
		frmStoryteller.getContentPane().add(story_button1);
		story_button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String story = get_story(1);
				txtpane.setText(story);
		
			}
		});
		final String VOICENAME="kevin";
		read_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Voice voice;
				System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
				voice=VoiceManager.getInstance().getVoice(VOICENAME);
				if(voice != null) {
					voice.allocate();
				}
				try {
					voice.setRate(120);
					voice.setPitch(100);
					voice.speak(txtpane.getText());
				}catch(Exception e) {
			}
			}
		});
		
	}
	
	public String get_story(int story_number) {
		
		String story = "";
		String file = "Stories\\";
		
		switch(story_number){
		case 1:
			file = file+"story1.txt";
			break;
		case 2:
			file = file+"story2.txt";
			break;
		}
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			StringBuilder stringBuilder = new StringBuilder();
			String line = null;
			String ls = System.getProperty("line.separator");
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
			reader.close();
			story = stringBuilder.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return story;
	}

}
