package Project;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main extends JPanel implements ActionListener{
	private ImageIcon img = new ImageIcon("images/BACK.jpg");
	private ImageIcon img_2 = new ImageIcon("images/JOIN.jpg");
	private ImageIcon img_3 = new ImageIcon("images/SHOP.jpg");
	
	Frame_Start s;
	JButton btn_join, btn_login;
	JTextField textField_id;
	JPasswordField passwordField;
	
	public Main(Frame_Start s) {
		this.s = s;
		
		//jpanel ����
		s.setTitle("����");
		setBounds(0, 0, 434, 404);
		setLayout(null);
		
		//ȸ������ ��ư
		btn_join = new JButton("ȸ������");
		btn_join.setFont(new Font("����", Font.PLAIN, 12));
		btn_join.setBounds(278, 371, 97, 23);
		add(btn_join);
		btn_join.addActionListener(this);
		
		//�α��� ��ư
		btn_login = new JButton("�α���");
		btn_login.setFont(new Font("����", Font.PLAIN, 12));
		btn_login.setBounds(278, 308, 97, 53);
		add(btn_login);
		btn_login.addActionListener(this);
		
		//ID ��
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(66, 315, 57, 15);
		add(lblNewLabel_1);
		
		//Password ��
		JLabel lblNewLabel_2 = new JLabel("PW");
		lblNewLabel_2.setBounds(66, 344, 57, 15);
		add(lblNewLabel_2);
		
		//���̵� �Է� â
		textField_id = new JTextField();
		textField_id.setToolTipText("ID");
		textField_id.setBounds(100, 309, 166, 21);
		textField_id.setColumns(10);
		add(textField_id);
		
		//��й�ȣ �Է� â
		passwordField = new JPasswordField();
		passwordField.setToolTipText("��й�ȣ");
		passwordField.setBounds(100, 340, 166, 21);
		add(passwordField);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn_join) {
			s.remove(this);
			Join j = new Join(s) {
				public void paintComponent(Graphics g) {
					g.drawImage(img_2.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponent(g);
				}
			};
			s.add(j);
			s.invalidate();
			s.validate();
			s.repaint();
		}
		else if (e.getSource() == btn_login) {
			String username = textField_id.getText();
			String password = passwordField.getText();
			MemberDAO dao = MemberDAO.getInstance();
			int result;
			try {
				result = dao.findByUsernameAndPassword(username, password);
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "�α��� ����");
					s.remove(this);
					//�α����� ���̵� ��������
					Main_Login m_i = new Main_Login(s, username) {
						public void paintComponent(Graphics g) {
							g.drawImage(img_3.getImage(), 0, 0, null);
							setOpaque(false);
							super.paintComponent(g);
						}
					};
					s.add(m_i);
					s.invalidate();
					s.validate();
					s.repaint();
				}
				else {
					JOptionPane.showMessageDialog(null, "�α��� ����");
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
