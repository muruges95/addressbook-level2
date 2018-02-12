package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;

public class SortCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //same word, same case: matched
        assertSortCommandBehavior(Arrays.asList(td.amy, td.bill, td.candy, td.dan));
    }

    /**
     * Executes the sort command for the given address book and verifies the order and contents are correct
     */
    private void assertSortCommandBehavior(List<ReadOnlyPerson> expectedPersonList) {
        SortCommand command = createSortCommand();
        CommandResult result = command.execute();
        assertEquals(result.getRelevantPersons().get(), expectedPersonList);
    }

    private SortCommand createSortCommand() {
        SortCommand command = new SortCommand();
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
