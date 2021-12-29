package action;

import java.io.Serializable;

/*
 * 직렬화란
 * - 자바 시스템 내부(JVM)에서 사용되는 객체 또는 데이터를 외부의 자바 시스템에서도 사용할 수 있도록
 *   바이트(byte) 형태로 데이터 변환하는 기술과
 *   바이트로 변환된 데이터를 다시 객체로 변환하는 기술
 */

public class Customer implements Serializable {

	private String name;
	private String email;
	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
