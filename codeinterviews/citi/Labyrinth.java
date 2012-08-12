package citi;

public interface Labyrinth {
	/**
	* "Sensory" function of the labyrinth - see whether there are
	* walls around the current position. 
	* @return Four booleans. Indices correspond to the directions on the
	* picture 2. <code>true</code> at a corresponding index means there is
	* a wall, <code>false</code> means there is empty space.
	* For the labyrinth and the starting position on the picture 1,
	* this function will return
	* <code>
	* {true, false, true, true}
	* </code>
	*/
	boolean[] wallsAround();
	/**
	* Indicates whether the current position is outside the labyrinth.
	* If one tries to move outside the labyrinth, the interface will still
	* function as if there is only empty space around the labyrinth.
	* @return <code>true</code> if the current position is outside.
	*/
	boolean isOutside();
	/**
	* Attempts to move the current position in the labyrinth. The
	* attempt can only succeed if there is empty space in the
	* direction of the movement. This is the only way to change
	* current position.
	* @param direction One of numbers 0, 1, 2, 3, each correspond
	* to a direction on the picture 2.
	* @return <code>true</code> If movement succeeded, <code>false</code>
	* otherwise.
	*/
	boolean tryMove(int direction);
	
	int getCurrentX();
	int getCurrentY();
}
