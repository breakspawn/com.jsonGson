package com.gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class BlockingRS {

    private Socket socket;
    private DataOutputStream streamOut; //writeBytes();
    private BufferedReader streamIn; // readLine();

    public BlockingRS(String adress, int port) throws IOException
    {
        socket = new Socket(adress, port);
        streamOut = new DataOutputStream(socket.getOutputStream());
        streamIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        streamIn.readLine();
    }

    public String Read()
    {
        String message = "";
        try
        {
            message = streamIn.readLine();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        return message;
    }

    public boolean Send(String string)
    {
        try
        {
            streamOut.writeBytes(string);
        }
        catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
            return  false;
        }
        return  true;
    }

    public boolean Stop()
    {
        try {
            socket.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            return false;
        }
        return true;
    }
}
