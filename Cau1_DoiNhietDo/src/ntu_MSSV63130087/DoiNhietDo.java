package ntu_MSSV63130087;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.SystemColor;

public class DoiNhietDo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_F;
	private JTextField txt_C;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoiNhietDo frame = new DoiNhietDo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DoiNhietDo() {
		setFont(new Font("Times New Roman", Font.BOLD, 16));
        setTitle("Chương Trình Đổi Nhiệt Độ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 597, 403);
        contentPane = new JPanel();
        contentPane.setForeground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nhập độ F");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel.setBounds(50, 93, 100, 31);
        contentPane.add(lblNewLabel);

        JLabel lblC = new JLabel("Nhập độ C");
        lblC.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblC.setBounds(50, 149, 87, 31);
        contentPane.add(lblC);

        JLabel lblChngTrnhChuyn = new JLabel("CHƯƠNG TRÌNH CHUYỂN ĐỔI NHIỆT ĐỘ");
        lblChngTrnhChuyn.setBackground(Color.WHITE);
        lblChngTrnhChuyn.setForeground(Color.BLACK);
        lblChngTrnhChuyn.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblChngTrnhChuyn.setBounds(119, 28, 371, 31);
        contentPane.add(lblChngTrnhChuyn);

        txt_F = new JTextField();
        txt_F.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        txt_F.setBounds(170, 91, 259, 39);
        contentPane.add(txt_F);
        txt_F.setColumns(10);

        txt_C = new JTextField();
        txt_C.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        txt_C.setColumns(10);
        txt_C.setBounds(170, 147, 259, 39);
        contentPane.add(txt_C);

        JButton btn_FC = new JButton("Chuyển sang độ C");
        btn_FC.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btn_FC.setBounds(81, 208, 166, 39);
        contentPane.add(btn_FC);

        JButton btn_CF = new JButton("Chuyển sang độ F");
        btn_CF.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btn_CF.setBounds(283, 208, 166, 39);
        contentPane.add(btn_CF);

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnClear.setBounds(188, 257, 166, 39);
        contentPane.add(btnClear);

     // Xử lý Chuyển sang độ C
        btn_FC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//Lấy dữ liệu nhập vào
                String txtF = txt_F.getText();
                if (!txtF.isEmpty()) {
                    try {
                        double f = Double.parseDouble(txtF);//Chuyển kiểu dữ liệu String sang double
                        double c = (f - 32) * 5 / 9;
                        txt_C.setText(String.format("%.1f", c));
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập một số thực");//Thông báo lỗi
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập giá trị độ F");
                }
            }
        });

        // Xử lý Chuyển sang độ F
        btn_CF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//Lấy dữ liệu nhập vào
                String txtC = txt_C.getText();
                if (!txtC.isEmpty()) {
                    try {
                        double c = Double.parseDouble(txtC);
                        double f = c * 9 / 5 + 32;
                        txt_F.setText(String.format("%.1f", f));
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập một số thực");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập giá trị độ C");
                }
            }
        });

        // Xử lý sự kiện khi nhấn nút "Clear"
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txt_F.setText("");
                txt_C.setText("");
            }
        });
    }
}	
