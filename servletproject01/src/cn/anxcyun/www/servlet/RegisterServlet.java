package cn.anxcyun.www.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.anxcyun.www.control.ServiceUser;
import cn.anxcyun.www.po.User;

/**
 * 
    * @ClassName: RegisterUser
    * @Description: 注册页面
    * @author Anxc
    * @date 2019年8月22日
    *
 */
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = new String(req.getParameter("username").getBytes("iso-8859-1"), "utf-8");
		String classes =new String(req.getParameter("class").getBytes("iso-8859-1"), "utf-8");
		String number = new String(req.getParameter("number").getBytes("iso-8859-1"), "utf-8");
		String sex = new String(req.getParameter("sex").getBytes("iso-8859-1"), "utf-8");
		String tel = new String(req.getParameter("tel").getBytes("iso-8859-1"), "utf-8");
		ServiceUser serviceUser = new ServiceUser();
		User user =new User();
		
		//赋值初始化
		user.setU_name(name);
		user.setU_classes(classes);
		user.setU_number(number);
		user.setU_sex(sex);
		user.setU_tel(tel);
		
		//调用函数
		boolean flag = serviceUser.InsertUser(user);
		String JDBCInfo = "error";
		if(flag) {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			System.out.println("成功");
		}
		else {
			resp.getWriter().write(JDBCInfo);
			System.out.println("error");
		}
	}

}
