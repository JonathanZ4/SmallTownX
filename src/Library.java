import java.util.ArrayList;

public class Library {
        // Add the missing implementation to this class
     private String address;
        ArrayList<Book> Books = new ArrayList<Book>();
     public Library(String address) {
        this.address = address;
     }

        public static void main(String[] args) {

            // Create two libraries
            Library firstLibrary = new Library("10 Main St.");
            Library secondLibrary = new Library("228 Liberty St.");

            // Add four books to the first library
            // that new book is creating a book to add inside the library (refer to line 113)
            firstLibrary.addBook(new Book("The Da Vinci Code"));
            firstLibrary.addBook(new Book("Le Petit Prince"));
            firstLibrary.addBook(new Book("A Tale of Two Cities"));
            firstLibrary.addBook(new Book("The Lord of the Rings"));

            // Print opening hours and the addresses
            System.out.println("Library hours:");
            printOpeningHours();
            System.out.println();

            System.out.println("Library addresses:");
            firstLibrary.printAddress();
            secondLibrary.printAddress();
            System.out.println();

            // Try to borrow The Lords of the Rings from both libraries
            System.out.println("Borrowing The Lord of the Rings:");
            firstLibrary.borrowBook("The Lord of the Rings");
            firstLibrary.borrowBook("The Lord of the Rings");
            secondLibrary.borrowBook("The Lord of the Rings");
            System.out.println();

            // Print the titles of all available books from both libraries
            System.out.println("Books available in the first library:");
            firstLibrary.printAvailableBooks();
            System.out.println();
            System.out.println("Books available in the second library:");
            secondLibrary.printAvailableBooks();
            System.out.println();

            // Return The Lords of the Rings to the first library
            System.out.println("Returning The Lord of the Rings:");
            firstLibrary.returnBook("The Lord of the Rings");
            System.out.println();

            // Print the titles of available from the first library
            System.out.println("Books available in the first library:");
            firstLibrary.printAvailableBooks();
        }




        public void addBook(Book bookTitle) {
         Books.add(bookTitle);

        }

        public void printAddress() {

         System.out.println(address);

        }

        public void borrowBook(String bookTitle) {
        boolean doesNotExist = false;
         for (int i=0; i< Books.size(); i++ ) {
             //The line is stating if the book I want exists inside of the catalog of the library
             if (bookTitle.equals(Books.get(i).getTitle())  ) {
                 if (Books.get(i).isBorrowed()) {
                     System.out.println("Sorry, this book is already borrowed.");
                     Books.remove(Books.get(i));

                 } else {
                     System.out.println("You successfully borrowed " + bookTitle);
                     Books.get(i).borrowed();
                 }
             } else
                 doesNotExist = true;
         }
            if (!doesNotExist)
                System.out.println("Sorry, this book is not in our catalog.");
        }

        public void printAvailableBooks() {

         if (Books.size() == 0) {
             System.out.println("No books in catalog.");
         }
        for (int i = 0; i< Books.size(); i++ )
            System.out.println(Books.get(i).getTitle());
        }

        public void returnBook(String bookTitle) {
            boolean exist = false;
            for (int i = 0; i < Books.size(); i++) {
                //If the book that I got from the library exists in the catalog then I should return it
                if (Books.get(i).getTitle().equals(bookTitle)) {
                    exist = true;
                    Books.get(i).returned();
                } else
                    exist = false;
            }
            if (!exist) {
                Books.add(new Book (bookTitle));
                System.out.println("You successfully returned " + bookTitle);

            }
        }





        public static void printOpeningHours() {

         System.out.print("Libraries are open daily from 9am to 5pm.");

        }

    }

