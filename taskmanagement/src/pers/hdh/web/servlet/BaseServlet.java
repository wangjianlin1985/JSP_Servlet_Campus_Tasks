// 
// 
// 

package pers.hdh.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import java.lang.reflect.Method;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet
{
    protected Logger logger;
    
    public BaseServlet() {
        this.logger = LogManager.getLogger((Class)this.getClass());
    }
    
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String methodName = req.getParameter("method");
        this.logger.debug("\u6267\u884c\u7684\u65b9\u6cd5\uff1a" + methodName);
        try {
            final Class<? extends BaseServlet> cls = this.getClass();
            if (cls != null) {
                final Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
                if (method != null) {
                    final String result = (String)method.invoke(this, req, resp);
                    if (result != null) {
                        req.getRequestDispatcher(result).forward((ServletRequest)req, (ServletResponse)resp);
                    }
                }
                else {
                    this.logger.error("\u83b7\u53d6\u4e0d\u5230Method\u5bf9\u8c61");
                }
            }
            else {
                this.logger.error("\u83b7\u53d6\u4e0d\u5230Class\u5bf9\u8c61");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msg", (Object)"\u64cd\u4f5c\u9519\u8bef");
            req.getRequestDispatcher("jsp/message.jsp").forward((ServletRequest)req, (ServletResponse)resp);
        }
    }
}
