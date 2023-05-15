// 
// 
// 

package pers.hdh.web.servlet;

import pers.hdh.beans.Task;
import pers.hdh.beans.PageBean;
import java.sql.SQLException;
import pers.hdh.utils.BeanFactory;
import pers.hdh.service.TaskService;
import pers.hdh.beans.User;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TaskServlet extends BaseServlet
{
    public String getTasks(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("msg", (Object)"\u8bf7\u5148\u767b\u5f55");
            return "/jsp/message.jsp";
        }
        final String category = request.getParameter("category");
        final String desc = request.getParameter("desc");
        final String state = request.getParameter("state");
        final int currPage = Integer.parseInt(request.getParameter("currPage"));
        final int pageSize = 10;
        final TaskService service = (TaskService)BeanFactory.getBean("TaskService");
        PageBean<Task> pageBean = null;
        try {
            pageBean = service.getTasks(user, category, desc, state, currPage, pageSize);
        }
        catch (SQLException e) {
            this.logger.error("task\u8868\u67e5\u8be2\u8bb0\u5f55\u5931\u8d25");
            throw e;
        }
        request.setAttribute("pageBean", (Object)pageBean);
        request.setAttribute("category", (Object)category);
        request.setAttribute("desc", (Object)desc);
        return "/jsp/task_list.jsp";
    }
}
