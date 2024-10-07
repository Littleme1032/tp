package seedu.duke;

import java.util.ArrayList;

/**
 * Represents the list of financial entries (income and expenses).
 * Provides methods for adding, deleting, and viewing entries.
 */
public class FinancialList {
    private ArrayList<FinancialEntry> entries;

    /**
     * Constructs a FinancialList object with an empty list.
     */
    public FinancialList() {
        entries = new ArrayList<>();
    }

    /**
     * Adds a new financial entry to the list.
     *
     * @param entry The financial entry (income or expense) to be added.
     */
    public void addEntry(FinancialEntry entry) {
        entries.add(entry);
    }
    
}
