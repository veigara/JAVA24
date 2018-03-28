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

	

	    //Ĭ�������û���
	    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	    //Ĭ����������
	    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	    //Ĭ�����ӵ�ַ
	    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	    //���͵���Ϣ����
	    private static final int SENDNUM = 10;

	    public static void main(String[] args) {
	        //���ӹ���
	        ConnectionFactory connectionFactory;
	        //����
	        Connection connection = null;
	        //�Ự ���ܻ��߷�����Ϣ���߳�
	        Session session;
	        //��Ϣ��Ŀ�ĵ�
	        Destination destination;
	        //��Ϣ������
	        MessageProducer messageProducer;
	        //ʵ�������ӹ���
	        
	        connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BROKEURL);

	        try {
	            //ͨ�����ӹ�����ȡ����
	            connection = connectionFactory.createConnection();
	            //��������
	            connection.start();
	            //����session,Session�����ǲ�����Ϣ�Ľӿڡ�����ͨ��session���������ߡ������ߡ���Ϣ�ȡ�Session�ṩ������Ĺ��ܡ�
	            /**
	             * createSession(paramA,paramB);

				paramA ȡֵ�� : true or false ��ʾ�Ƿ�֧������ 
				paramB ȡֵ��:Session.AUTO_ACKNOWLEDGE��Session.CLIENT_ACKNOWLEDGE��DUPS_OK_ACKNOWLEDGE��SESSION_TRANSACTED
				
				createSession(paramA,paramB); 
				paramA����������ģ�paramB����acknowledgment mode 
				paramA����Ϊfalseʱ��paramB��ֵ��ΪSession.AUTO_ACKNOWLEDGE��Session.CLIENT_ACKNOWLEDGE��DUPS_OK_ACKNOWLEDGE����һ���� 
				paramA����Ϊtrueʱ��paramB��ֵ���ԣ� acknowledgment mode��jms����������ΪSESSION_TRANSACTED �� 
				Session.AUTO_ACKNOWLEDGEΪ�Զ�ȷ�ϣ��ͻ��˷��ͺͽ�����Ϣ����Ҫ������Ĺ����� 
				Session.CLIENT_ACKNOWLEDGEΪ�ͻ���ȷ�ϡ��ͻ��˽��յ���Ϣ�󣬱������javax.jms.Message��acknowledge������jms�������Ż�ɾ����Ϣ�� 
				DUPS_OK_ACKNOWLEDGE��������ȷ��ģʽ��һ�����շ�Ӧ�ó���ķ������ôӴ�����Ϣ�����أ��Ự����ͻ�ȷ����Ϣ�Ľ��գ����������ظ�ȷ�ϡ�����Ҫ������Դʹ��ʱ������ģʽ�ǳ���Ч��
					             */
	            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
	            //����һ������ΪHelloWorld����Ϣ����
	            destination = session.createQueue("HelloWorld");
	            
	            //������Ϣ������
	            messageProducer = session.createProducer(destination);
	            //������Ϣ
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
	     * ������Ϣ
	     * @param session
	     * @param messageProducer  ��Ϣ������
	     * @throws Exception
	     */
	    public static void sendMessage(Session session,MessageProducer messageProducer) throws Exception{
	        for (int i = 0; i < JMSProducer.SENDNUM; i++) {
	            //����һ���ı���Ϣ 
	            TextMessage message = session.createTextMessage("ActiveMQ ������Ϣ" +i);
	            System.out.println("������Ϣ��Activemq ������Ϣ" + i);
	            //ͨ����Ϣ�����߷�����Ϣ 
	            messageProducer.send(message);
	        }

	    }
	
}
