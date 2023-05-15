// 
// 
// 

package pers.hdh.web.servlet;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.QueryRunner;
import pers.hdh.utils.DataSourceUtils;
import pers.hdh.beans.Admin;
import pers.hdh.utils.MD5Utils;
import org.apache.commons.beanutils.BeanUtils;
import pers.hdh.beans.User;
import pers.hdh.beans.PageBean;
import java.sql.SQLException;
import pers.hdh.utils.BeanFactory;
import pers.hdh.service.UserService;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AdminUserServlet extends BaseServlet
{
    public String getUsers(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("admin") == null) {
            return "/admin/welcome.jsp";
        }
        final int currPage = Integer.parseInt(request.getParameter("currPage"));
        final String stuid = request.getParameter("stuid");
        final String name = request.getParameter("name");
        final String category = request.getParameter("category");
        final int pageSize = 15;
        final UserService service = (UserService)BeanFactory.getBean("UserService");
        PageBean<User> pageBean;
        try {
            pageBean = service.getUsers(stuid, name, category, currPage, pageSize);
        }
        catch (SQLException e) {
            this.logger.error("\u67e5\u8be2user\u8868\u6240\u6709\u8bb0\u5f55\u5931\u8d25");
            throw e;
        }
        request.setAttribute("pageBean", (Object)pageBean);
        request.setAttribute("stuid", (Object)stuid);
        request.setAttribute("name", (Object)name);
        request.setAttribute("category", (Object)category);
        return "/admin/user/list.jsp";
    }
    
    public String getByUid(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final String uid = request.getParameter("uid");
        final UserService service = (UserService)BeanFactory.getBean("UserService");
        User user = null;
        try {
            user = service.getByUid(uid);
        }
        catch (SQLException e) {
            this.logger.error("\u901a\u8fc7uid\u67e5\u8be2user\u8868\u5931\u8d25");
            throw e;
        }
        request.setAttribute("user", (Object)user);
        return "/admin/user/edit.jsp";
    }
    
    public String update(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("admin") == null) {
            return "/admin/welcome.jsp";
        }
        final User user = new User();
        BeanUtils.populate((Object)user, request.getParameterMap());
        user.setPassword(MD5Utils.md5(user.getPassword()));
        final UserService service = (UserService)BeanFactory.getBean("UserService");
        try {
            service.update(user);
        }
        catch (SQLException e) {
            this.logger.error("\u7ba1\u7406\u5458:\u4fee\u6539user\u8868\u6570\u636e\u5931\u8d25");
            throw e;
        }
        response.sendRedirect(String.valueOf(request.getContextPath()) + "/adminUser?method=getUsers&currPage=1&stuid=&name=&category=");
        return null;
    }
    
    public String delete(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("admin") == null) {
            return "/admin/welcome.jsp";
        }
        final String uid = request.getParameter("uid");
        final UserService service = (UserService)BeanFactory.getBean("UserService");
        try {
            service.delete(uid);
        }
        catch (SQLException e) {
            this.logger.error("\u7ba1\u7406\u5458\uff1a\u5220\u9664user\u8868\u8bb0\u5f55\u5931\u8d25");
            throw e;
        }
        response.sendRedirect(String.valueOf(request.getContextPath()) + "/adminUser?method=getUsers&currPage=1&stuid=&name=&category=");
        return null;
    }
    
    public String deleteUsers(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("admin") == null) {
            return "/admin/welcome.jsp";
        }
        final String uids_str = request.getParameter("uids_str");
        final String[] uids = uids_str.trim().split(" ");
        final UserService service = (UserService)BeanFactory.getBean("UserService");
        try {
            service.delete(uids);
        }
        catch (SQLException e) {
            this.logger.error("\u7ba1\u7406\u5458\uff1a\u5220\u9664user\u8868\u8bb0\u5f55\u5931\u8d25");
            throw e;
        }
        response.sendRedirect(String.valueOf(request.getContextPath()) + "/adminUser?method=getUsers&currPage=1&stuid=&name=&category=");
        return null;
    }
    
    public String login(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        final String sql = "select aid, username, password from admin where username=? and password=? ";
        final Admin admin = (Admin)new QueryRunner(DataSourceUtils.getDataSource()).query(sql, (ResultSetHandler)new BeanHandler((Class)Admin.class), new Object[] { username, password });
        if (admin != null) {
            request.getSession().setAttribute("admin", (Object)admin);
            response.sendRedirect(String.valueOf(request.getContextPath()) + "/admin/home.jsp");
        }
        else {
            response.sendRedirect(String.valueOf(request.getContextPath()) + "/admin");
        }
        return null;
    }
}
