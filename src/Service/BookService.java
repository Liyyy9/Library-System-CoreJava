package Service;

import Model.Books;
import Model.Members;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookService {
    private HashMap<String, Books> bookList = new HashMap<>();

    public void add(String title, String author, String bookId) {
        String cleanedTitle = cleanInput(title);
        String cleanedAuthor = cleanInput(author);
        String cleanedBookId = cleanInput(bookId);

        if(bookList.containsKey(cleanedBookId)){
            System.out.println("\nBook ID already exists!");
            return;
        }
        Books newBook = new Books(cleanedTitle, cleanedAuthor, cleanedBookId);
        bookList.put(cleanedBookId, newBook);
        System.out.printf("\n%s by %s has been added successfully!", cleanedTitle, cleanedAuthor);
    }

    public void edit(String searchedId, Scanner scanner){
        String cleanedSearchedId = cleanInput(searchedId);

        if (!bookList.containsKey(cleanedSearchedId)){
            System.out.println("\nBook does not exist!");
            return;
        }

        Books existingBook = bookList.get(cleanedSearchedId);
        System.out.println("\nCurrent Book Details");
        System.out.println(existingBook);

        System.out.print("\nNew title: ");
        String newTitle = cleanInput(scanner.nextLine());
        System.out.print("New Author: ");
        String newAuthor = cleanInput(scanner.nextLine());
        System.out.print("New Book Id: ");
        String newBookId = cleanInput(scanner.nextLine());

        bookList.remove(searchedId);
        Books newBook = new Books(newTitle, newAuthor, newBookId);
        bookList.put(newBookId, newBook);
        System.out.println(bookList);
    }

    public void searchForBook(String searchedName, Scanner scanner){
        String cleanedSearchedName = cleanInput(searchedName);

        for (Map.Entry<String, Books> entry : bookList.entrySet()){
            Books book = entry.getValue();

            if(!book.getTitle().equals(cleanedSearchedName)){
                System.out.printf("\n'%s' not found!", searchedName);
                return;
            }
                System.out.println(book);

        }
    }

    public void listBooks(){
        System.out.println("\nList of Books:");
        for(Map.Entry book : getBookList().entrySet()){
            System.out.println(book);
        }
    }

    public String cleanInput(String input){
        Members members = new Members();
        return members.cleanInput(input);
    }

    public HashMap<String, Books> getBookList(){
        return bookList;
    }
}
