package interface_design;

public class Computer2 {
	private USB usb;
	                // 參數多型化 (只要實作的物件都能傳入)
	public void setUSB(USB usb) {
		this.usb = usb;
	}
	
	public void workWithUSB() {
		usb.work();
	}
	
}
