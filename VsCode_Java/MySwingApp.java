
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MySwingApp {
    public static int number1;
    public static int number2;
    public static int result;
    public static String[] sign = { "+", "-", "x", ":" };
    public static String signn;

    private static void Reset() {
        Random random = new Random();
        signn = sign[random.nextInt(4)];
        number1 = random.nextInt(10) + 1;
        number2 = random.nextInt(10) + 1;
        while (signn == "-" && number1 < number2) {
            number1 = random.nextInt(10) + 1;
            number2 = random.nextInt(10) + 1;
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Reset();
            JFrame frame = new JFrame("Java Swing App");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel Number1 = new JLabel(String.valueOf(number1));
            Number1.setBounds(50, 20, 30, 30);
            JLabel Sign = new JLabel(signn);
            Sign.setBounds(90, 20, 30, 30);
            JLabel Number2 = new JLabel(String.valueOf(number2));
            Number2.setBounds(130, 20, 30, 30);
            JLabel Sign1 = new JLabel("=");
            Sign1.setBounds(170, 20, 30, 30);
            JLabel ResultNotfi = new JLabel("");
            ResultNotfi.setBounds(50, 80, 100, 30);
            // Tạo TextBox

            JTextField Result = new JTextField();
            Result.setBounds(210, 20, 50, 30);
            // Tạo Button
            JButton OK = new JButton("OK");
            OK.setBounds(50, 160, 100, 30);
            JButton Next = new JButton("Next");
            Next.setBounds(170, 160, 100, 30);

            // Thêm sự kiện khi Button được nhấn
            OK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lấy nội dung từ TextBox khi Button được nhấn
                    int a = Integer.parseInt(Number1.getText());
                    int b = Integer.parseInt(Number2.getText());
                    int c = Integer.parseInt(Result.getText());
                    switch (signn) {
                        case "+":
                            if (a + b == c) {
                                ResultNotfi.setText("Correct!");
                            } else {
                                ResultNotfi.setText("Not correct!");
                            }
                            break;
                        case "-":
                            if (a - b == c) {
                                ResultNotfi.setText("Correct!");
                            } else {
                                ResultNotfi.setText("Not correct!");
                            }
                            break;
                        case "x":
                            if (a * b == c) {
                                ResultNotfi.setText("Correct!");
                            } else {
                                ResultNotfi.setText("Not correct!");
                            }
                            break;
                        case ":":
                            if (a / b == c) {
                                ResultNotfi.setText("Correct!");
                            } else {
                                ResultNotfi.setText("Not correct!");
                            }
                            break;
                        default:
                            break;
                    }

                }
            });
            Next.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Reset();
                    Number1.setText(String.valueOf(number1));
                    Sign.setText(signn);
                    Number2.setText(String.valueOf(number2));
                    Result.setText("");
                    ResultNotfi.setText("");
                }
            });
            // Thêm các thành phần vào JFrame
            frame.getContentPane().setLayout(null); // Sử dụng Layout null để tự cài đặt vị trí của các thành phần
            frame.getContentPane().add(Result);
            frame.getContentPane().add(OK);
            frame.getContentPane().add(Next);
            frame.getContentPane().add(Number1);
            frame.getContentPane().add(Number2);
            frame.getContentPane().add(Sign);
            frame.getContentPane().add(Sign1);
            frame.getContentPane().add(ResultNotfi);
            frame.setVisible(true);
        });
    }
}
