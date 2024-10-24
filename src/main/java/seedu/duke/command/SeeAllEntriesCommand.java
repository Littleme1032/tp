package seedu.duke.command;

import seedu.duke.financial.FinancialEntry;
import seedu.duke.financial.FinancialList;

import java.time.LocalDate;

/**
 * Command to print all entries recorded in the financial list.
 */
public class SeeAllEntriesCommand extends Command {
    private LocalDate start;
    private LocalDate end;

    /**
     * Constructor for SeeAllEntriesCommand.
     *
     * @param start Start date of all entries to be listed, null if no start date to be specified.
     * @param end End date of all entries to be listed, null if no end date to be specified.
     */
    public SeeAllEntriesCommand(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Method to determine if an entry should be listed out based on its date.
     *
     * @param entry Financial Entry to analyze.
     * @return true if entry should be listed out, false otherwise.
     */
    private boolean shouldBeIncluded(FinancialEntry entry) {
        return (end == null || entry.getDate().isBefore(end)) && (start == null || entry.getDate().isAfter(start));
    }

    /**
     * Executes the SeeAllEntriesCommand, listing out all entries.
     *
     * @param list The financial list on which the command will operate.
     */
    @Override
    public void execute(FinancialList list) {
        System.out.println("--------------------------------------------");
        String entryList = "";
        int entryCount = 0;

        for (int i = 0; i < list.getEntryCount(); i++) {
            FinancialEntry entry = list.getEntry(i);
            if (shouldBeIncluded(entry)) {
                entryList += (++entryCount) + ". " + entry + System.lineSeparator();
            }
        }

        if (entryCount == 0) {
            System.out.println("No entries found.");
            System.out.println("--------------------------------------------");
            return;
        }
        System.out.println("Here's a list of all recorded entries:");
        System.out.print(entryList);
        System.out.println("--------------------------------------------");
    }
}
