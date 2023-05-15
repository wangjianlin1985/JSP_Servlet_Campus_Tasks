// 
// 
// 

package pers.hdh.utils;

import java.util.Hashtable;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import com.sun.mail.util.MailSSLSocketFactory;
import java.util.Properties;

public class MailUtils
{
    private static String[] from;
    private static String host;
    
    static {
        MailUtils.from = new String[] { "yuanmamatouemail@163.com", "yuanmamatou1234" };
        MailUtils.host = "smtp.163.com";
    }
    
    public static void sendMail(final String to, final String msg) throws Exception {
        final Properties prop = new Properties();
        prop.setProperty("mail.host", MailUtils.host);
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        final MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.setProperty("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);
        final Session session = Session.getInstance(prop, (Authenticator)new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailUtils.from[0], MailUtils.from[1]);
            }
        });
        final Message message = (Message)new MimeMessage(session);
        message.setFrom((Address)new InternetAddress(MailUtils.from[0]));
        message.setRecipient(Message.RecipientType.TO, (Address)new InternetAddress(to));
        message.setSubject("\u8d26\u53f7\u7533\u8ff0\u2014\u2014\u6765\u81ea\u4efb\u52a1\u7ba1\u7406\u7cfb\u7edf\u7f51\u7ad9");
        message.setContent((Object)("<h1>\u8bf7\u70b9\u51fb<a href='http://localhost:8080/taskmanagement/user?method=updateUI&uid=" + msg + "'>\u6b64\u94fe\u63a5</a>\u8bbe\u7f6e\u65b0\u5bc6\u7801</h1>"), "text/html;charset=utf-8");
        Transport.send(message);
    }
}
