import javax.swing.JFrame;
import javax.swing.JLabel;

public class test extends JFrame {

    public test() {
        super("My Window");

        // Tạo một label
        JLabel label = new JLabel("Hello, world!");

        // Thêm label vào cửa sổ
        getContentPane().add(label);

        // Cài đặt kích thước và vị trí của cửa sổ
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Hiển thị cửa sổ
        setVisible(true);
    }

    public static void main(String[] args) {
        new test();
    }
}