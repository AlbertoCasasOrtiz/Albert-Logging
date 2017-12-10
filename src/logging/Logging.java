package logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * API for logging messages in the console.
 * 09/12/2017 20:59:15
 *
 * @author Alberto Casas Ortiz.
 * @version 1.0.0
 */
public class Logging {
    /** Format of the date. */
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    /** Date used at logging. */
    private static Date date;
    /** Set if the console logging is enabled. */
    private static boolean log_console = true;
    /** Set if the file logging is enabled. */
    private static boolean log_file = true;
    /** Path of the file. */
    private static String file_path = "Log.log";

    /**
     * Log an error.
     * @param message Message of the error.
     */
    public static void error(String message){
        Logging.date = new Date();
        String string = "[" + Logging.dateFormat.format(Logging.date) + "] - ERROR: " + message;
        if(isLoggingConsole()) System.out.println(string);
        if(isLoggingFile()) Logging.logToFile(string);
    }

    /**
     * Log a warning.
     * @param message Message of the warning.
     */
    public static void warning(String message){
        Logging.date = new Date();
        String string = "[" + Logging.dateFormat.format(Logging.date) + "] - WARNING: " + message;
        if(isLoggingConsole()) System.out.println(string);
        if(isLoggingFile()) Logging.logToFile(string);
    }

    /**
     * Log a info.
     * @param message Message of the info.
     */
    public static void info(String message){
        Logging.date = new Date();
        String string = "[" + Logging.dateFormat.format(Logging.date) + "] - INFO: " + message;
        if(isLoggingConsole()) System.out.println(string);
        if(isLoggingFile()) Logging.logToFile(string);
    }

    /**
     * Set if the logging console is enabled or disabled.
     * @param logging True to enable the console logging, false otherwise.
     */
    public static void loggingConsole(boolean logging){
        Logging.log_console = logging;
    }

    /**
     * Return if is logging in the console.
     * @return True if the console is logging, false otherwise.
     */
    public static boolean isLoggingConsole(){
        return Logging.log_console;
    }

    /**
     * Set if the logging file is enabled or disabled.
     * @param logging True to enable the file logging, false otherwise.
     */
    public static void loggingFile(boolean logging){
        Logging.log_file = logging;
    }

    /**
     * Return if is logging in the file.
     * @return True if the file is logging, false otherwise.
     */
    public static boolean isLoggingFile(){
        return Logging.log_file;
    }

    /**
     * Set the path of the logging file.
     * @param path Path of the logging file.
     */
    public static void setFilePath(String path){
        Logging.file_path = path;
    }

    /**
     * Log information into a file.
     * @param message Logging message.
     */
    private static void logToFile(String message){
        Writer output;
        try {
            output = new BufferedWriter(new FileWriter(Logging.file_path, true));
            output.append(message).append("\n");
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
