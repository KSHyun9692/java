package Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() { return instance; }
	
	private Connection conn; //DB ���� ��ü
	private PreparedStatement ps; //Query �ۼ� ��ü
	private ResultSet rs; //Query ��� Ŀ��
	boolean ok = false;
	
	private void release(Connection conn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void release(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		release(conn, ps);
	}

	//ȸ������
	public boolean joinMember(MemberDTO member) {
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("insert into Customer(custid,custname,custpwd,custaddr,custphone) values(?,?,?,?,?)");
			ps.setString(1, member.getCustid());
			ps.setString(2, member.getCustname());
			ps.setString(3, member.getCustpwd());
			ps.setString(4, member.getCustaddr());
			ps.setString(5, member.getCustphone());
			int result = ps.executeUpdate();
				
			if (result == 1)
				ok = true;
				
			conn.close();
			ps.close();
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			release(conn, ps);
		}
		return ok;
	}
		
	//���̵� ��й�ȣ Ȯ��
	public int findByUsernameAndPassword(String username, String password) throws ClassNotFoundException {
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("select * from Customer where custid = ? and custpwd = ? ");
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				return 1; //�α��� ����
			}
			conn.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return -1; //�α��� ����
	}
	
	//�α���
	public MemberDTO loginMember(MemberDTO member) {
		conn = DBConnection.getConnection();

		try {
			ps = conn.prepareStatement("select * from Customer where custid = ? and custpwd = ? ");
			ps.setString(1, member.getCustid());
			ps.setString(2, member.getCustpwd());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				member.setCustname(rs.getString("custname"));
				member.setCustaddr(rs.getString("custaddr"));
				member.setCustphone(rs.getString("custphone"));
			}
			conn.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			release(conn, ps, rs);
		}
		return member;
	}

}