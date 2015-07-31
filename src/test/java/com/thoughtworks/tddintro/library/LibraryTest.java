package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;

public class LibraryTest {

    List<String> books;
    PrintStream printStream;
    DateTime time;
    DateTimeFormatter dateTimeFormatter;

    /*

        List books tests. Implement the first three tests for the Verify exercise

     */

    @Before
    public void setUp() {
        this.books = new ArrayList<>();
        this.printStream = mock(PrintStream.class);
        this.time = new DateTime();
        this.dateTimeFormatter = mock(DateTimeFormatter.class);
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        String title = "Book Title";
        books.add(title);
        Library library = new Library(books, printStream, null);

        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println("Book Title");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        Library library = new Library(books, printStream, null);
        library.listBooks();
        verify(printStream, never()).println();
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {
        books.add("Book Title");
        books.add("Another Book Title");
        Library library = new Library(books, printStream, null);
        library.listBooks();
        verify(printStream).println("Book Title");
        verify(printStream).println("Another Book Title");
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        Library library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
        when(dateTimeFormatter.print(time)).thenReturn("");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        // add a verify here
        verify(printStream).println("Welcome to the library! The current time is ");
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {
        // implement me
        // then move common test variables into a setup method
        when(dateTimeFormatter.print(time)).thenReturn("2015-07-27 16:33:17");

        Library library = new Library(books, printStream, dateTimeFormatter);
        library.welcome(time);

        verify(printStream).println("Welcome to the library! The current time is 2015-07-27 16:33:17");
    }
}