package hanze.nl.infobord;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListenerStarter implements Runnable, ExceptionListener {

    private static final Logger logger = LoggerFactory.getLogger(ListenerStarter.class);

    private String selector;

    public ListenerStarter(String selector, Boolean b) {
        this.selector = selector;
    }

    @Override
    public void run() {
        Connection connection;
        Session session;

        try {
            connection = new ActiveMQConnectionFactory("tcp://localhost:61616").createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer messageConsumer = session.createConsumer(session.createTopic(selector));
            messageConsumer.setMessageListener(new QueueListener());

            Thread.sleep(500);

            connection.close();
        } catch (JMSException e) {
            logger.error("Er is geen listener starter gerunt", e);
        } catch (InterruptedException e) {
            logger.error("Thread sleep is niet gelukt", e);
        }

    }

    @Override
    public void onException(JMSException exception) {

    }

//TODO	Implementeer de starter voor de messagelistener:
//		Zet de verbinding op met de messagebroker en start de listener met 
//		de juiste selector.

}