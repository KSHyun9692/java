package Project;

public class MemberDTO {
	private String custid;		//아이디
	private String custname;	//이름
	private String custpwd;		//비밀번호
	private String custaddr;	//주소
	private String custphone;	//전화번호
	
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
