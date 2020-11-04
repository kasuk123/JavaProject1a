package project1.ver07;

public class PhoneInfo {

	String name;
	String phoneNumber;
	String major;
	int grade;

	public PhoneInfo(String name, String phoneNumber) {

		this.name = name;
		this.phoneNumber = phoneNumber;

	}

	@Override
	public int hashCode() {
		int hc1 = name.hashCode();
		return hc1;
	}

	@Override
	public boolean equals(Object obj) {
		PhoneInfo phoneInfo = (PhoneInfo) obj;
		if (this.name.equals(phoneInfo.name)) {
			return true;
		} else {
			return false;
		}
	}

	public void showPhoneInfo() {

		System.out.println("이름:" + name);
		System.out.println("전화번호:" + phoneNumber);
		// System.out.println("전공:"+ major);
		// System.out.println("학년:"+ grade);

	}

}
