
// import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class swing extends JFrame {

    private JLabel label1, label2, label3;
    private JTextField textField1, textField2;
    private JButton button1, button2;

    public static int number1;
    public static int number2;
    public static int result;
    public static String[] sign = { "+", "-", "x", ":" };
    public static String signn;

    private static void Reset() {
        Random random = new Random();
        signn = sign[random.nextInt(4)];
        textField1 = random.nextInt(10) + 1;
        textField2 = random.nextInt(10) + 1;
        while (signn == "-" && number1 < number2) {
            textField1 = random.nextInt(10) + 1;
            textField2 = random.nextInt(10) + 1;
        }
    }

    public swing() {
        super("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Tạo các label
        label1 = new JLabel("Number1:");
        label2 = new JLabel("Number2:");
        label3 = new JLabel("Result:");

        label1.setBounds(10, 10, 100, 20);
        label2.setBounds(10, 50, 100, 20);
        label3.setBounds(10, 90, 100, 20);

        // Tạo các text field
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);

        textField1.setBounds(120, 10, 150, 20);
        textField2.setBounds(120, 50, 150, 20);

        // Tạo các button
        button1 = new JButton("Check");
        button2 = new JButton("Next");

        button1.setBounds(120, 100, 100, 20);
        button2.setBounds(230, 150, 100, 20);

        // getContentPane().setLayout(new GridLayout(4, 4));
        getContentPane().setLayout(null);

        // Thêm các thành phần vào cửa sổ
        getContentPane().add(label1);
        getContentPane().add(textField1);
        getContentPane().add(label2);
        getContentPane().add(textField2);
        getContentPane().add(label3);
        getContentPane().add(button1);
        getContentPane().add(button2);
        pack();
        // Cài đặt kích thước và vị trí của cửa sổ
        setSize(700, 700);
        setLocationRelativeTo(null);

        // Hiển thị cửa sổ
        setVisible(true);

        // Xử lý sự kiện click button
        button1.addActionListener(e -> {
            // Lấy giá trị từ các text field
            if (!(textField1.getText().isEmpty() && textField2.getText().isEmpty())) {
                int a = Integer.parseInt(textField1.getText());
                int b = Integer.parseInt(textField2.getText());

                // Tính toán kết quả
                int c = a * b;

                // Hiển thị kết quả
                label3.setText("Result: " + c);
            } else {
                // JFrame noticFrame = new JFrame();
                JOptionPane.showMessageDialog(null, "input number", "error", JOptionPane.ERROR_MESSAGE);

            }
        });

        button2.addActionListener(e -> {
            // Xóa nội dung của các text field
            textField1.setText("");
            textField2.setText("");

            // Hiển thị kết quả
            label3.setText("Result: ");
        });
    }

    public static void main(String[] args) {
        new swing();
    }
}