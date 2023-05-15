// 
// 
// 

package pers.hdh.web.servlet;

import pers.hdh.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;
import pers.hdh.beans.User;
import javax.servlet.http.Cookie;
import java.sql.SQLException;
import pers.hdh.utils.BeanFactory;
import pers.hdh.service.UserService;
import pers.hdh.utils.MD5Utils;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UserServlet extends BaseServlet
{
    public String loginUI(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        return "jsp/index.jsp";
    }
    
    public String login(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final String stuid = request.getParameter("stuid");
        final String password = MD5Utils.md5(request.getParameter("password"));
        User user = null;
        try {
            final UserService service = (UserService)BeanFactory.getBean("UserService");
            user = service.getByStuidAndPWD(stuid, password);
        }
        catch (SQLException e) {
            this.logger.error("user\u8868\u67e5\u8be2\u8bb0\u5f55\u5931\u8d25");
            return "/";
        }
        if (user == null) {
            request.setAttribute("msg", (Object)"\u4e0d\u5b58\u5728\u7684\u8d26\u6237\u6216\u5bc6\u7801\u9519\u8bef");
            return "/";
        }
        final String[] saveArr = request.getParameterValues("save");
        if (saveArr != null) {
            switch (saveArr.length) {
                case 2: {
                    final Cookie c = new Cookie("savePwd", password);
                    c.setPath(String.valueOf(request.getContextPath()) + "/");
                    c.setMaxAge(86400);
                    response.addCookie(c);
                }
                case 1: {
                    final Cookie c = new Cookie("saveStuid", stuid);
                    c.setPath(String.valueOf(request.getContextPath()) + "/");
                    c.setMaxAge(86400);
                    response.addCookie(c);
                    break;
                }
            }
        }
        request.getSession().setAttribute("user", (Object)user);
        response.sendRedirect(String.valueOf(request.getContextPath()) + "/task?method=getTasks&currPage=1&category=&desc=&state=");
        return null;
    }
    
    public String registUI(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        return "jsp/regist.jsp";
    }
    
    public String add(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final User user = new User();
        BeanUtils.populate((Object)user, request.getParameterMap());
        user.setUid(UUIDUtils.setId());
        user.setPassword(MD5Utils.md5(user.getPassword()));
        try {
            final UserService service = (UserService)BeanFactory.getBean("UserService");
            service.add(user);
        }
        catch (SQLException e) {
            e.printStackTrace();
            this.logger.error("user\u8868\u6dfb\u52a0\u8bb0\u5f55\u5931\u8d25");
            response.sendRedirect(String.valueOf(request.getContextPath()) + "/jsp/registError.jsp");
            return null;
        }
        response.sendRedirect(String.valueOf(request.getContextPath()) + "/jsp/registSuccess.jsp");
        return null;
    }
    
    public String logout(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
        return null;
    }
    
    public String update(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final User user = new User();
        BeanUtils.populate((Object)user, request.getParameterMap());
        user.setPassword(MD5Utils.md5(user.getPassword()));
        try {
            final UserService service = (UserService)BeanFactory.getBean("UserService");
            service.update(user);
        }
        catch (SQLException e) {
            this.logger.error("user\u8868\u4fee\u6539\u8bb0\u5f55\u5931\u8d25");
            throw e;
        }
        request.getSession().setAttribute("user", (Object)user);
        response.sendRedirect(String.valueOf(request.getContextPath()) + "/jsp/user_info.jsp");
        return null;
    }
    
    public String applyUpdatePwd(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final String stuid = request.getParameter("stuid");
        final String email = request.getParameter("email");
        try {
            final UserService service = (UserService)BeanFactory.getBean("UserService");
            final User user = service.getByStuidAndEmail(stuid, email);
            if (user == null) {
                request.setAttribute("message", (Object)"\u7533\u8ff0\u5931\u8d25\uff0c\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u8d26\u53f7\u548c\u7ed1\u5b9a\u7684\u90ae\u7bb1");
                return "jsp/apply_msg.jsp";
            }
        }
        catch (SQLException e) {
            this.logger.error("user\u8868\u67e5\u8be2\u8bb0\u5f55\u5931\u8d25");
            throw e;
        }
        request.setAttribute("message", (Object)"\u7533\u8ff0\u6210\u529f\uff0c\u8bf7\u524d\u5f80\u60a8\u7684\u90ae\u7bb1\u67e5\u770b\u7533\u8ff0\u7ed3\u679c");
        return "jsp/apply_msg.jsp";
    }
    
    public String updateUI(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        request.setAttribute("uid", (Object)request.getParameter("uid"));
        return "jsp/update.jsp";
    }
    
    public String updatePwd(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        try {
            final UserService service = (UserService)BeanFactory.getBean("UserService");
            System.out.print(request.getParameter("uid"));
            final User user = service.getByUid(request.getParameter("uid"));
            user.setPassword(MD5Utils.md5(request.getParameter("password")));
            service.update(user);
        }
        catch (SQLException e) {
            this.logger.error("user\u8868\u4fee\u6539\u8bb0\u5f55\u5931\u8d25");
            throw e;
        }
        request.setAttribute("message", (Object)"\u5bc6\u7801\u4fee\u6539\u6210\u529f\uff0c\u60a8\u53ef\u4ee5\u4f7f\u7528\u65b0\u5bc6\u7801\u767b\u5f55\u8d26\u53f7\u3002");
        return "jsp/apply_msg.jsp";
    }
}
