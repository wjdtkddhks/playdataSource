package net.admin.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.order.db.AdminOrderDAO;
import net.member.db.MemberDAO;

public class AdminOrderDeleteAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	throws Exception{
		
		ActionForward forward=new ActionForward();
		HttpSession session = request.getSession();
		MemberDAO member =new MemberDAO();
		boolean isAdmin = member.isAdmin((String)session.getAttribute("id"));
		
		if(!isAdmin) {
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			return forward;
		}
		
		AdminOrderDAO orderdao=new AdminOrderDAO();
		boolean result=false;
		String order_num=request.getParameter("order_num");
		result=orderdao.deleteOrder(Integer.parseInt(order_num));
		
		if(result==false){
			System.out.println("상품 삭제 실패");
			return null;
		}
		
		
		forward.setRedirect(true);
		forward.setPath("./AdminOrderList.ao");
		return forward;
	 } 
}