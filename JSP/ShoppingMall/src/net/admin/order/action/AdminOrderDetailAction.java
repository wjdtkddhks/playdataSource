package net.admin.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.order.db.AdminOrderDAO;
import net.member.db.MemberBean;
import net.member.db.MemberDAO;
import net.order.db.OrderBean;

public class AdminOrderDetailAction implements Action{
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
		
		MemberBean member=new MemberBean();
		AdminOrderDAO orderdao=new AdminOrderDAO();
		OrderBean order = new OrderBean();
		
		String order_num = request.getParameter("order_num");
		order = orderdao.getOrderDetail(Integer.parseInt(order_num));
		member=memberdao.getMember(order.getORDER_MEMBER_ID());
		request.setAttribute("order", order);
		request.setAttribute("ordermember", member);
		
		forward.setPath("./adminorder/admin_order_modify.jsp");
		return forward;
	 } 
}