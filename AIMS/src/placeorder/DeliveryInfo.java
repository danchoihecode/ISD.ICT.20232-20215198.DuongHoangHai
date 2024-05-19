package placeorder;

public class DeliveryInfo {

	private String name;

	private String phone;

	private String email;

	private String address;

	private String province;

	public DeliveryInfo(String name, String phone, String email, String address, String province) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.province = province;
	}

	public boolean checkAddessSupportability() {
		if (province.equals("Hanoi"))
			return true;
		return false;
	}

	public boolean validateDeliveryInfo() {

		if (email == null || !email.contains("@") || email.contains(" ")) {
			return false;
		}

		if (phone == null || !phone.matches("\\d{10}")) {
			return false;
		}

		return true;
	}

}
