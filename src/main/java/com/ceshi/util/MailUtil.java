package com.ceshi.util;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.util.Map;
import java.util.Properties;

public class MailUtil {
  /**
   * 发送邮件
   * @param content
   * @throws Exception
   */
  public static void send( Map<String, String> content) throws Exception {
    content.put("fromAddress","wq19950119@163.com");
    content.put("toAddress","95108181@qq.com");
    content.put("subject","登录测试邮件");
    content.put("content","<a>结果</a>：<b>登录正常</b>");
    content.put("attachPath","D:\\1.csv");
    content.put("attachName","1.csv");
//    content.put("savePath","D:\\凡达科技公司治疗");

    String user = "wq19950119"; // 用户
    String password = "wq19950119"; // 发件人邮箱客户端授权码
    Properties props = new Properties(); //可以加载一个配置文件
    // 使用smtp：简单邮件传输协议
    props.put("mail.smtp.host", "smtp.163.com");//存储发送邮件服务器的信息
    props.put("mail.smtp.auth", "true");//同时通过验证
    //使用JavaMail发送邮件的5个步骤
    //1、创建session
    Session session = Session.getInstance(props);
//    //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
//    session.setDebug("true".equals(config.getProperty("mail.Debug")) ? true : false);
    //2、通过session得到transport对象
    Transport ts = session.getTransport();
    //3、连上邮件服务器
    ts.connect(user, password);
    //4、创建邮件
    Message message = createAttachMail(session, content);
    //5、发送邮件
    ts.sendMessage(message, message.getAllRecipients());
    ts.close();
  }
  /**
   * @Method: createAttachMail
   * @Description: 创建一封带附件的邮件
   * @param session
   * @param content
   * @return
   * @throws Exception
   */
  public static MimeMessage createAttachMail(Session session, Map<String, String> content) throws Exception{
    MimeMessage message = new MimeMessage(session);
    //设置邮件的基本信息
    //发件人
    message.setFrom(new InternetAddress(content.get("fromAddress")));
    //收件人
    message.setRecipient(Message.RecipientType.TO, new InternetAddress(content.get("toAddress")));
    //邮件标题
    message.setSubject(content.get("subject"));
    //创建邮件正文，为了避免邮件正文中文乱码问题，需要使用charset=UTF-8指明字符编码
    MimeBodyPart text = new MimeBodyPart();
    text.setContent(content.get("content"), "text/html;charset=UTF-8");
    //创建容器描述数据关系
    MimeMultipart mp = new MimeMultipart();
    mp.addBodyPart(text);
    mp.setSubType("mixed");
    //创建邮件附件
    if (content.get("attachPath") != null) {
      MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource(content.get("attachPath")));//本地文件
//      DataHandler dh = new DataHandler(new URLDataSource(new URL(content.get("attachPath"))));//网络文件
      attach.setDataHandler(dh);
      //attach.setFileName(content.get("attachName"));
      attach.setFileName(MimeUtility.encodeWord(content.get("attachName"), "UTF-8", null)); //附件中文名称

      mp.addBodyPart(attach);
    }
    message.setContent(mp);
    message.saveChanges();
    //将创建的Email 存储起来
//    if (content.get("savePath") != null) {
//      message.writeTo(new FileOutputStream(content.get("savePath") + File.separator + "attachMail.eml"));
//    }

    //返回生成的邮件
    return message;
  }
  /**
   * @param args
   * @throws Exception
   */
//  public static void main(String[] args) throws Exception {
//    Map<String, String> content = new HashMap<String, String>();
//    content.put("fromAddress","wq19950119@163.com");
//    content.put("toAddress","95108181@qq.com");
//    content.put("subject","登录测试邮件");
//    content.put("content","<a>html 元素</a>：<b>邮件内容</b>");
//    content.put("attachPath","D:\\1.csv");
//    content.put("attachName","1.csv");
////    content.put("savePath","D:\\凡达科技公司治疗");
//    send(content);
//
//
//  }
}
