import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();

        //Basic Application Structure
        gui.setVisible(true);
        gui.setResizable(false);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.revalidate();
        gui.repaint();

    }
}
class GUI extends JFrame implements ActionListener {
    JLabel slotMachine = new JLabel("Slot Machine");
    Font font = new Font("Arial", Font.PLAIN, 20);
    private final JTextField startRangeText = new JTextField();
    private final JTextField endRangeText = new JTextField();
    private final JTextField randomNumberText = new JTextField();
    private final JButton spin = new JButton("SPIN!");

    public GUI() {

        super("Slot Machine");
        setSize(290, 320);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        //Heading
        slotMachine.setBounds(75, 0, 130, 40);
        slotMachine.setFont(font);
        panel.add(slotMachine);

        //Start Range
        JLabel startRange = new JLabel("Start Range:");
        startRange.setBounds(20, 80, 90, 18);
        panel.add(startRange);

        startRangeText.setBounds(140, 80, 110, 25);
        panel.add(startRangeText);

        //End Range
        JLabel endRange = new JLabel("End Range: ");
        endRange.setBounds(20, 120, 90, 18);
        panel.add(endRange);

        endRangeText.setBounds(140, 120, 110, 25);
        panel.add(endRangeText);

        //Random Number
        JLabel randomNumber = new JLabel("Random Number:");
        randomNumber.setBounds(20, 160, 99, 18);
        panel.add(randomNumber);

        randomNumberText.setBounds(140, 160, 110, 25);
        panel.add(randomNumberText);

        spin.setBounds(20, 210, 90, 25);
        panel.add(spin);

        spin.addActionListener(this);
        numericValuesOnly();

        add(panel);
    }
    public void numericValuesOnly() {
        startRangeText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                    startRangeText.setEnabled(true);
                } else {
                    startRangeText.setEnabled(false);
                    int confirm = JOptionPane.showConfirmDialog(null,
                            """
                                    Please enter a numeric value.
                                    Click "Yes" to  re-enter a value.
                                    Click "No" to proceed without entering a new value
                                    Click "Cancel" to terminate application""");
                    if (confirm == JOptionPane.YES_OPTION) {
                        startRangeText.setEnabled(true);
                    } else if (confirm == JOptionPane.NO_OPTION) {
                        startRangeText.setEnabled(false);
                    } else {
                        System.exit(0);
                    }
                }
            }
        });
        endRangeText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                    endRangeText.setEnabled(true);
                } else {
                    endRangeText.setEnabled(false);
                    int confirm = JOptionPane.showConfirmDialog(null,
                            """
                                    Please enter a numeric value.
                                    Click "Yes" to  re-enter a value.
                                    Click "No" to proceed without entering a new value
                                    Click "Cancel" to terminate application""");
                    if (confirm == JOptionPane.YES_OPTION) {
                        endRangeText.setEnabled(true);
                    } else {
                        System.exit(0);
                    }
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        Random random = new Random();
        int startRange = Integer.parseInt(startRangeText.getText());
        int endRange = Integer.parseInt(endRangeText.getText());

        if (source == spin) {
            int numberOfRandomNumbers = Integer.parseInt(randomNumberText.getText());
            for (int i = 0; i < numberOfRandomNumbers; i++) {
                int randomNumber = random.nextInt(endRange - startRange + 1) + startRange;
                JOptionPane.showMessageDialog(null, randomNumber, "Random Number", JOptionPane.QUESTION_MESSAGE);
            }
        }
    }
}