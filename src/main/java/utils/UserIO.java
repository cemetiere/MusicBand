package utils;

import managers.DataManager;
import managers.FileManager;

import java.io.*;
import java.util.Stack;

public class UserIO {
    private static volatile UserIO INSTANCE;
    private final Stack<InputStream> inputStack = new Stack<>();
    private Stack<OutputStream> outputStack = new Stack<>();
    private InputStreamReader isr;
    private BufferedReader br;
    private UserIO(){
        inputStack.push(System.in);
        outputStack.push(System.out);
        isr = new InputStreamReader(inputStack.getLast());
        br = new BufferedReader(isr);
    }
    public static UserIO getInstance(){
        if (INSTANCE==null){
            synchronized (DataManager.class){
                if(INSTANCE==null){
                    INSTANCE = new UserIO();
                }
            }
        }
        return INSTANCE;
    }
    private void changeInputStream(){
        isr = new InputStreamReader(inputStack.getLast());
        br = new BufferedReader(isr);
    }
    public String readLine() throws IOException {
        if(!(inputStack.getLast() instanceof FileInputStream)){
            System.out.print(">> ");
        }
        String str = br.readLine();
        if(str == null){
            inputStack.pop();
            if(!inputStack.empty()){
                changeInputStream();
            } else {
                System.out.println("Program terminated!");
                System.exit(0);
            }

        }
        return str;
    }
    public void pushInputStream(InputStream is){
        inputStack.push(is);
        changeInputStream();
    }
    public boolean isFileStreamNow(){
        return inputStack.getLast() instanceof FileInputStream;
    }
}

