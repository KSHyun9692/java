package Project;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Vector;

public class Orders extends JPanel implements ActionListener, MouseListener{
	
	private ImageIcon img = new ImageIcon("images/SHOP.jpg");
	Frame_Start s;
	JTable userTable;
    JScrollPane listJs;
    DefaultTableModel model;
    
    String in, ip, id;
    Vector<String> userColumn = new Vector<String>();
    JButton btn_payment, btn_delete, btn_back;
    int payment = 0;

    private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	boolean ok = false;
    
	String currUser;
	
	public Orders(Frame_Start s, String currUser) {
		this.s = s;
		this.currUser = currUser;
		s.setTitle("��ٱ���");
		setBounds(0, 0, 434, 404);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 334);
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		//���̺� ����
		userColumn.addElement("�ֹ���ȣ");
		userColumn.addElement("����");
        
        //���̺�
        model = new DefaultTableModel(userColumn, 0); 
        userTable = new JTable(model) {
        	public boolean isCellEditable(int row, int column) {
                return false;
             }
        };
        userTable.addMouseListener(this);
        
        //���̺� ��ũ��
        listJs = new JScrollPane(userTable);
        panel.add(listJs);
        
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 333, 434, 71);
		add(panel_1);
		
		btn_payment = new JButton("����");
		panel_1.add(btn_payment);
		btn_payment.addActionListener(this);
		
		btn_delete = new JButton("����");
		panel_1.add(btn_delete);
		btn_delete.addActionListener(this);
		
		btn_back = new JButton("���");
		panel_1.add(btn_back);
		btn_back.addActionListener(this);
		
		//��ٱ��� �����ֱ�
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("select orderid, orderprice from ORDERS where checks <> 1 and custid = ?");
			ps.setString(1, currUser);
			rs = ps.executeQuery();
				
			while (rs.next()) {
				id=rs.getString("orderid");
				in=rs.getString("orderprice");
				Object rowData[] = {id, in};
				model.addRow(rowData);
			}			
			conn.close();
			ps.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btn_payment) {
			if(payment == 0 || payment > 1000) {
				JOptionPane.showMessageDialog(this, "�߸��� ���� �Դϴ�.");
			}
			else {
				model.removeRow(userTable.getSelectedRow());
				JOptionPane.showMessageDialog(this, "���� �Ϸ�");
				conn = DBConnection.getConnection();
				try {
					ps = conn.prepareStatement("update orders set checks = 1 where orderid = " + payment);
					rs = ps.executeQuery();
					conn.close();
					ps.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		//�ֹ����� ����
		else if(e.getSource() == btn_delete) {
			if(payment == 0 || payment > 1000) {
				JOptionPane.showMessageDialog(this, "�߸��� ���� �Դϴ�.");
			}
			else {
				model.removeRow(userTable.getSelectedRow());
				conn = DBConnection.getConnection();
				try {
					ps = conn.prepareStatement("delete from ORDERS where orderid = " + payment);
					rs = ps.executeQuery();
					conn.close();
					ps.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
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
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = userTable.getSelectedRow();
		int cal = userTable.getSelectedColumn();
		payment = Integer.parseInt((String) userTable.getValueAt(row, cal));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
