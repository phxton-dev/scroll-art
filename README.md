`MovingSymbols.java` generates an ASCII animation that scrolls through the terminal. Each frame moves the display up by one line and occasionally adds a new copy of the art at the bottom. The ASCII art is original work, so it counts as one citation point. The signature is in the ASCII art itself.

### Overview

* The program stores each ASCII art piece as a Java string (newline-separated).
* Included artwork:
    - Original sword design (counts as one citation point).
    - Penguin by Ari Hallak (retained author initials "AH" in the art).
    - Ball by Dilan Shah (retained author initials "DS").
    - Llama by Maria Sek (retained author initials "MS").
* All non-original pieces are included with attribution; the files in the source keep the visible author initials.
* On each loop iteration, one art piece is chosen at random and rendered at a random (x,y) offset inside an 80×24 terminal.
* ANSI escape codes are used to clear and position the terminal for a cleaner screen.

### Run

`javac src *.java`  

`java MovingSymbols`

### Process documentation
I devised a sword design myself. I used JavE 5 to first construct my ASCII art and I exported it to notepad. I then pasted it into the IDE and adjusted it. I pasted Ari Hallak's penguin and I converted both Dilan Shah's ball and Maria Sek's llama to strings. 

**Testing and adjustments:**  

I decided to use ANSI escape codes to make the terminal look cleaner.
