package com.company;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Scanner sc2 = new Scanner(System.in);

    static Message blank = new Message("", "");

    static MessageList one = new MessageList(blank);
    static MessageList two = new MessageList(blank);;
    static MessageList three = new MessageList(blank);;
    static String p;

    public static void main(String[] args) {
        System.out.println("Welcome to the talk-to-yourself message simulator!");
        setPhoneNumber();
    }

    public static void setPhoneNumber()
    {
        System.out.println("Please input your phone number.");
        p = sc2.next();
        selectRoom();
    }

    public static void selectRoom()
    {
        System.out.println("Please enter chatroom 1, 2, or 3.");
        int chatroom = sc.nextInt();

        if (chatroom == 1) options(one);
        if (chatroom == 2) options(two);
        if (chatroom == 3) options(three);

    }

    public static void options(MessageList chat)
    {
        System.out.println("(1) to enter a message." +
                "\n(2) to delete a message." +
                "\n(3) to move a message to a different chat." +
                "\n(4) to display chat." +
                "\n(5) to clear a chat." +
                "\n(6) to enter a different chatroom." +
                "\n(7) to enter a different phone number." +
                "\nOr type anything to exit.");
        int choice = sc.nextInt();

        if (choice == 1)
        {
            System.out.println("Please type your message.");
            String m = sc2.next();

            chat.add(new Message(p, m));
            options(chat);
        }

        else if (choice == 2)
        {
            System.out.println("Please type the time of your message in this exact format: (hh:mm:ss)");
            String td = sc2.next();
            chat.remove(td);
            options(chat);
        }

        else if (choice == 3)
        {
            System.out.println("Please type the time of your message in this exact format: (hh:mm:ss)");
            String time = sc2.next();
            System.out.println("Please enter the chatroom number you wish to move it to.");
            int room = sc.nextInt();
            if (room == 1) chat.move(time, one);
            if (room == 2) chat.move(time, two);
            if (room == 3) chat.move(time, three);
            options(chat);
        }

        else if (choice == 4)
        {
            chat.MessageDisplayAll();
            options(chat);
        }

        else if (choice == 5)
        {
            chat.clear();
            options(chat);
        }

        else if (choice == 6)
        {
            selectRoom();
        }

        else if (choice == 7)
        {
            setPhoneNumber();
        }
        else
        {
            System.out.println("Goodbye!");
        }
    }
}
