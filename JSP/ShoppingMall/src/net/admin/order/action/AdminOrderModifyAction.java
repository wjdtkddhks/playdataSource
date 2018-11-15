package net.admin.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.order.db.AdminOrderDAO;
import net.member.db.MemberDAO;
import net.order.db.OrderBean;

public class AdminOrderModifyAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	throws Exception{
		
		ActionForward forward=new ActionForward();
		HttpSession session = request.getSession();
		MemberDAO memberdao =new MemberDAO();
		boolean isAdmin = memberdao.isAdmin((String)session.getAttribute("id"));
		
		if(!isAdmin) {
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			return forward;
		}
		
		AdminOrderDAO orderdao=new AdminOrderDAO();
		OrderBean order=new OrderBean();
		
		boolean result=false;
		request.setCharacterEncoding("utf-8");
		order.setORDER_NUM(Integer.parseInt(request.getParameter("order_num")));
		order.setORDER_TRANS_NUM(request.getParameter("transportnum"));
		order.setORDER_MEMO(request.getParameter("memo"));
		order.setORDER_STATUS(Integer.parseInt(request.getParameter("status")));
		
		result=orderdao.modifyOrder(order);
		if(result==false){
			System.out.println("상품 수정 실패");
			return null;
		}
		
		forward.setRedirect(true);
		forward.setPath("./AdminOrderList.ao");
		return forward;
	 } 
}