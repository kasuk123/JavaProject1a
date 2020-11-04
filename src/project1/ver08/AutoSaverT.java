package project1.ver08;

public class AutoSaverT extends Thread{

	PhoneBookManager mng = null;
	
	public AutoSaverT(PhoneBookManager p) {
	mng = p;
	}
	@Override
	public void run() {
		while(true) {
			try {
				mng.save();
				System.out.println("주소록이 텍스트로 저장되었습니다.");
				sleep(2000);
			} catch (InterruptedException e) {
				break;
			}
		}
		
	}
}
