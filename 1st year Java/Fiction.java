/**
 * Created by Evaldas on 2015-02-10.
 */
public class Fiction extends Book {
    public String author;

    Fiction(String name, String refNum, int copiesOwned, String author){
        super(name,refNum,copiesOwned);
        this.author = author;

    }

    public String toString(){
        String ficInfo = "";
        ficInfo += refNum + " Owned: " + copiesOwned + " On loan:" + onLoan + " " + name + " " + author;
        return ficInfo;
    }
}
