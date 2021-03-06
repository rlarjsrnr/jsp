package mvcmem.control;

// 이동방식을 정의한  클래스(Redirect, Forward)
// 리턴페이지(view) 정의한 클래스

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
