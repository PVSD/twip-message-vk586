package com.company;
import java.sql.Timestamp;

public class Message {

    public String wMessage;
    public String timeReceived;
    public String number;
    public String message;

    public Message(String n, String m) {
        number = n;
        message = m;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timeReceived = String.valueOf(timestamp);
        timeReceived = timeReceived.substring(11, 19);
        wMessage = n + ": " + m + " (" + timeReceived + ")";
    }

    public void changeTime()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timeReceived = String.valueOf(timestamp);
        timeReceived = timeReceived.substring(11, 19);
        wMessage = number + ": " + message + " (" + timeReceived + ")";
    }

}
