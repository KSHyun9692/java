package Project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import java.awt.Font;

public class Shop_And_Cart1 extends JPanel implements ActionListener{
	private ImageIcon [] images = { new ImageIcon("images/1.jpg"), new ImageIcon("images/2.jpg"), new ImageIcon("images/3.jpg"),
			new ImageIcon("images/4.jpg"), new ImageIcon("images/5.jpg"), new ImageIcon("images/6.jpg")};
	private ImageIcon img = new ImageIcon("images/SHOP.jpg");
	Frame_Start s;
	JTextField textField_product1, textField_product2, textField_product3, textField_product4, textField_product5, textField_product6;
	JTextField textField_price1, textField_price2, textField_price3, textField_price4, textField_price5, textField_price6;
	JButton btn_order, btn_back, btn_page1, btn_page2, btn_page3, btn_page4, btn_page5;
	JCheckBox CheckBox_product1, CheckBox_product2, CheckBox_product3, CheckBox_product4, CheckBox_product5, CheckBox_product6;

	String currUser;
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	boolean ok = false;

	public Shop_And_Cart1(Frame_Start s, String currUser) {
		this.s = s;
		this.currUser = currUser;
		
		s.setTitle("상품목록");
		//메인 jpanel 설정
		setBounds(0, 0, 434, 404);
		setLayout(null);
		
		//상단 상품 라벨 자리 설정용 jpanel
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 61, 20);
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		//상단 상품 표시 라벨
		JLabel lblNewLabel = new JLabel("상품");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		//상단 상품명, 가격 라벨 자리 설정용 jpanel
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(60, 0, 325, 20);
		add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		//상단 상품명 라벨
		JLabel lblNewLabel_1 = new JLabel("상품명");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		//상단 가격 라벨
		JLabel lblNewLabel_2 = new JLabel("가격(원)");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);
		
		//상단 선택 라벨 자리 설정용 jpanel
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(384, 0, 50, 20);
		add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		//상단 선택 라벨
		JLabel lblNewLabel_3 = new JLabel("선택");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_3);
		
		//중단 상품이미지 자리 설정용 jpanel
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 24, 61, 300);
		add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		//상품 이미지 표시용 라벨들
		JLabel lblNewLabel_4 = new JLabel(images[0]);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(images[1]);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(images[2]);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(images[3]);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(images[4]);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(images[5]);
		panel_3.add(lblNewLabel_9);
		
		//중단 상품명 textfield 자리 설정용 jpanel
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(60, 24, 163, 300);
		add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		//상품명 표시용 textfield
		textField_product1 = new JTextField();
		textField_product1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_product1.setFont(new Font("굴림", Font.PLAIN, 17));
		textField_product1.setBackground(Color.WHITE);
		textField_product1.setEditable(false);
		panel_4.add(textField_product1);
		textField_product1.setColumns(10);
		
		textField_product2 = new JTextField();
		textField_product2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_product2.setFont(new Font("굴림", Font.PLAIN, 17));
		textField_product2.setEditable(false);
		textField_product2.setBackground(Color.WHITE);
		panel_4.add(textField_product2);
		textField_product2.setColumns(10);
		
		textField_product3 = new JTextField();
		textField_product3.setFont(new Font("굴림", Font.PLAIN, 17));
		textField_product3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_product3.setBackground(Color.WHITE);
		textField_product3.setEditable(false);
		panel_4.add(textField_product3);
		textField_product3.setColumns(10);
		
		textField_product4 = new JTextField();
		textField_product4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_product4.setFont(new Font("굴림", Font.PLAIN, 17));
		textField_product4.setBackground(Color.WHITE);
		textField_product4.setEditable(false);
		panel_4.add(textField_product4);
		textField_product4.setColumns(10);
		
		textField_product5 = new JTextField();
		textField_product5.setFont(new Font("굴림", Font.PLAIN, 17));
		textField_product5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_product5.setBackground(Color.WHITE);
		textField_product5.setEditable(false);
		panel_4.add(textField_product5);
		textField_product5.setColumns(10);
		
		textField_product6 = new JTextField();
		textField_product6.setFont(new Font("굴림", Font.PLAIN, 17));
		textField_product6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_product6.setBackground(Color.WHITE);
		textField_product6.setEditable(false);
		panel_4.add(textField_product6);
		textField_product6.setColumns(10);
		
		//중단 상품 가격 textfield 자리 설정용 jpanel
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(222, 24, 163, 300);
		add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		//상품 가격 표시 textfield
		textField_price1 = new JTextField();
		textField_price1.setFont(new Font("굴림", Font.PLAIN, 17));
		textField_price1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_price1.setBackground(Color.WHITE);
		textField_price1.setEditable(false);
		panel_5.add(textField_price1);
		textField_price1.setColumns(10);
		
		textField_price2 = new JTextField();
		textField_price2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_price2.setFont(new Font("굴림", Font.PLAIN, 17));
		textField_price2.setBackground(Color.WHITE);
		textField_price2.setEditable(false);
		panel_5.add(textField_price2);
		textField_price2.setColumns(10);
		
		textField_price3 = new JTextField();
		textField_price3.setFont(new Font("굴림", Font.PLAIN, 17));
		textField_price3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_price3.setBackground(Color.WHITE);
		textField_price3.setEditable(false);
		panel_5.add(textField_price3);
		textField_price3.setColumns(10);
		
		textField_price4 = new JTextField();
		textField_price4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_price4.setFont(new Font("굴림", Font.PLAIN, 17));
		textField_price4.setBackground(Color.WHITE);
		textField_price4.setEditable(false);
		panel_5.add(textField_price4);
		textField_price4.setColumns(10);
		
		textField_price5 = new JTextField();
		textField_price5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_price5.setFont(new Font("굴림", Font.PLAIN, 17));
		textField_price5.setBackground(Color.WHITE);
		textField_price5.setEditable(false);
		panel_5.add(textField_price5);
		textField_price5.setColumns(10);
		
		textField_price6 = new JTextField();
		textField_price6.setFont(new Font("굴림", Font.PLAIN, 17));
		textField_price6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_price6.setBackground(Color.WHITE);
		textField_price6.setEditable(false);
		panel_5.add(textField_price6);
		textField_price6.setColumns(10);
		
		//중단 체크박스 자리 설정용 jpanel
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(384, 24, 50, 300);
		add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		//작성중
		conn = DBConnection.getConnection();
		try {
			for (int i=1; i<=6; i++) {
				ps = conn.prepareStatement("select itemname, itemprice from Item where itemid = " + i);
				rs = ps.executeQuery();
				String in, ip;
				while (rs.next()) {
					in=rs.getString("itemname");
					ip=rs.getString("itemprice");
					
					if (i==1) {
						textField_product1.setText(in);
						textField_price1.setText(ip);
					} else if (i==2) {
						textField_product2.setText(in);
						textField_price2.setText(ip);
					} else if (i==3) {
						textField_product3.setText(in);
						textField_price3.setText(ip);
					} else if (i==4) {
						textField_product4.setText(in);
						textField_price4.setText(ip);
					} else if (i==5) {
						textField_product5.setText(in);
						textField_price5.setText(ip);
					} else {
						textField_product6.setText(in);
						textField_price6.setText(ip);
					}
				}
			}
			conn.close();
			ps.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		//상품 선택 체크박스
		CheckBox_product1 = new JCheckBox("");
		CheckBox_product1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(CheckBox_product1);

		CheckBox_product2 = new JCheckBox("");
		CheckBox_product2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(CheckBox_product2);
		
		CheckBox_product3 = new JCheckBox("");
		CheckBox_product3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(CheckBox_product3);
		
		CheckBox_product4 = new JCheckBox("");
		CheckBox_product4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(CheckBox_product4);
		
		CheckBox_product5 = new JCheckBox("");
		CheckBox_product5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(CheckBox_product5);
		
		CheckBox_product6 = new JCheckBox("");
		CheckBox_product6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(CheckBox_product6);
		
		//하단 버튼 자리 설정용 jpanel
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 320, 434, 39);
		add(panel_7);
		
		btn_order = new JButton("주문하기");
		panel_7.add(btn_order);
		btn_order.addActionListener(this);

		btn_back = new JButton("뒤로가기");
		panel_7.add(btn_back);
		btn_back.addActionListener(this);
		
		//하단 페이지 자리 설정용 jpanel
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 358, 434, 46);
		add(panel_8);
		
		//페이지 버튼
		btn_page1 = new JButton("1");
		panel_8.add(btn_page1);
		btn_page1.addActionListener(this);
		
		btn_page2 = new JButton("2");
		panel_8.add(btn_page2);
		btn_page2.addActionListener(this);
		
		btn_page3 = new JButton("3");
		panel_8.add(btn_page3);
		btn_page3.addActionListener(this);
		
		btn_page4 = new JButton("4");
		panel_8.add(btn_page4);
		btn_page4.addActionListener(this);
		
		btn_page5 = new JButton("5");
		panel_8.add(btn_page5);
		btn_page5.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int totalPrice = 0;
		
		if(e.getSource() == btn_order) {	
			String tp;
			conn = DBConnection.getConnection();
			try {
				if (CheckBox_product1.isSelected()) {
					tp=textField_price1.getText();
					totalPrice += Integer.parseInt(tp);
				}
				if (CheckBox_product2.isSelected()) {
					tp=textField_price2.getText();
					totalPrice += Integer.parseInt(tp);
				}
				if (CheckBox_product3.isSelected()) {
					tp=textField_price3.getText();
					totalPrice += Integer.parseInt(tp);
				}
				if (CheckBox_product4.isSelected()) {
					tp=textField_price4.getText();
					totalPrice += Integer.parseInt(tp);
				}
				if (CheckBox_product5.isSelected()) {
					tp=textField_price5.getText();
					totalPrice += Integer.parseInt(tp);
				}
				if (CheckBox_product6.isSelected()) {
					tp=textField_price6.getText();
					totalPrice += Integer.parseInt(tp);
				}
				if (!CheckBox_product1.isSelected() && !CheckBox_product2.isSelected() && !CheckBox_product3.isSelected() &&
						!CheckBox_product4.isSelected() && !CheckBox_product5.isSelected() && !CheckBox_product6.isSelected()) {
					JOptionPane.showMessageDialog(this, "물건을 선택해주세요.");
					return;
				}
				
				ps = conn.prepareStatement("insert into Orders(orderid,custid,orderprice,checks) values(EX_SEQ.NEXTVAL,?,?,?)");
				ps.setString(1, currUser);
				ps.setInt(2, totalPrice);
				ps.setInt(3, 0);
				rs = ps.executeQuery();
				
				JOptionPane.showMessageDialog(this, "물건이 장바구니에 담겼습니다.");
				conn.close();
				ps.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		else if(e.getSource() == btn_back) {
			s.remove(this);
			Main_Login m_l = new Main_Login(s, currUser) {
				public void paintComponent(Graphics g) {
					g.drawImage(img.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponent(g);
				}
			};
			s.add(m_l);
			s.invalidate();
			s.validate();
			s.repaint();
		}
		
		else if(e.getSource() == btn_page1) {
			s.remove(this);
			Shop_And_Cart1 sac1 = new Shop_And_Cart1(s, currUser);
			s.add(sac1);
			s.invalidate();
			s.validate();
			s.repaint();
			
		}
		
		else if(e.getSource() == btn_page2) {
			s.remove(this);
			Shop_And_Cart2 sac2 = new Shop_And_Cart2(s, currUser);
			s.add(sac2);
			s.invalidate();
			s.validate();
			s.repaint();
		}
		
		else if(e.getSource() == btn_page3) {
			s.remove(this);
			Shop_And_Cart3 sac3 = new Shop_And_Cart3(s, currUser);
			s.add(sac3);
			s.invalidate();
			s.validate();
			s.repaint();
		}
		
		else if(e.getSource() == btn_page4) {
			s.remove(this);
			Shop_And_Cart4 sac4 = new Shop_And_Cart4(s, currUser);
			s.add(sac4);
			s.invalidate();
			s.validate();
			s.repaint();
		}
		
		else if(e.getSource() == btn_page5) {
			s.remove(this);
			Shop_And_Cart5 sac5 = new Shop_And_Cart5(s, currUser);
			s.add(sac5);
			s.invalidate();
			s.validate();
			s.repaint();
		}
	}

}
