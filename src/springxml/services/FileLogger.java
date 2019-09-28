package springxml.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements LoggerService {
    private  String filePath="log.txt";
    private File logFile = new File(filePath);
    private FileWriter fw;
    public FileLogger() {

    }

    public FileLogger(String newPath)
    {

        filePath = newPath;

    }

    @Override
    public void info(String message) {

        writeToFile("Info: "+message + "\n");

    }

    private void writeToFile(String message)
    {
        try
        {
            fw = new FileWriter(filePath,true);
            fw.write(message);
            fw.close();
        } catch(Exception e)
        {
            System.out.println("Error: Unable To Log To File");
        }
    }

    @Override
    public void error(String message) {

        writeToFile("Error: "+message + "\n");
    }

    @Override
    public void warning(String message) {

        writeToFile("Warning: "+message + "\n");

    }
}
