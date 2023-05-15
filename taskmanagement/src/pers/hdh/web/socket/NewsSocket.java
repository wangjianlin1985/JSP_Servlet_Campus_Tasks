// 
// 
// 

package pers.hdh.web.socket;

import javax.websocket.OnMessage;
import java.sql.SQLException;
import java.io.IOException;
import pers.hdh.utils.BeanFactory;
import pers.hdh.service.RecordService;
import pers.hdh.beans.User;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class NewsSocket
{
    @OnOpen
    public void open(final Session session) {
    }
    
    @OnClose
    public void close(final Session session) {
    }
    
    @OnMessage
    public void getNews(final Session session, final String uid) throws SQLException {
        String news = "\u6ca1\u6709\u65b0\u6d88\u606f";
        final User user = new User();
        user.setUid(uid);
        final RecordService service = (RecordService)BeanFactory.getBean("RecordService");
        final Long count = service.getNews(user);
        if (count > 0) {
            news = "\u60a8\u6709" + count + "\u6761\u65b0\u6d88\u606f";
        }
        try {
            session.getBasicRemote().sendText(news);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
