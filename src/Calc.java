import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calc extends KeyAdapter implements ActionListener {

    private JFrame mainFrame;
    private JPanel panelOfDisplay;
    private JPanel panelOfButtons;
    private JTextField calculationsFrame;
    private JButton[] intButtons = new JButton[10];
    private JButton[] expButtons = new JButton[8];
    private JButton plusButton, subButton, divButton, mulButton, equalButton, decButton, deleteButton, clearButton;
    Double num1, num2, result;
    char operator;
    private Font font;


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            String s = calculationsFrame.getText();
            calculationsFrame.setText("");
            for (int i = 0; i < s.length()-1; i++) {
                calculationsFrame.setText(calculationsFrame.getText() + s.charAt(i));
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == intButtons[i]) {
                calculationsFrame.setText(calculationsFrame.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            calculationsFrame.setText(calculationsFrame.getText().concat("."));
        }
        if (e.getSource() == plusButton) {
            num1 = Double.parseDouble(calculationsFrame.getText());
            operator = '+';
            calculationsFrame.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(calculationsFrame.getText());
            operator = '-';
            calculationsFrame.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(calculationsFrame.getText());
            operator = '/';
            calculationsFrame.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(calculationsFrame.getText());
            operator = '✕';
            calculationsFrame.setText("");
        }
        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(calculationsFrame.getText());
            switch (operator) {
                case '/':
                    result = num1 / num2;
                    break;
                case '✕':
                    result = num1 * num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '+':
                    result = num1 + num2;
                    break;
            }
            calculationsFrame.setText(String.valueOf(result));
        }
        if (e.getSource() == clearButton) {
            calculationsFrame.setText("");
        }
        if (e.getSource() == deleteButton) {
            String s = calculationsFrame.getText();
            calculationsFrame.setText("");
            for (int i = 0; i < s.length()-1; i++) {
                calculationsFrame.setText(calculationsFrame.getText() + s.charAt(i));
            }
        }
    }


    Calc() {

        font = new Font("Verdana", Font.PLAIN, 30);

        mainFrame = new JFrame("Calculator");
        mainFrame.setSize(340, 525);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(true);

        //Инициализация панели где показываются все вычисления
        panelOfDisplay = new JPanel();

        //Создание поля ввода на panelOfDisplay
        calculationsFrame = new JTextField();
        calculationsFrame.setLayout(new GridLayout());
        calculationsFrame.setPreferredSize(new Dimension(300, 100));
        calculationsFrame.setFont(font);
        panelOfDisplay.add(calculationsFrame);

        //Инициализация панели где показываются кнопки с операциями
        panelOfButtons = new JPanel();
        panelOfButtons.setLayout(new GridLayout(5,4));
        plusButton = new JButton("+");
        subButton = new JButton("-");
        divButton = new JButton("/");
        mulButton = new JButton("✕");
        equalButton = new JButton("=");
        decButton = new JButton(".");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        expButtons[0] = plusButton;
        expButtons[1] = subButton;
        expButtons[2] = divButton;
        expButtons[3] = mulButton;
        expButtons[4] = equalButton;
        expButtons[5] = decButton;
        expButtons[6] = deleteButton;
        expButtons[7] = clearButton;
        for (JButton expButton : expButtons) {
            expButton.addActionListener(this);
            expButton.setFocusable(false);
        }
        for (JButton button : expButtons) {
            panelOfButtons.add(button);
        }

        //Инициализация кнопок с цифрами
        for (int i = 0; i < intButtons.length; i++) {
            intButtons[i] = new JButton("" + i);
            intButtons[i].addActionListener(this);
            intButtons[i].setFocusable(false);
            panelOfButtons.add(intButtons[i]);
        }

        mainFrame.add(panelOfDisplay, BorderLayout.NORTH);
        mainFrame.add(panelOfButtons, BorderLayout.CENTER);;
        panelOfButtons.setBackground(Color.DARK_GRAY);
        calculationsFrame.setForeground(Color.BLUE);
        mainFrame.setVisible(true);
    }
    public static void main(String[] args) {
        Calc f = new Calc();
    }
}

