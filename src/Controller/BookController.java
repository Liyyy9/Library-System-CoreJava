package Controller;

import Service.BookService;

import java.util.Scanner;

public class BookController {
    private UserInterface userInterface;
    private boolean running = true;
    private BookService bookService = new BookService();

    public void setUserInterface(UserInterface userInterface){ this.userInterface = userInterface;}

    public void start(Scanner scanner){
        while (running) {
            System.out.print("""
                    
                    =======================================================================
                    
                    Book Options:
                    1. Add new book.
                    2. Edit existing book details.
                    3. Search for book details.
                    4. Book list.
                    5. Delete book.
                    6. Back to main menu.
                    7. Quit program.
                    
                    Choose option: \s""");
            String input = scanner.nextLine();

            inputReader(input, scanner);
        }
    }

    public void inputReader(String input, Scanner scanner){
        switch (input){
            case "1" -> addNewBook(scanner);
            case "2" -> editBook(scanner);
            case "3" -> searchForBook(scanner);
            case "4" -> listBooks();
            case "5" -> deleteBook(scanner);
            case "6" -> userInterface.start(scanner);
            case "7" -> {
                System.out.println("""
                        
                        Thank you for using our Library System! Goodbye!
                        =======================================================================
                        """);
                running = false;
                userInterface.end();
            }
            default -> {
                System.out.println("Invalid option!");
            }
        }
    }

    private void editBook(Scanner scanner) {
        System.out.print("\nBook ID: ");
        String searchedId = scanner.nextLine();

        bookService.edit(searchedId, scanner);

    }

    private void searchForBook(Scanner scanner) {
        System.out.println("\nName of book: ");
        String searchedName = scanner.nextLine();

        bookService.searchForBook(searchedName, scanner);
    }

    private void listBooks() {
        bookService.listBooks();
    }

    private void deleteBook(Scanner scanner) {
    }

    public void addNewBook(Scanner scanner){
        System.out.print("\nTitle: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Book Id: ");
        String bookId = scanner.nextLine();

        bookService.add(title, author, bookId);
    }
}
