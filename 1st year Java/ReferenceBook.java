/**
 * Created by Evaldas on 2015-02-10.
 */
public class ReferenceBook extends NonFiction {
    ReferenceBook(String name, String refNum, int copiesOwned, int yearPublished){
        super(name, refNum, copiesOwned, yearPublished);
    }

    public String toString(){
        String refInfo = "";
        refInfo += refNum + " Owned: " + copiesOwned + " On loan:" + onLoan + " " + name + " " + yearPublished;
        return refInfo;
    }

    public String borrowBook(){
        return "Sorry, but reference books are not allowed to borrow";
    }
}
