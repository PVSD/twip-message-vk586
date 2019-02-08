package com.company;
import java.util.ArrayList;

public class MessageList {

    private ArrayList<Message> mList = new ArrayList<>();

    private int count = 0;

    public MessageList(Message n)
    {
        mList.add(n);
    }

    public void add(Message n)
    {
        if (count == 0)
        {
            mList.set(0,n);
            count++;
        }
        else
        {
            mList.add(0, n);
        }
        System.out.println("Message successfully added!");
    }

    public void remove(String time)
    {
        int index = findMessage(time);
        if (index > -1)
        {
            mList.remove(index);
            System.out.println("Message deleted successfully!");
        }
        else {
            System.out.println("Message was not found!");
        }
    }

    public void display(int index)
    {
        System.out.println(mList.get(index).wMessage);
    }

    public void MessageDisplayAll()
    {
        if (mList.isEmpty()) System.out.println("No new messages!");
        else
        {
            for (int i = mList.size() - 1; i > -1; i--)
            {
                display(i);
            }
        }
    }

    public void clear()
    {
        mList.clear();
        System.out.println("Messages have been cleared!");
    }

    public void move(String time, MessageList m)
    {
        int index = findMessage(time);
        if (index > -1 && !mList.isEmpty())
        {
            Message temp = mList.get(index);
            temp.changeTime();
            mList.remove(index);
            m.add(temp);
            System.out.println("Message moved successfully!");
        }
        else
            {
            System.out.println("Message was not found!");
        }
    }

    public int findMessage(String time)
    {
        int index = -1;
        for (int i = 0; i < mList.size(); i++)
        {
            if ((mList.get(i).timeReceived).equals(time))
            {
                index = i;
            }
        }
        return index;
    }

}
