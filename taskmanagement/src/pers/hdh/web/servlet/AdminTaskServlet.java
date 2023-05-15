// 
// 
// 

package pers.hdh.web.servlet;

import pers.hdh.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;
import pers.hdh.beans.Task;
import pers.hdh.beans.PageBean;
import java.sql.SQLException;
import pers.hdh.utils.BeanFactory;
import pers.hdh.service.TaskService;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AdminTaskServlet extends BaseServlet
{
    public String getTasks(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("admin") == null) {
            return "/admin/welcome.jsp";
        }
        final String category = request.getParameter("category");
        final String desc = request.getParameter("desc");
        final int currPage = Integer.parseInt(request.getParameter("currPage"));
        final int pageSize = 15;
        final TaskService service = (TaskService)BeanFactory.getBean("TaskService");
        PageBean<Task> pageBean = null;
        try {
            pageBean = service.getTasks(category, desc, currPage, pageSize);
        }
        catch (SQLException e) {
            this.logger.error("\u7ba1\u7406\u5458\uff1a\u67e5\u8be2task\u8868\u6240\u6709\u8bb0\u5f55\u5931\u8d25");
            throw e;
        }
        request.setAttribute("pageBean", (Object)pageBean);
        request.setAttribute("category", (Object)category);
        request.setAttribute("desc", (Object)desc);
        return "/admin/task/list.jsp";
    }
    
    public String getByTid(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final String tid = request.getParameter("tid");
        final TaskService service = (TaskService)BeanFactory.getBean("TaskService");
        Task task = null;
        try {
            task = service.getByTid(tid);
        }
        catch (SQLException e) {
            this.logger.error("\u7ba1\u7406\u5458: \u901a\u8fc7tid\u83b7\u53d6\u4efb\u52a1\u5931\u8d25");
            throw e;
        }
        request.setAttribute("task", (Object)task);
        return "/admin/task/edit.jsp";
    }
    
    public String update(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("admin") == null) {
            return "/admin/welcome.jsp";
        }
        final Task task = new Task();
        BeanUtils.populate((Object)task, request.getParameterMap());
        final TaskService service = (TaskService)BeanFactory.getBean("TaskService");
        try {
            service.update(task);
        }
        catch (SQLException e) {
            this.logger.error("\u7ba1\u7406\u5458:\u4fee\u6539task\u8868\u6570\u636e\u5931\u8d25");
            throw e;
        }
        response.sendRedirect(String.valueOf(request.getContextPath()) + "/adminTask?method=getTasks&currPage=1&category=&desc=");
        return null;
    }
    
    public String addUI(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("admin") == null) {
            return "/admin/welcome.jsp";
        }
        return "/admin/task/add.jsp";
    }
    
    public String add(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final Task task = new Task();
        task.setTid(UUIDUtils.setId());
        BeanUtils.populate((Object)task, request.getParameterMap());
        final TaskService service = (TaskService)BeanFactory.getBean("TaskService");
        try {
            service.add(task);
        }
        catch (SQLException e) {
            this.logger.error("\u7ba1\u7406\u5458:\u6dfb\u52a0\u8bb0\u5f55\u5230task\u8868\u5931\u8d25");
            throw e;
        }
        response.sendRedirect(String.valueOf(request.getContextPath()) + "/adminTask?method=getTasks&currPage=1&category=&desc=");
        return null;
    }
    
    public String delete(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("admin") == null) {
            return "/admin/welcome.jsp";
        }
        final String tid = request.getParameter("tid");
        final TaskService service = (TaskService)BeanFactory.getBean("TaskService");
        try {
            service.delete(tid);
        }
        catch (SQLException e) {
            this.logger.error("\u7ba1\u7406\u5458\uff1a\u5220\u9664task\u8868\u8bb0\u5f55\u5931\u8d25");
            throw e;
        }
        response.sendRedirect(String.valueOf(request.getContextPath()) + "/adminTask?method=getTasks&currPage=1&category=&desc=");
        return null;
    }
    
    public String deleteTasks(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("admin") == null) {
            return "/admin/welcome.jsp";
        }
        final String tids_str = request.getParameter("tids_str");
        final String[] tids = tids_str.trim().split(" ");
        final TaskService service = (TaskService)BeanFactory.getBean("TaskService");
        try {
            service.delete(tids);
        }
        catch (SQLException e) {
            this.logger.error("\u7ba1\u7406\u5458\uff1a\u6279\u91cf\u5220\u9664task\u8868\u8bb0\u5f55\u5931\u8d25");
            throw e;
        }
        response.sendRedirect(String.valueOf(request.getContextPath()) + "/adminTask?method=getTasks&currPage=1&category=&desc=");
        return null;
    }
}
