package hanze.nl.infobord;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import java.nio.channels.Selector;

public class ListenerStarter implements Runnable, ExceptionListener {

    public ListenerStarter(Selector selector, Boolean b) {

    }

    @Override
    public void run() {

    }

    @Override
    public void onException(JMSException exception) {

    }

//TODO	Implementeer de starter voor de messagelistener:
//		Zet de verbinding op met de messagebroker en start de listener met 
//		de juiste selector.

}