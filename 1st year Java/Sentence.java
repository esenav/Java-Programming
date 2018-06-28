/**
 * Created by Evaldas on 2015-02-01.
 */
public class Sentence {
    private String[] words;

    public Sentence(String[] words){
        this.words = words;
    }
    public String toString(){
        String sen = "";
        for(String a :words ){
            sen += a+ " ";}
        return sen;
    }

    public String shortest(){
        if(words == null || words.length<1){return "";}
        String first = words[0];
        for(int i = 0; i < words.length; i++){
            if(words[i].length()< first.length()){
                first = words[i];
            }
        }
        return first;
    }
    public String longest(){
        int max = 0;
        String longestWord = null;
        for(String a :words){
            if(a.length()>max){
                max = a.length();
                longestWord = a;
            }
        }
        return longestWord;
    }
    public String[] sorted(){
        java.util.Arrays.sort(words);
       return words;
    }
    public double meanLength() {
        double sum = 0.0;
        double average = 0;
        for (int i = 0; i < words.length; i++) {
            sum = sum + i;
            average = sum/ words.length;
        }
        return average;
    }
    public static void main(String[] args){
        String[] wordList = {"A", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog"};
        Sentence text = new Sentence(wordList);
        System.out.println(text);
        System.out.println("Shortest word:"+ text.shortest());
        System.out.println("Longest word: "+text.longest());
        System.out.printf("Mean word length:%5.2f\n", text.meanLength());
        System.out.println();

        String[] sortedtext = text.sorted();
        System.out.println(text);
        System.out.println("Sorted: ");
        for(String s: sortedtext)
            System.out.print(s + ",");
        System.out.println();
    }
}