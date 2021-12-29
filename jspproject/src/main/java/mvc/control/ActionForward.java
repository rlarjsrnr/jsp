package mvc.control;

/*
 *   요청 파라미터를 명령어로 전달하는 방식으로 구현
 *   ActionForward
 *   InsertAction, ListAction, InfoAction의 비즈니스 로직 수행후 
 *   controlServlet 에게 반환하는 객체를 의미함
 *    (이동할 url, 이동방법을 저장하고 있음)
 */

/*    Controller의 역할
 *     1. 사용자의 요청을 받는다.
 *     2. 사용자의 요청을 분석한다.
 *     3. 사용자의 요청을 처리할 자바 빈을 생성하고 비즈니스 로직이 구현된 메소들 실행함
 *     4. 비즈니스 로직 수행후 사용자의 요청을 JSP페이지나 혹을 특정 URL이동시킴
 * 
 *     Model의 역할 
 *     1. 비즈니스 로직이 구현되어 있다.
 *     2. 데이터베이스에 데이터를 추가, 조회, 변경, 삭제하는 작업을 수행한다.
 *     3.  View에 제공할 데이터를 가공한다.
 *        
 *     
 *     View 의 역할 
 *      1. 클라이언트에게 최종적으로 보여지는 영역이다.(결과)
 *      2. 웹에서는 JSP와 JSTL을 이용해서 구현함
 * 
 * 
 * 
 *      
 *      요청 파라미터를 명령어로 전달하는 방식으로 구현
 *      위의 방법으로 개발시 필요한 클래스
 *      1.    controlServlet 에게 반환하는 객체를 의미함(controller의 역할 수행하는 서블릿)
 *      2.    ActionFactory : 사용자의 요청을 처리할 비즈니스 로직이 구현된 
 *           ( InsertAction, ListAction, InfoAction) 객체의 생성을 담당함
 *      3.    Action : 모든 ( InsertAction, ListAction, InfoAction)클래스가 구현(implements)할 인터페이스,
 *            비즈니스 로직을 재정의할 메소드들을 선언함
 *      4.  XXXAction( InsertAction, ListAction, InfoAction)
 *           - Action인터페이스의 메소드를 재정의하고있는 클래스
 *             실질적인 비즈니스 로직의 구현체임
 *      5.  ActionForward
 *           -  XXXAction의 비즈니스 로직 수행 후 ControlServlet에게 반환하는 객체를 의미함
 *               (이동할 url, 이동방법을 저장하고 있음)
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
