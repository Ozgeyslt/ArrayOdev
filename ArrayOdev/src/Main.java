import java.util.*;


public class Main {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();

        stringList.add("kalem");
        stringList.add("Elalem5");
        stringList.add("kelam");
        stringList.add("kelime");

        kucukHarfeCevir(stringList);

        System.out.println(stringList);

        stringList=tekrarEdenHarfleriFiltrele(stringList);
        System.out.println(stringList);

        String result=kelimeYaz(stringList);
        System.out.println(result);
    }
    public static List<String> kucukHarfeCevir(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            String k = input.get(i);
            k = k.toLowerCase().replaceAll("[^a-z]", "");
            input.set(i, k);
        }
        return input;
    }

    public static List<String> tekrarEdenHarfleriFiltrele(List<String> input) {
        List<String> result = new ArrayList<>();

        for (String word : input) {
            if (tekrarEdenHarfler(word)) {
                result.add(word);
            }
        }

        return result;
    }

    private static boolean tekrarEdenHarfler(String word) {
        Map<Character, Integer> letterCounts = new HashMap<>();

        for (char c : word.toCharArray()) {
            letterCounts.put(c, letterCounts.getOrDefault(c, 0) + 1);
        }

        for (int count : letterCounts.values()) {
            if (count >= 2) {
                return true;
            }
        }

        return false;
    }

    public static String kelimeYaz(List<String> input) {
        StringBuilder newWord = new StringBuilder();
        Random random = new Random();

        for (String word : input) {
            int wordLength = word.length();

            int lettersToTake = random.nextInt(wordLength) + 1;

            char[] shuffledWord = word.toCharArray();
            for (int i = 0; i < wordLength; i++) {
                int randomIndex = random.nextInt(wordLength);
                char temp = shuffledWord[i];
                shuffledWord[i] = shuffledWord[randomIndex];
                shuffledWord[randomIndex] = temp;
            }

            for (int i = 0; i < lettersToTake; i++) {
                newWord.append(shuffledWord[i]);
            }
        }

        return newWord.toString();
    }
}
