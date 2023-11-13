
import java.util.ArrayList;
import java.util.Collections;

class Sort_Vowels_in_a_String {
    public String sortVowels(String s) {
        StringBuilder result = new StringBuilder();
        ArrayList<Character> vowels = new ArrayList<>();
        ArrayList<Integer> indices = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                vowels.add(c);
                indices.add(i);
            } else {
                result.append(c);
            }
        }

        Collections.sort(vowels);

        for (int i = 0; i < indices.size(); i++) {
            int index = indices.get(i);
            char vowel = vowels.get(i);
            result.insert(index, vowel);
        }

        return result.toString();
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
