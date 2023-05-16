
public class PigLatin {
    public static void main(String[] args) {
        String str = pigLatin("Awesome");
        System.out.print(str);
    }
    
     
    static String pigLatin(String word) {

        if (isVowel(word.charAt(0))) {
            return word + "way";
        // If a word starts with a vowel add the word "way" at the end of the word.
        // Example: Awesome = Awesome +way = Awesomeway
        }

        else if (isVowel(word.charAt(1))) {
            return "Vowel ay";
            // If a word starts with a consonant and a vowel, put the first letter of the word at the end of the word and add "ay."
            // Example: Happy = appyh + ay = appyhay
        }

        else{
            return "ay";
        // If a word starts with two consonants move the two consonants to the end of the word and add "ay."
        // Example: Child = Ildch + ay = Ildchay
        }
    }


    // Check for vowel
    static boolean isVowel(char c) {
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }


}