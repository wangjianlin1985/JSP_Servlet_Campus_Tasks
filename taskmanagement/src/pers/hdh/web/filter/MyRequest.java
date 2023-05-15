// 
// 
// 

package pers.hdh.web.filter;

import java.util.Iterator;
import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

class MyRequest extends HttpServletRequestWrapper
{
    private HttpServletRequest request;
    private boolean flag;
    
    public MyRequest(final HttpServletRequest request) {
        super(request);
        this.flag = true;
        this.request = request;
    }
    
    public String getParameter(final String name) {
        final String[] arr = this.getParameterValues(name);
        if (arr == null || arr.length == 0) {
            return null;
        }
        return arr[0];
    }
    
    public String[] getParameterValues(final String name) {
        if (name == null || name.trim().length() == 0) {
            return null;
        }
        final Map<String, String[]> map = this.getParameterMap();
        if (map == null || map.size() == 0) {
            return null;
        }
        return map.get(name);
    }
    
    public Map<String, String[]> getParameterMap() {
        final String requestMethod = this.request.getMethod();
        if ("post".equalsIgnoreCase(requestMethod)) {
            try {
                this.request.setCharacterEncoding("utf-8");
                return (Map<String, String[]>)super.getParameterMap();
            }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return (Map<String, String[]>)super.getParameterMap();
            }
        }
        if ("get".equalsIgnoreCase(requestMethod)) {
            final Map<String, String[]> map = (Map<String, String[]>)super.getParameterMap();
            if (this.flag) {
                for (final String key : map.keySet()) {
                    final String[] arr = map.get(key);
                    for (int i = 0; i < arr.length; ++i) {
                        try {
                            arr[i] = URLDecoder.decode(arr[i], "UTF-8");
                        }
                        catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.flag = false;
            }
            return map;
        }
        return (Map<String, String[]>)super.getParameterMap();
    }
}
