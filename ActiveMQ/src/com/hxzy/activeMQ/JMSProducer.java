package com.hxzy.activeMQ;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSProducer {

	

	    //默认连接用户名
	    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	    //默认连接密码
	    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	    //默认连接地址
	    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	    //发送的消息数量
	    private static final int SENDNUM = 10;

	    public static void main(String[] args) {
	        //连接工厂
	        ConnectionFactory connectionFactory;
	        //连接
	        Connection connection = null;
	        //会话 接受或者发送消息的线程
	        Session session;
	        //消息的目的地
	        Destination destination;
	        //消息生产者
	        MessageProducer messageProducer;
	        //实例化连接工厂
	        
	        connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BROKEURL);

	        try {
	            //通过连接工厂获取连接
	            connection = connectionFactory.createConnection();
	            //启动连接
	            connection.start();
	            //创建session,Session是我们操作消息的接口。可以通过session创建生产者、消费者、消息等。Session提供了事务的功能。
	            /**
	             * createSession(paramA,paramB);

				paramA 取值有 : true or false 表示是否支持事务 
				paramB 取值有:Session.AUTO_ACKNOWLEDGE，Session.CLIENT_ACKNOWLEDGE，DUPS_OK_ACKNOWLEDGE，SESSION_TRANSACTED
				
				createSession(paramA,paramB); 
				paramA是设置事务的，paramB设置acknowledgment mode 
				paramA设置为false时：paramB的值可为Session.AUTO_ACKNOWLEDGE，Session.CLIENT_ACKNOWLEDGE，DUPS_OK_ACKNOWLEDGE其中一个。 
				paramA设置为true时：paramB的值忽略， acknowledgment mode被jms服务器设置为SESSION_TRANSACTED 。 
				Session.AUTO_ACKNOWLEDGE为自动确认，客户端发送和接收消息不需要做额外的工作。 
				Session.CLIENT_ACKNOWLEDGE为客户端确认。客户端接收到消息后，必须调用javax.jms.Message的acknowledge方法。jms服务器才会删除消息。 
				DUPS_OK_ACKNOWLEDGE允许副本的确认模式。一旦接收方应用程序的方法调用从处理消息处返回，会话对象就会确认消息的接收；而且允许重复确认。在需要考虑资源使用时，这种模式非常有效。
					             */
	            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
	            //创建一个名称为HelloWorld的消息队列
	            destination = session.createQueue("HelloWorld");
	            
	            //创建消息生产者
	            messageProducer = session.createProducer(destination);
	            //发送消息
	            sendMessage(session, messageProducer);

	            session.commit();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	            if(connection != null){
	                try {
	                    connection.close();
	                } catch (JMSException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	    }
	    /**
	     * 发送消息
	     * @param session
	     * @param messageProducer  消息生产者
	     * @throws Exception
	     */
	    public static void sendMessage(Session session,MessageProducer messageProducer) throws Exception{
	        for (int i = 0; i < JMSProducer.SENDNUM; i++) {
	            //创建一条文本消息 
	            TextMessage message = session.createTextMessage("ActiveMQ 发送消息" +i);
	            System.out.println("发送消息：Activemq 发送消息" + i);
	            //通过消息生产者发出消息 
	            messageProducer.send(message);
	        }

	    }
	
}
