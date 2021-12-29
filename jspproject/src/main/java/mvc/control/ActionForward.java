package mvc.control;

/*
 *   ��û �Ķ���͸� ��ɾ�� �����ϴ� ������� ����
 *   ActionForward
 *   InsertAction, ListAction, InfoAction�� ����Ͻ� ���� ������ 
 *   controlServlet ���� ��ȯ�ϴ� ��ü�� �ǹ���
 *    (�̵��� url, �̵������ �����ϰ� ����)
 */

/*    Controller�� ����
 *     1. ������� ��û�� �޴´�.
 *     2. ������� ��û�� �м��Ѵ�.
 *     3. ������� ��û�� ó���� �ڹ� ���� �����ϰ� ����Ͻ� ������ ������ �޼ҵ� ������
 *     4. ����Ͻ� ���� ������ ������� ��û�� JSP�������� Ȥ�� Ư�� URL�̵���Ŵ
 * 
 *     Model�� ���� 
 *     1. ����Ͻ� ������ �����Ǿ� �ִ�.
 *     2. �����ͺ��̽��� �����͸� �߰�, ��ȸ, ����, �����ϴ� �۾��� �����Ѵ�.
 *     3.  View�� ������ �����͸� �����Ѵ�.
 *        
 *     
 *     View �� ���� 
 *      1. Ŭ���̾�Ʈ���� ���������� �������� �����̴�.(���)
 *      2. �������� JSP�� JSTL�� �̿��ؼ� ������
 * 
 * 
 * 
 *      
 *      ��û �Ķ���͸� ��ɾ�� �����ϴ� ������� ����
 *      ���� ������� ���߽� �ʿ��� Ŭ����
 *      1.    controlServlet ���� ��ȯ�ϴ� ��ü�� �ǹ���(controller�� ���� �����ϴ� ����)
 *      2.    ActionFactory : ������� ��û�� ó���� ����Ͻ� ������ ������ 
 *           ( InsertAction, ListAction, InfoAction) ��ü�� ������ �����
 *      3.    Action : ��� ( InsertAction, ListAction, InfoAction)Ŭ������ ����(implements)�� �������̽�,
 *            ����Ͻ� ������ �������� �޼ҵ���� ������
 *      4.  XXXAction( InsertAction, ListAction, InfoAction)
 *           - Action�������̽��� �޼ҵ带 �������ϰ��ִ� Ŭ����
 *             �������� ����Ͻ� ������ ����ü��
 *      5.  ActionForward
 *           -  XXXAction�� ����Ͻ� ���� ���� �� ControlServlet���� ��ȯ�ϴ� ��ü�� �ǹ���
 *               (�̵��� url, �̵������ �����ϰ� ����)
 */


public class ActionForward {

	private String url;
	private boolean redirect;
	
	public ActionForward() {		}
	public ActionForward(String url) {	this.url=url;	}
	public ActionForward(String url, boolean redirect) {
		this.url=url;this.redirect=redirect;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
}
