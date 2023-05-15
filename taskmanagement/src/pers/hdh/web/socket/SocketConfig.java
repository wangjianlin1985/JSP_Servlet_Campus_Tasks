// 
// 
// 

package pers.hdh.web.socket;

import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.Endpoint;
import java.util.Set;
import javax.websocket.server.ServerApplicationConfig;

public class SocketConfig implements ServerApplicationConfig
{
    public Set<Class<?>> getAnnotatedEndpointClasses(final Set<Class<?>> scanned) {
        return scanned;
    }
    
    public Set<ServerEndpointConfig> getEndpointConfigs(final Set<Class<? extends Endpoint>> arg0) {
        return null;
    }
}
