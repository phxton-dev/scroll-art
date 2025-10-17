## StillLife.java — how it works

`StillLife.java` prints an ASCII still life and then adds a signature at the end. The ASCII art is original work, so it counts as one citation point.

### Overview

* The ASCII art is stored as an array of text lines.
* `printArt(...)` prints each line in order.
* `printSignature()` adds the closing signature (`- EZ`).
* An optional loop mode repeats the print at timed intervals.

### Run

javac src\*.java
java -cp src StillLife

### Loop mode

Add `true` to enable looping:

java -cp src StillLife true

The loop waits 2000 ms between prints by default. You can adjust this delay in the code.


### Process documentation

**Design:**
The program was designed to display a fixed ASCII image in a clean and minimal way. It separates responsibilities into small methods—`getArtLines()`, `printArt()`, and `printSignature()`—for clarity and easy reuse.

**Implementation:**
The art is stored as a string array. Each element represents one line of the image. The main loop optionally repeats the printing process if the `true` argument is provided. A short delay (`Thread.sleep`) controls the pause between repeats.

**Testing and adjustments:**
The program was tested in a standard terminal window to ensure alignment and spacing were consistent. Adjustments were made to ensure the ASCII art prints correctly without trailing spaces or misalignment.


## MovingSymbols.java — how it works

`MovingSymbols.java` generates an ASCII animation that scrolls through the terminal. Each frame moves the display up by one line and occasionally adds a new copy of the art at the bottom. The ASCII art is original work, so it counts as one citation point. The signature is in the ASCII art itself.

### Overview

* The ASCII art is defined in the `getSymbolArt()` method as a 2D character array.
* A 2D array `char[][] screen` represents the terminal frame.
* Each frame:

  * With a small probability (around 2%), a new image appears at the bottom.
  * The entire display scrolls upward using `shiftUp(...)`.
  * The top row is printed to the terminal.
* The animation speed can be adjusted by passing a delay value (in milliseconds) as an argument.

### Run

javac src\*.java
java -cp src MovingSymbols

### Speed control

Pass a number to control the delay between frames:

java -cp src MovingSymbols 10

A smaller number increases the speed; a larger number slows it down.

### Process documentation

**Design:**
The goal was to create a lightweight text-based animation using only core Java. The program mimics a continuous upward scroll, with new art pieces occasionally appearing. The design relies on a 2D character buffer (`screen`) to simulate frame updates.

**Implementation:**
The program initializes a character matrix sized to the terminal width and art height. Each loop iteration:

1. Randomly spawns a copy of the art at the bottom.
2. Prints the top row.
3. Scrolls the buffer upward.
   The `getTerminalWidth()` method automatically adjusts for different terminal sizes on Unix-based systems.

**Testing and adjustments:**
Frame delay and spawn probability were tuned to balance visual smoothness and variety. ASCII alignment was checked to prevent overlap when multiple symbols appear on screen. The final version runs smoothly in standard terminal environments without graphical libraries.
