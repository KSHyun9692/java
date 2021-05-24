package Project;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Join extends JPanel implements ActionListener{
	private ImageIcon img = new ImageIcon("images/BACK.jpg"); 
	JButton btn_join, btn_back, btn_check;
	Frame_Start s;
	JTextField textField_id, textField_name, textField_address, textField_tel;
	JPasswordField passwordField;
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Join(Frame_Start s) {
		this.s = s;
		//jfram ����
		setBounds(0, 0, 434, 404);
		setLayout(null);
		s.setTitle("ȸ������");
		
		//��ư����
		btn_join = new JButton("ȸ������");
		btn_join.setBounds(133, 254, 97, 23);
		btn_join.setFont(new Font("����", Font.PLAIN, 12));
		add(btn_join);
		btn_join.addActionListener(this);
		
		btn_back = new JButton("���");
		btn_back.setBounds(242, 254, 97, 23);
		btn_back.setFont(new Font("����", Font.PLAIN, 12));
		add(btn_back);
		btn_back.addActionListener(this);
		
		btn_check = new JButton("�ߺ�Ȯ��");
		btn_check.setBounds(309, 30, 97, 23);
		btn_check.setFont(new Font("����", Font.PLAIN, 12));
		add(btn_check);
		btn_check.addActionListener(this);
		
		//���̵�
		JLabel lblNewLabel = new JLabel("���̵�(*)");
		lblNewLabel.setBounds(12, 34, 57, 15);
		add(lblNewLabel);
		
		textField_id = new JTextField();
		textField_id.setBounds(93, 31, 204, 21);
		textField_id.setColumns(10);
		textField_id.setOpaque(false);
		add(textField_id);
		
		//�̸�
		JLabel lblNewLabel_1 = new JLabel("�̸�(*)");
		lblNewLabel_1.setBounds(12, 77, 57, 15);
		add(lblNewLabel_1);
		
		textField_name = new JTextField();
		textField_name.setBounds(93, 74, 313, 21);
		textField_name.setColumns(10);
		textField_name.setOpaque(false);
		add(textField_name);
		
		//��й�ȣ
		JLabel lblNewLabel_2 = new JLabel("��й�ȣ(*)");
		lblNewLabel_2.setBounds(12, 120, 80, 15);
		add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(93, 117, 313, 21);
		passwordField.setOpaque(false);
		add(passwordField);
		
		//�ּ�
		JLabel lblNewLabel_3 = new JLabel("�ּ�");
		lblNewLabel_3.setBounds(12, 163, 57, 15);
		add(lblNewLabel_3);
		
		textField_address = new JTextField();
		textField_address.setBounds(93, 160, 313, 21);
		textField_address.setColumns(10);
		textField_address.setOpaque(false);
		add(textField_address);
		
		//��ȭ��ȣ
		JLabel lblNewLabel_4 = new JLabel("��ȭ��ȣ");
		lblNewLabel_4.setBounds(12, 206, 57, 15);
		add(lblNewLabel_4);
		
		textField_tel = new JTextField();
		textField_tel.setBounds(93, 206, 313, 21);
		textField_tel.setColumns(10);
		textField_tel.setOpaque(false);
		add(textField_tel);
		
		//ȭ�� ǥ��
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn_join) {
			MemberDTO join = new MemberDTO();
			MemberDAO memberDAO = new MemberDAO();
			join.setCustid(textField_id.getText());
			join.setCustname(textField_name.getText());
			join.setCustpwd(passwordField.getText());
			join.setCustaddr(textField_address.getText());
			join.setCustphone(textField_tel.getText());
			
			if (textField_id.getText().equals("") || textField_name.getText().equals("") || passwordField.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "�ʼ��Է»����� �Է����ּ���.");
				return;
			}

			boolean ok = memberDAO.joinMember(join);
			if (ok) {
				JOptionPane.showMessageDialog(this, "ȸ������ �Ǿ����ϴ�.");
				s.remove(this);
				Main m = new Main(s) {
					public void paintComponent(Graphics g) {
						g.drawImage(img.getImage(), 0, 0, null);
						setOpaque(false);
						super.paintComponent(g);
					}
				};
				s.add(m);
				s.invalidate();
				s.validate();
				s.repaint();
			} else {
				JOptionPane.showMessageDialog(this, "ȸ�������� �߸� �Է��ϼ̽��ϴ�.");
			}
			
		}
		else if(e.getSource() == btn_back) {
			s.remove(this);
			Main m = new Main(s) {
				public void paintComponent(Graphics g) {
					g.drawImage(img.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponent(g);
				}
			};
			s.add(m);
			s.invalidate();
			s.validate();
			s.repaint();
		}
		
		else if (e.getSource() == btn_check) {
			if (textField_id.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "���̵� �Է����ּ���.");
				return;
			}
	         conn = DBConnection.getConnection();
	         try {
	            ps = conn.prepareStatement("select COUNT(custid) from Customer where custid = ? ");
	            ps.setString(1, textField_id.getText());
	            rs = ps.executeQuery();     
	            
	            while (rs.next()) {
	               int cnt = rs.getInt(1);
	               if (cnt == 0) {
	                  JOptionPane.showMessageDialog(this, "��� ������ ���̵��Դϴ�.");
	               }
	               else {
	                  JOptionPane.showMessageDialog(this, "��� �Ұ����� ���̵��Դϴ�.");
	               }
	            }
	            conn.close();
	            ps.close();
	            
	         } catch (Exception e2) {
	            e2.printStackTrace();
	         }
	      }
	}

}
