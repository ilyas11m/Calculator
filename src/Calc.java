import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionListener;

public class Calc {
    static class Frame {
        private JFrame mainFrame;
        private JPanel panelCalc;
        private JPanel panelButtons;
        private JTextField calculationsFrame;
        private Font font;
        private JButton button1, button2, button3, button4, button5;

        Frame(){
            mainFrame = new JFrame("Calculator");
            mainFrame.setSize(340, 525);
            mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            mainFrame.setLayout(new BorderLayout());
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setResizable(false);

            panelCalc = new JPanel();
            panelCalc.setPreferredSize(new Dimension(300, 100)); // Устанавливаем большую высоту для панели

            calculationsFrame = new JTextField();
            calculationsFrame.setPreferredSize(new Dimension(300, 100)); // Устанавливаем больший размер текстового поля

            font = new Font("Verdana", Font.ROMAN_BASELINE,30);
            calculationsFrame.setFont(font);

            panelButtons = new JPanel();
            button1 = new JButton("+");
            button1 = new JButton("+");
            button2 = new JButton("-");
            button3 = new JButton("%");
            button4 = new JButton("x");
            button5 = new JButton("=");

            panelCalc.add(calculationsFrame);
            panelButtons.add(button1);
            panelButtons.add(button2);
            panelButtons.add(button3);
            panelButtons.add(button4);
            panelButtons.add(button5);
            mainFrame.add(panelCalc, BorderLayout.NORTH);
            mainFrame.add(panelButtons);
            mainFrame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Frame();
    }
}
