// 
// 
// 

package pers.hdh.web.servlet;

import pers.hdh.beans.Record;
import pers.hdh.beans.PageBean;
import java.sql.SQLException;
import pers.hdh.utils.BeanFactory;
import pers.hdh.service.RecordService;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AdminRecordServlet extends BaseServlet
{
    public String getRecords(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("admin") == null) {
            return "/admin/welcome.jsp";
        }
        final String category = request.getParameter("category");
        final String desc = request.getParameter("desc");
        final String state = request.getParameter("state");
        final String stuid = request.getParameter("stuid");
        final int currPage = Integer.parseInt(request.getParameter("currPage"));
        final int pageSize = 15;
        final RecordService service = (RecordService)BeanFactory.getBean("RecordService");
        PageBean<Record> pageBean = null;
        try {
            pageBean = service.getRecords(category, desc, state, stuid, currPage, pageSize);
        }
        catch (SQLException e) {
            this.logger.error("\u7ba1\u7406\u5458\uff1a\u67e5\u8be2record\u8868\u5931\u8d25");
            throw e;
        }
        request.setAttribute("pageBean", (Object)pageBean);
        request.setAttribute("category", (Object)category);
        request.setAttribute("desc", (Object)desc);
        request.setAttribute("state", (Object)state);
        request.setAttribute("stuid", (Object)stuid);
        return "/admin/record/list.jsp";
    }
    
    public String update(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final int state = Integer.parseInt(request.getParameter("state"));
        final String rid = request.getParameter("rid");
        final Record record = new Record();
        record.setRid(rid);
        record.setState(state);
        final RecordService service = (RecordService)BeanFactory.getBean("RecordService");
        try {
            service.update(record);
        }
        catch (SQLException e) {
            this.logger.error("\u7ba1\u7406\u5458: \u4fee\u6539record\u8868\u6570\u636e\u5931\u8d25");
            throw e;
        }
        response.sendRedirect(String.valueOf(request.getContextPath()) + "/adminRecord?method=getRecords&currPage=1&category=&desc=&state=" + state + "&stuid=");
        return null;
    }
}
