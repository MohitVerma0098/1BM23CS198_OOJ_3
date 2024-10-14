import java.util.*;

class Book{
    Scanner in = new Scanner(System.in);
    String name, author;
    int price, num_pages;
    Book(String n, String a, int p, int np){
        name = n;
        author = a;
        price = p;
        num_pages=np;
    }
    void setDetails(){
        System.out.println("Enter Book Name:");
        name=in.next();
        System.out.println("Enter Author's Name: ");
        author=in.next();
        System.out.println("Price of Book: ");
        price= in.nextInt();
        System.out.println("Enter No. of Pages in Book:");
        num_pages=in.nextInt();
    }
    void getDetails(){
        System.out.print("Book Name: "+name);
        System.out.print("Author's Name: "+author);
        System.out.print("Book Price: "+price);
        System.out.print("No. of Pages: "+num_pages);
    }
    public String toString(){
        return "Book Name: "+name+"\nAuthor's Name: "+author+"\nBook Price: "+price+"\nNo. of Pages: "+num_pages;
//        return getDetails();
    }
}

public class Lab_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noBook, j = 0;
        String s = "NA";
        System.out.print("Enter no. of Books: ");
        noBook = in.nextInt();
        Book[] bk = new Book[noBook];
        for (int i = 0; i < noBook; i++) {
            System.out.println("Book " + (i + 1));
            bk[i] = new Book(s, s, j, j);
            bk[i].setDetails();
        }
        System.out.println("\nBook Details");
        for (int k = 0; k < noBook; k++) {
            System.out.println();
//            bk[k].getDetails();
            System.out.println(bk[k].toString());
        }
    }
}