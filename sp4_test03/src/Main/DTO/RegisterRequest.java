package Main.DTO;

public class RegisterRequest {	//값을 받아오기위한 DTO
	private String email;
	private String name;
	private String password;
	private String confirmPassword;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public boolean isPasswordEqualConfirmPassword() { //boolean일때는 get이 아닌 is이다.
		return password.equals(confirmPassword);	//암호와 암호확인의 값을 비교하고 확인된 값을 return
	}
	
}
