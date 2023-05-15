// 
// 
// 

package pers.hdh.web.filter;

import javax.servlet.FilterConfig;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.FilterChain;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.Filter;

public class EncodingFilter implements Filter
{
    public void destroy() {
    }
    
    public void doFilter(final ServletRequest req, final ServletResponse resp, final FilterChain chain) throws ServletException, IOException {
        final HttpServletRequest request = (HttpServletRequest)req;
        final HttpServletResponse response = (HttpServletResponse)resp;
        chain.doFilter((ServletRequest)new MyRequest(request), resp);
    }
    
    public void init(final FilterConfig config) throws ServletException {
    }
}
