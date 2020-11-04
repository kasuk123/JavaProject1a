package project1.ver08;

public class PhoneCompanyInfo extends PhoneInfo {
	
	String companyName;

	public PhoneCompanyInfo(String name, String phoneNumber, String companyName) {
		super(name, phoneNumber);
		this.companyName = companyName;
	}

	
	
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
	System.out.println("회사명:"+companyName);
	
	}
	@Override
	public String getter1() {
		// TODO Auto-generated method stub
		return this.companyName;
	}
}


