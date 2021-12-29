package action;

import java.io.Serializable;

/*
 * ����ȭ��
 * - �ڹ� �ý��� ����(JVM)���� ���Ǵ� ��ü �Ǵ� �����͸� �ܺ��� �ڹ� �ý��ۿ����� ����� �� �ֵ���
 *   ����Ʈ(byte) ���·� ������ ��ȯ�ϴ� �����
 *   ����Ʈ�� ��ȯ�� �����͸� �ٽ� ��ü�� ��ȯ�ϴ� ���
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
