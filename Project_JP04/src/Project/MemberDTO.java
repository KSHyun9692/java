package Project;

public class MemberDTO {
	private String custid;		//���̵�
	private String custname;	//�̸�
	private String custpwd;		//��й�ȣ
	private String custaddr;	//�ּ�
	private String custphone;	//��ȭ��ȣ
	
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	
	public String getCustpwd() {
		return custpwd;
	}
	public void setCustpwd(String custpwd) {
		this.custpwd = custpwd;
	}
	
	public String getCustaddr() {
		return custaddr;
	}
	public void setCustaddr(String custaddr) {
		this.custaddr=custaddr;
	}

	public String getCustphone() {
		return custphone;
	}
	public void setCustphone(String custphone) {
		this.custphone = custphone;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [custid=" + custid + ", custname=" + custname +
				", custpwd=" + custpwd + ", custaddr=" + custaddr + ", custphone=" + custphone + "]";
	}

}
