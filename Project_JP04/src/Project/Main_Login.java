package Project;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Main_Login extends JPanel implements ActionListener{
	
	private ImageIcon img = new ImageIcon("images/BACK.jpg");
	Frame_Start s;
	JButton btn_logout, btn_shop, btn_orders, btn_payment;
	String currUser;
	
	public Main_Login(Frame_Start s, String currUser) {
		this.s = s;
		this.currUser = currUser;
		
		//jpanel ����
		s.setTitle("����");
		setBounds(0, 0, 434, 404);
		setLayout(null);
		
		//�α׾ƿ� ��ư
		btn_logout = new JButton("�α׾ƿ�");
		btn_logout.setFont(new Font("����", Font.PLAIN, 12));
		btn_logout.setBounds(12, 371, 97, 23);
		add(btn_logout);
		btn_logout.addActionListener(this);
		
		//��ǰ��� ��ư
		btn_shop = new JButton("��ǰ���");
		btn_shop.setFont(new Font("����", Font.PLAIN, 12));
		btn_shop.setBounds(114, 371, 97, 23);
		add(btn_shop);
		btn_shop.addActionListener(this);
		
		//���� ��ư
		btn_orders = new JButton("��ٱ���");
		btn_orders.setFont(new Font("����", Font.PLAIN, 12));
		btn_orders.setBounds(223, 371, 97, 23);
		add(btn_orders);
		btn_orders.addActionListener(this);
		
		//����Ȯ��
		btn_payment = new JButton("����Ȯ��");
		btn_payment.setFont(new Font("����", Font.PLAIN, 12));
		btn_payment.setBounds(327, 371, 97, 23);
		add(btn_payment);
		btn_payment.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btn_logout) {
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
		else if(e.getSource() == btn_shop) {
			s.remove(this);
			Shop_And_Cart1 sp = new Shop_And_Cart1(s, currUser);
			s.add(sp);
			s.invalidate();
			s.validate();
			s.repaint();
		}
		
		else if(e.getSource() == btn_orders) {
			s.remove(this);
			Orders ods = new Orders(s, currUser);
			s.add(ods);
			s.invalidate();
			s.validate();
			s.repaint();
		}
		
		else if(e.getSource() == btn_payment) {
			s.remove(this);
			Payment pay = new Payment(s, currUser);
			s.add(pay);
			s.invalidate();
			s.validate();
			s.repaint();
		}
	}

}
