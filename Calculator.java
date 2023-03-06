import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    JButton[] numberButton = new JButton[10];
    JPanel panel;
    JLabel label = new JLabel();
    JButton[] functionButton = new JButton[10];
    JTextField textField;
    JButton addButton, subButton, divButton, mulButton, negButton, decButton, equButton, delButton, clrButton, cosButton;
    double num1 = 0, num2 = 0, result = 0;
    char opertor;
    Font myfont = new Font("Mv Boli", Font.PLAIN, 20);

    Calculator() {
        this.setTitle("Simple Calculator");
        this.setSize(400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        textField = new JTextField();
        textField.setBounds(25, 30, 330, 40);
        textField.setEditable(false);
        textField.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        textField.setFont(myfont);
        textField.setForeground(Color.BLUE);

        label.setText("calculator");
        label.setHorizontalTextPosition(JLabel.LEFT);
        label.setBounds(25, 5, 130, 20);
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Serif", Font.ITALIC, 17));

        addButton = new JButton("+");
        subButton = new JButton("-");
        divButton = new JButton("/");
        mulButton = new JButton("*");
        negButton = new JButton("(-)");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("delete");
        clrButton = new JButton("clear");
        cosButton = new JButton("cos");

        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = divButton;
        functionButton[3] = mulButton;
        functionButton[4] = negButton;
        functionButton[5] = decButton;
        functionButton[6] = equButton;
        functionButton[7] = delButton;
        functionButton[8] = clrButton;
        functionButton[9] = cosButton;


        for (int i = 0; i < 10; i++) {
            functionButton[i].setFocusable(false);
            functionButton[i].setFont(myfont);
            functionButton[i].addActionListener(this);
            functionButton[i].setFocusable(false);
            functionButton[i].setBorder(BorderFactory.createLineBorder(Color.blue.brighter(), 1, true));
        }
        for (int i = 0; i < 10; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myfont);
            numberButton[i].setFocusable(false);
            numberButton[i].setBorder(BorderFactory.createLineBorder(Color.blue, 1));
        }


        panel = new JPanel();
        panel.setBounds(10, 80, 360, 400);
        panel.setLayout(new GridLayout(4, 4, 3, 3));
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(numberButton[0]);
        panel.add(decButton);
        panel.add(equButton);

        negButton.setBounds(20, 500, 50, 40);
        delButton.setBounds(170, 500, 100, 30);
        clrButton.setBounds(280, 500, 100, 30);
        cosButton.setBounds(80, 500, 80, 30);

        this.add(cosButton);
        this.add(negButton);
        this.add(clrButton);
        this.add(delButton);
        this.add(panel);
        this.add(label);
        this.add(textField);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButton[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == negButton)
            textField.setText(textField.getText().concat("-"));

        if (e.getSource() == clrButton)
            textField.setText("");
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            opertor = '-';
            textField.setText("");

        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            opertor = '+';
            textField.setText("");

        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            opertor = '/';
            textField.setText("");

        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            opertor = '*';
            textField.setText("");

        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            textField.setText("");

            switch (opertor) {
                case '-':
                    result = num1 - num2;
                    break;
                case '+':
                    result = num1 + num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(textField.getText().concat(String.valueOf(result)));
            num1 = result;


        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
    }
}
