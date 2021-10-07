import javax.swing.*;

import java.awt.Insets;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AnagramApp extends JFrame {

	// Variables used by the GUI
	private JTextField userText;
	private JTextArea results;
	private JButton button;
	private JLabel status, report;
	private int resultCount = 0;
	private JComboBox<String> minLengthInput, maxWordsInput;

	// Variables your recursive function should access as part
	//  of its solving for anagrams
	private Lexicon lexicon;
	private int minLength, maxWords;
	

	private void helper(ArrayList<String> sofar, String remain) {

		
	}
	
	private void generateAnagrams() {
		// Retrieves the text the user typed
		String inputText = userText.getText();
		// Updates the minLength and maxWords variables
		//  based on what the user selected
		updateConstraints();
		
		System.out.println("Starting anagram generation...");
		System.out.println("  User text: " + inputText);
		System.out.println("  Min word length: " + minLength);
		System.out.println("  Max number of words: " + maxWords);	
		clearResults();
		status.setText("Generating anagrams...");
		
		(new Thread() {
			public void run() {
				// TO DO
				// Add code that does any preparation necessary
				// and then calls the recursive helper() method

				
				
				status.setText("Done.");
				System.out.println("Anagram generation done.");
			}
		}).start();

		
	}
	
	
	private void setupGUI() {
		// Overall layout
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JPanel numPanel1 = new JPanel();
		JPanel numPanel2 = new JPanel();
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 50, 20));
		
		// Basic inputs and labels
		userText = centered(new JTextField("", 15));
		userText.setMaximumSize(userText.getPreferredSize());
		button = centered(new JButton("Generate Anagrams"));
		status = centered(new JLabel(""));
		report = centered(new JLabel(""));
		results = centered(new JTextArea(20, 20));
		JScrollPane scroll=new JScrollPane(results);
		
		// Drop-down menus
		// TO DO
		// Add code and modify the creation of the two
		// JComboBox items so they contain the following choices
		// * The minLengthInput should have the options 1 through 20
		// * The maxWordsInput should have the options "none" followed by 1 through 20
		minLengthInput = new JComboBox<String>();
		maxWordsInput = new JComboBox<String>();
		
		// Button setup
		// TO DO
		// Add an action listener to the button so that
		//  generateAnagrams() is called when the button
		//  is clicked.
		
		// Assembling everything together
		numPanel1.add(new JLabel("Minimum word length: "));
		numPanel1.add(minLengthInput);
		numPanel2.add(new JLabel("Maximum word count: "));
		numPanel2.add(maxWordsInput);
		mainPanel.add(centered(new JLabel("Enter a word or phrase:")));
		mainPanel.add(userText);
		mainPanel.add(numPanel1);
		mainPanel.add(numPanel2);
		mainPanel.add(button);
		mainPanel.add(status);
		mainPanel.add(report);
		bottomPanel.add(scroll);
		mainPanel.add(bottomPanel);
		this.add(mainPanel);
		this.pack();
	}
	
	// Main program - already complete
	public static void main(String[] args) {
		try {
			AnagramApp app = new AnagramApp();
			app.setVisible(true);
		} catch (IOException e) {
			System.out.println("*** Could not start app: " + e.getMessage());
		}
	}
	
	// Constructor - already complete
	public AnagramApp() throws IOException {
		System.out.println("Loading words...");
		lexicon = new Lexicon("words.txt");
		System.out.println("Words loaded.");
		System.out.println();
		setupGUI();
	}
	
	// Helper methods - already complete
	private <T extends JComponent> T centered(T c) {
		c.setAlignmentX(CENTER_ALIGNMENT);
		return c;
	}
	
	private void updateResultCount(int newCount) {
		resultCount = newCount;
		report.setText("Results found: " + resultCount);
	}
	
	private void clearResults() {
		results.setText("");
		updateResultCount(0);
	}
	
	private void updateConstraints() {
		String s;
		if (!(s = (String)minLengthInput.getSelectedItem()).equals("none"))
			minLength = Integer.valueOf(s);
		else
			minLength = 1;
		if (!(s = (String)maxWordsInput.getSelectedItem()).equals("none"))
			maxWords = Integer.valueOf(s);
		else
			maxWords = Integer.MAX_VALUE;
	}
	
	private void addResult(String result) {
		updateResultCount(resultCount + 1);
    	results.append(result + "\n");
	}
	
	
		

}
