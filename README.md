# Console Dominoes

### Requirements
Program writtin using IntelliiJ IDEA  
SDK = Java 8  
Entry for program is GameManger.java

### Instructions
This is a console based version of dominoes.  User follows command line instructions to play the game.  When the game starts, the user 
is asked if they would like to play dominoes.  If the user enters anything other than "yes", the program will exit.
After entering in "yes", 7 tiles are dealt to each player.  Play then begins with the human player.  The command prompt will ask
for an integer input to select the tile to be played, index 0 = integer 0.  The progarm will automatically play the tile on either the 
front or end of the game board tiles.  The computer will then place a tile down from its tray and gameplay repeats, asking for an integer input each time 
the user gets to play.  If no tiles can be played the user will get a message to input an integer of a tile to pick up from the bone yard.
The user will be prompted to input an integer value until a playable tile is picked up.  If the bone yard becomes empty during either players
turn, then the las player to put down a tile wins.  A message is printed out if any player wins the game.

### Known Bugs
Program crashes if non integer input is detected during humans play tile input.
