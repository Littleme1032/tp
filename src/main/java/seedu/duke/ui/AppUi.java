package seedu.duke.ui;

import seedu.duke.financial.FinancialList;
import seedu.duke.parser.InputParser;

import java.util.HashMap;
import java.util.Scanner;

public class AppUi {
    public FinancialList financialList;

    public AppUi() {
        financialList = new FinancialList();
    }

    public boolean matchCommand(String command, HashMap<String, String> commandArguments) {
        return true;
    }

    public void commandEntry() {
        HashMap<String, String> commandArguments;
        String input;
        Scanner scanner = new Scanner(System.in);

        boolean isAcceptingInput = true;

        while (isAcceptingInput) {
            input = scanner.nextLine();
            commandArguments = InputParser.parseCommands(input);
            String command = commandArguments.get(InputParser.COMMAND);

            try {
                isAcceptingInput = matchCommand(command, commandArguments);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void displayWelcomeMessage() {
        final String logo = " ______  _                                   ____              _      _        \n" +
                "|  ____|(_)                                 |  _ \\            | |    | |       \n" +
                "| |__    _  _ __    __ _  _ __    ___   ___ | |_) | _   _   __| |  __| | _   _ \n" +
                "|  __|  | || '_ \\  / _` || '_ \\  / __| / _ \\|  _ < | | | | / _` | / _` || | | |\n" +
                "| |     | || | | || (_| || | | || (__ |  __/| |_) || |_| || (_| || (_| || |_| |\n" +
                "|_|     |_||_| |_| \\__,_||_| |_| \\___| \\___||____/  \\__,_| \\__,_| \\__,_| \\__, |\n" +
                "                                                                          __/ |\n" +
                "                                                                         |___/ \n";
        final String welcomeMessage = "--------------------------------------------\n" +
                "Welcome to FinanceBuddy!\n" +
                "Your one stop solution for financial peace of mind\n" +
                "How can I help you today? :)\n" +
                "--------------------------------------------\n";

        System.out.println(logo);
        System.out.println(welcomeMessage);
    }

    public void run() {
        displayWelcomeMessage();
    }
}
