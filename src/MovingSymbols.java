import java.util.Random;

public class MovingSymbols {
    private static final String SYMBOL =
        "     +--,-+\n" +
        "     | ' \\\\|\n" +
        "     `.   ;\n" +
        "     | ;.'|\n" +
        "     ,'  `,\n" +
        "  _,-|`-.'|.._         _.-[\n" +
        ",:....-..:>...:-     ,/' /'\n" +
        "     |  | |        <'   ,'\n" +
        "     |  | |    ,Y''     | _.-'\n" +
        "     |  | | .,'        /'\\\n" +
        "     |  | | `.  ,Y''   /\n" +
        "     |  | |   \\'    ,'\n" +
        "     |  | |    \\\\ ,-'\n" +
        "     |  | |     -\n" +
        "     ,  | ,\n" +
        "      `.|/\n" +
        "        '\n";

    public static void main(String[] args) throws InterruptedException {
        final String esc = "\u001b[";
        final String clear = esc + "H" + esc + "2J";
        final int width = 80;
        final int height = 24;
        final int symbolWidth = 20;
        final int symbolHeight = 17;

        Random rand = new Random();
        String[] symbolLines = SYMBOL.split("\n");

        while (true) {
            int x = rand.nextInt(Math.max(1, width - symbolWidth));
            int y = rand.nextInt(Math.max(1, height - symbolHeight));

            StringBuilder sb = new StringBuilder();
            sb.append(clear);

            // Vertical offset
            for (int i = 0; i < y; i++) {
                sb.append("\n");
            }

            // Print symbol at horizontal offset
            for (int i = 0; i < symbolLines.length; i++) {
                for (int j = 0; j < x; j++) {
                    sb.append(" ");
                }
                sb.append(symbolLines[i]).append("\n");
            }

            System.out.print(sb.toString());
            Thread.sleep(500);
        }
    }
}
