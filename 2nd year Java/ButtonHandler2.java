
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

/**
 * Created by Evaldas on 2015-11-01.
 */
public class ButtonHandler2 implements ActionListener {
    public CE203_2015_Ex2 TheApplet;
    ButtonHandler2(CE203_2015_Ex2 d){
        TheApplet = d;          //Constructor
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{        //Try block for Add Button any exception caught displays message
            if(e.getSource()==TheApplet.add) {
                if(TheApplet.list1.add(TheApplet.field.getText())){
                    TheApplet.output.setText("Word"+" "+TheApplet.field.getText()+" "+"has been added to the list");
                }
                else
                    TheApplet.output.setText("The string"+TheApplet.field.getText()+" "+"was not added to the list as it is not a valid word");
            }
        }
        catch (Exception y){
            TheApplet.output.setText("The string"+TheApplet.field.getText()+" "+"was not added to the list as it is not a valid word");
        }
        try{        //Try block for Search button, any exception caught should bring a message
            if(e.getSource()==TheApplet.search){
                int y=0;
                if (TheApplet.list1.contains(TheApplet.field.getText())){
                    int n = Collections.frequency(TheApplet.list1,TheApplet.field.getText());//Counts any inputted word frequency in a list
                    TheApplet.output.setText("'"+TheApplet.field.getText()+ "' "+"is in the list, and occurs"+ " "+n+" "+"times");
                }
                    else
                        TheApplet.output.setText("'"+TheApplet.field.getText()+"' "+"can no find this word");
                if(TheApplet.field.getText().length()==0){  //Counts how many words are in list.
                    for(String g:TheApplet.list1)
                        y++;
                    TheApplet.output.setText("Total words in a list is "+y);
                }
            }
        }
        catch (Exception k){
            TheApplet.output.setText("Can not find this word");
        }
        try{        //Try block for Remove Button
            if(e.getSource()==TheApplet.remf) {
                if(TheApplet.list1.removeFirstOccurrence(TheApplet.field.getText())){   //Removes first occurrence in a list
                TheApplet.output.setText(TheApplet.field.getText()+" "+"first occurrence has been removed");
                }
                else
                    TheApplet.output.setText("Word can not be removed, might not exist in the list");
            }
        }
        catch (Exception r){    //Any exception caught should bring this message to the output field
            TheApplet.output.setText("Can not remove first occurrence from a list");
        }
        try{        //Try block for Remove all button
            if(e.getSource()==TheApplet.remall) {
                int n = Collections.frequency(TheApplet.list1,TheApplet.field.getText()); //Counts how many words there are in a list of that specific word
                for(int i=0;i<n;i++){       //Executes a remove first occurrence method n times. I am sure there is another way to do this.
                    if(TheApplet.list1.removeFirstOccurrence(TheApplet.field.getText())) {
                        TheApplet.output.setText("All occurrences was removed");
                    }
                    else
                        TheApplet.output.setText("Cannot remove as word does not exist in the list");
                }
            }
        }
        catch (Exception b){    //Try to catch every exception and write an message
            TheApplet.output.setText("Can not remove this word, might not exist");
        }
        try{    //Try block for Clear button, removes all words from the list and set field text to null
            if(e.getSource()==TheApplet.clear) {
                TheApplet.list1.clear();
                TheApplet.field.setText(null);
                TheApplet.output.setText("List has been cleared");
            }
        }
        catch (Exception l){        //Try to catch every exception and write an message
            TheApplet.output.setText("List is already empty");
        }
        try{        //Try block for Display button
            if(e.getSource()==TheApplet.display){
                String res="";  //Making empty string
                for(String x:TheApplet.list1){
                   if(x.substring(0,1).equals(TheApplet.field.getText())){  //Taking the first letter of the word and matching it to input
                       res+=x+"\n"; //adding words to the empty string
                       TheApplet.output.setText(res);
                   }
                    else
                       TheApplet.output.setText("List does not contain words starting with this letter");
                }
            }
        }
        catch (Exception r){         //Try to catch every exception and write an message
            TheApplet.output.setText("");
        }
    }
}
