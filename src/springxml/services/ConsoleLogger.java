package springxml.services;

public class ConsoleLogger implements LoggerService{

    @Override
    public void info(String message) {
        System.out.println("\033[36;1mINFO: "+ message + "\033[0;m");
    }

    @Override
    public void error(String message) {
        System.out.println("\033[31;1mERROR: "+ message + "\033[0;m");
    }

    @Override
    public void warning(String message) {
        System.out.println("\033[33;1mWARNING: "+ message + "\033[0;m");
    }
}
