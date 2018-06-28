/**
 * Created by Evaldas on 2015-02-10.
 */
public class NonFiction extends Book {
    public int yearPublished;
    NonFiction(String name, String refNum, int copiesOwned, int yearPublished){
        super(name, refNum, copiesOwned);
        this.yearPublished = yearPublished;
    }

    public String toString(){
        String nonficInfo = "";
        nonficInfo += refNum + " Owned: " + copiesOwned + " On loan:" + onLoan + " " + name + " " + yearPublished;
        return  nonficInfo;
    }
}
