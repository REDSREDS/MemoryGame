# MemoryGame
This Memory Game is inspired from one of the Berkeley CS61b course projects. The purpose is to get familiar with Java Swing GUI widget toolkit, and
how to build a java project using Apache Maven, and practice in writing modular code.
## Game description
It is a memory game, random characters will pop up in the red area when you press start button. After it finished popping up, you need to type in the
characters in sequence in the text area, when finishing typing, hit return to see the result. It has five difficulty levels corresponding to different
number of characters:
* super easy: 3
* easy: 5
* normal: 7
* hard: 10
* super hard: 20

![start](./imgs/start.png"start")
![correct](./imgs/correct.png"correct")
![wrong](./imgs/wrong.png"wrong")
## How to play the game
To run the game, you need to download it and then in this directory, type
<pre>mvn install</pre>
to install to your local repository then type
<pre>java -cp target/MemoryGame-1.0-SNAPSHOT.jar StartGame </pre>
to start the game.
