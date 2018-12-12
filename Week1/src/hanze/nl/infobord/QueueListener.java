package hanze.nl.infobord;

import javax.jms.Message;
import javax.jms.MessageListener;

public class QueueListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        InfoBord.verwerkBericht(message.toString());
        InfoBord.getInfoBord().setRegels();
    }

//TODO 	implementeer de messagelistener die het bericht ophaald en
//		doorstuurd naar verwerkBericht van het infoBord.
//		Ook moet setRegels aangeroepen worden.
}

