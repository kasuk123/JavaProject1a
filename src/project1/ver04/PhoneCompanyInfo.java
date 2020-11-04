package project1.ver04;

public class PhoneCompanyInfo extends PhoneInfo {
	
	String companyName;

	public PhoneCompanyInfo(String name, String phoneNumber, String companyName) {
		super(name, phoneNumber);
		this.companyName = companyName;
	}

	
	
	@Override
	public void showPhoneInfo() {
	
	System.out.println("이름:"+name);
	System.out.println("전화번호"+phoneNumber);
	}
}


