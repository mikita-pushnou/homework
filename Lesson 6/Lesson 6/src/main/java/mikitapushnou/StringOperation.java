package mikitapushnou;

public class StringOperation {
    private static final String SENTENCE = "Lorem ipsum dolor sit amet";

    public String concatSeveralStrings(String... strings) {
        String result = "";
        for (String string : strings) {
            result = result.concat(string);
        }

        return result;
    }

    public double getDecimaOfTheSizeOfTheString(String string) {
        return 1 / string.length();
    }

    public String addStringToTheEndOfTheSentence(String string) {
        return SENTENCE + " " + string;
    }

    public String addStringToTheBeginningOfTheSentence(String string) {
        return string + " " + SENTENCE;
    }

    public String addStringToTheMiddleOfTheSentence(String string) {
        int position = SENTENCE.length() / 2;
        String result = "";
        char[] chars = SENTENCE.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            result = (i == position) ? result + " " + string + " " : result + chars[i];
        }

        return result;
    }
}
