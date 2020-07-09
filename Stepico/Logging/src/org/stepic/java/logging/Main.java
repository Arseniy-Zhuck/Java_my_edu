package org.stepic.java.logging;

import java.util.logging.*;

public class Main {
    public static void main(String[] args) {

    }
     private static void configureLogging() {
         Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
         Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");
         Logger loggerLogging = Logger.getLogger("org.stepic.java.logging");
         Logger loggerJava = Logger.getLogger("org.stepic.java");
         loggerA.setParent(loggerLogging);
         loggerB.setParent(loggerLogging);
         loggerLogging.setParent(loggerJava);
         loggerA.setLevel(Level.ALL);
         loggerB.setLevel(Level.WARNING);
         loggerJava.setLevel(Level.ALL);
         loggerA.setUseParentHandlers(true);
         loggerB.setUseParentHandlers(true);
         loggerLogging.setLevel(Level.ALL);
         loggerLogging.setUseParentHandlers(true);
         Handler handler = new ConsoleHandler();
         loggerJava.addHandler(handler);
         loggerJava.setUseParentHandlers(false);
         handler.setFormatter(new XMLFormatter());
         handler.setLevel(Level.ALL);
     }

}
