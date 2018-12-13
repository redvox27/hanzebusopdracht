package hanze.nl.infobord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class QueueListener implements MessageListener {

    public QueueListener() {
        InfoBord infoBord = InfoBord.getInfoBord();
    }

    private static final Logger logger = LoggerFactory.getLogger(QueueListener.class);

    @Override
    public void onMessage(Message message) {
        try {
            logger.info("halte " + message.getStringProperty("HALTE"));
            logger.info("richting " + message.getStringProperty("RICHTING"));
            TextMessage textMessage = (TextMessage) message;
            InfoBord infoBord = InfoBord.getInfoBord();
            infoBord.verwerkBericht(textMessage.getText());
            infoBord.setRegels();
        } catch (JMSException e) {
            logger.error("Textmessage niet verwerkt", e);
        }
    }

//TODO 	implementeer de messagelistener die het bericht ophaald en
//		doorstuurd naar verwerkBericht van het infoBord.
//		Ook moet setRegels aangeroepen worden.
}

