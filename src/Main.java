import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {
	
	JPanel mypanel;
	JTextField input;
	JLabel result;
	JLabel introtext;
	JButton next;
	JButton back;
	JLabel imageLabel;
	ImageIcon image;
	int direction = 0;
	int correctIterator = 0;
	String inputValue;
	
	
	ArrayList<String> images = new ArrayList<String>();
	ArrayList<Integer> correct = new ArrayList<Integer>();

	public static void main(String[] args) {
		Main frame = new Main();
		frame.setTitle("Kleurenblindheidstest");
		frame.setSize(280, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	public Main() {
		images.add("Fotos/Test5.jpg");
		images.add("Fotos/Test8.jpg");
		images.add("Fotos/Test56.jpg");
		images.add("Fotos/Test25.jpg");
		images.add("Fotos/Test29.jpg");
		images.add("Fotos/Test6.jpg");
		images.add("Fotos/Test3.jpg");
		
		correct.add(5);
		correct.add(8);
		correct.add(56);
		correct.add(25);
		correct.add(29);
		correct.add(6);
		correct.add(3);

		image = new ImageIcon(images.get(0).toString());
		input = new JTextField("", 15);
		result = new JLabel();
		introtext = new JLabel("Enter the correct number.");
		next = new JButton("Next");
		back = new JButton("Previous");
		back.addActionListener(this);
		next.addActionListener(this);
		mypanel = new JPanel();
		imageLabel = new JLabel();

		Font bigFont = mypanel.getFont().deriveFont(Font.PLAIN, 15f);
		input.setFont(bigFont);

		FlowLayout experimentLayout = new FlowLayout();
		this.add(mypanel);
		
		imageLabel.setIcon(image);
		mypanel.setLayout(experimentLayout);
		mypanel.add(introtext);
		mypanel.add(imageLabel);
		mypanel.add(input);
		mypanel.add(next);
		mypanel.add(back);
		mypanel.add(result);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == next) {
			inputValue = input.getText();
			System.out.println("Correct answer: " + correct.get(direction));
			System.out.println("Entered answer: " + inputValue);
			System.out.println("----------------------------------------------------");
			if (correct.get(direction).toString().equals(inputValue)) {
				correctIterator++;
			}
				direction++;
				if (direction == images.size()) {
					direction = 0;
					System.out.println(correctIterator + " of 7 correctly entered");
					result.setText(correctIterator	+ " of 7 correctly entered");
					correctIterator = 0;
				}
				if (direction == 1){
					result.setText("");
				}
				image = new ImageIcon(images.get(direction).toString());
				imageLabel.setIcon(image);
		
		}

		else if (event.getSource() == back) {
			if (direction != 0) {
				direction--;
				correctIterator--;
				if(direction == 0){
					correctIterator = 0;
				}
				image = new ImageIcon(images.get(direction).toString());
				imageLabel.setIcon(image);
			} else {
				image = new ImageIcon(images.get(direction).toString());
				imageLabel.setIcon(image);
			}
		}
	}
}
