// 
// 
// 

package pers.hdh.web.servlet;

import java.util.Iterator;
import java.util.List;
import pers.hdh.beans.PageBean;
import pers.hdh.beans.User;
import java.sql.SQLException;
import pers.hdh.utils.UUIDUtils;
import pers.hdh.utils.BeanFactory;
import pers.hdh.service.RecordService;
import pers.hdh.beans.Record;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RecordServlet extends BaseServlet
{
    public String update(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final String state = request.getParameter("state");
        final String uid = request.getParameter("uid");
        final String tid = request.getParameter("tid");
        final Record record = new Record();
        record.setState(Integer.parseInt(state));
        record.getUser().setUid(uid);
        record.getTask().setTid(tid);
        try {
            final RecordService service = (RecordService)BeanFactory.getBean("RecordService");
            final int flag = service.update(record);
            if (flag == 0) {
                record.setRid(UUIDUtils.setId());
                service.add(record);
            }
        }
        catch (SQLException e) {
            this.logger.error("record\u8868\u4fee\u6539\u8bb0\u5f55\u6216\u6dfb\u52a0\u8bb0\u5f55\u5931\u8d25");
            throw e;
        }
        response.sendRedirect(String.valueOf(request.getContextPath()) + "/task?method=getTasks&currPage=1&category=&desc=&state=");
        return null;
    }
    
    public String getMessages(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("msg", (Object)"\u8bf7\u5148\u767b\u5f55");
            return "/jsp/message.jsp";
        }
        final int currPage = Integer.parseInt(request.getParameter("currPage"));
        final int pageSize = 10;
        try {
            final PageBean<Record> pageBean = ((RecordService)BeanFactory.getBean("RecordService")).getRecords(currPage, pageSize, user);
            request.setAttribute("pageBean", (Object)pageBean);
        }
        catch (SQLException e) {
            this.logger.error("record\u8868\u67e5\u8be2\u8bb0\u5f55\u5931\u8d25");
            throw e;
        }
        return "/jsp/user_msg.jsp";
    }
    
    public String haveRead(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final String rid = request.getParameter("rid");
        try {
            final RecordService service = (RecordService)BeanFactory.getBean("RecordService");
            final Record record = service.getRecord(rid);
            record.setIs_read(1);
            service.update(record);
        }
        catch (SQLException e) {
            this.logger.error("record\u8868\u67e5\u8be2\u4e00\u6761\u8bb0\u5f55\u5931\u8d25");
            throw e;
        }
        response.sendRedirect(String.valueOf(request.getContextPath()) + "/record?method=getMessages&currPage=1");
        return null;
    }
    
    public String haveReadAll(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("msg", (Object)"\u8bf7\u5148\u767b\u5f55");
            return "/jsp/message.jsp";
        }
        try {
            final RecordService service = (RecordService)BeanFactory.getBean("RecordService");
            final List<Record> list = service.getRecords(user);
            for (final Record record : list) {
                if ((record.getIs_read() == null || record.getIs_read() == 0) && (record.getState() == 3 || record.getState() == 4)) {
                    record.setIs_read(1);
                    service.update(record);
                }
            }
        }
        catch (SQLException e) {
            this.logger.error("record\u8868\u67e5\u8be2\u591a\u6761\u8bb0\u5f55\u5931\u8d25");
            throw e;
        }
        response.sendRedirect(String.valueOf(request.getContextPath()) + "/record?method=getMessages&currPage=1");
        return null;
    }
}
