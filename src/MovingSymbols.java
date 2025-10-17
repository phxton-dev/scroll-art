import java.util.Random;

public class MovingSymbols {
    static final int WIDTH = getTerminalWidth() - 1;
    static final int ART_WIDTH = 28;
    static final int ART_HEIGHT = 17;
    static final Random rand = new Random();

    public static void main(String[] args) throws InterruptedException {
        int delayMs = 15;
        if (args.length > 0) {
            try {
                delayMs = Integer.parseInt(args[0]);
            } catch (NumberFormatException ignored) {}
        }

        char[][] screen = new char[ART_HEIGHT][WIDTH];
        for (int i = 0; i < screen.length; i++) {
            screen[i] = emptyRow();
        }

        while (true) {
            // Occasionally spawn art at a random x-position
            for (int x = 0; x < WIDTH - ART_WIDTH; x++) {
                if (rand.nextDouble() < 0.02) {
                    drawArt(screen, getSymbolArt(), x);
                }
            }

            // Print top row
            System.out.println(new String(screen[0]));

            // Scroll up
            shiftUp(screen);

            Thread.sleep(delayMs);
        }
    }

    static void shiftUp(char[][] screen) {
        for (int i = 1; i < screen.length; i++) {
            screen[i - 1] = screen[i];
        }
        screen[screen.length - 1] = emptyRow();
    }

    static char[] emptyRow() {
        char[] row = new char[WIDTH];
        for (int i = 0; i < WIDTH; i++) {
            row[i] = ' ';
        }
        return row;
    }

    static void drawArt(char[][] screen, char[][] art, int x) {
        int startY = Math.max(0, screen.length - ART_HEIGHT);
        for (int y = 0; y < ART_HEIGHT; y++) {
            char[] row = screen[startY + y];
            for (int c = 0; c < ART_WIDTH && x + c < WIDTH; c++) {
                if (art[y][c] != ' ') {
                    row[x + c] = art[y][c];
                }
            }
        }
    }

    static char[][] getSymbolArt() {
        String[] lines = {
            "     +--,-+",
            "     | ' \\|",
            "     `.   ;",
            "     | ;.'|",
            "     ,'  `,",
            "  _,-|`-.'|.._         _.-[",
            ",:....-..:>...:-     ,/' /'",
            "     |  | |        <'   ,'",
            "     |  | |    ,Y''     | _.-'",
            "     |  | | .,'        /\\'",
            "     |  | | `.  ,Y''   /",
            "     |  | |   \\'    ,'",
            "     |  | |    \\ ,-'",
            "     |  | |     -",
            "     ,  | ,",
            "      `.|/",
            "        '"
        };
        char[][] art = new char[ART_HEIGHT][ART_WIDTH];
        for (int y = 0; y < ART_HEIGHT; y++) {
            for (int x = 0; x < ART_WIDTH; x++) {
                art[y][x] = (x < lines[y].length()) ? lines[y].charAt(x) : ' ';
            }
        }
        return art;
    }

    public static int getTerminalWidth() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            return getUnixTerminalWidth();
        } else {
            return 80;
        }
    }

    private static int getUnixTerminalWidth() {
        try {
            String columns = System.getenv("COLUMNS");
            if (columns != null && !columns.isEmpty()) {
                return Integer.parseInt(columns);
            }

            ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", "stty size </dev/tty");
            pb.redirectErrorStream(true);
            Process process = pb.start();
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            String output = reader.readLine();
            if (output != null && !output.isEmpty()) {
                String[] parts = output.trim().split(" ");
                return Integer.parseInt(parts[1]);
            }
        } catch (Exception ignored) {}
        return 80;
    }
}
