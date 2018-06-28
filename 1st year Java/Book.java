/**
 * Created by Evaldas on 2015-02-10.
 */
public abstract class Book {
    public String name;
    public String refNum;
    public int copiesOwned;
    public int onLoan;

    public String toString(){
        String bookInfo = "";
        bookInfo += refNum + "Owned: " + copiesOwned + "On loan:" + onLoan + " " + name;
        return bookInfo;
    }

    public String borrowBook(){
        if (copiesOwned>0){
            copiesOwned = copiesOwned - 1;
            onLoan = onLoan + 1;
            return "You just borrowed a book !";
        }
        else {
            return "There are no books available please come back later";
        }
    }

    public String returnBook(){
        if (onLoan > 0){
            onLoan = onLoan - 1;
            copiesOwned = copiesOwned + 1;
            return "Your return is appreciated";
        }
        else{
            return "You did not return a book, because you do not have any on loan";
        }
    }
    Book(String name, String refNum, int copiesOwned){
        this.name = name;
        this.refNum = refNum;
        this.copiesOwned = copiesOwned;
    }
}
