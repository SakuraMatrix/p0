public class ScrabbleTest {
    public static void main(String[] args) {
        String expected = "Hello";
        String actual = new Scrabble().word();

        if (expected.equals(actual)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
}
