package citi;

public class LabyrinthImpl implements Labyrinth {

	private boolean[][] walls = new boolean[][] {
			{ true, true, true, true, false, true, true, true },
			{ true, false, true, false, false, false, false, true },
			{ true, false, true, true, true, false, false, true },
			{ true, false, true, false, false, true, false, true },
			{ true, false, true, true, false, false, false, true },
			{ true, false, false, true, false, true, false, true },
			{ true, true, false, false, false, false, false, true },
			{ true, true, true, true, true, true, true, true } };
	/** Starting position */
	private int currentX = 3, currentY = 3;

	public LabyrinthImpl() {
	}

	public LabyrinthImpl(boolean[][] walls, int currentX, int currentY) {
		this.walls = walls;
		this.currentX = currentX;
		this.currentY = currentY;
	}

	private boolean isCovered(int x, int y) {
		if (y < 0 || y >= walls.length) {
			return false;
		}
		return x >= 0 && x < walls[y].length;
	}

	@Override
	public boolean isOutside() {
		return !isCovered(currentX, currentY);
	}

	@Override
	public boolean tryMove(int direction) {
		int newX = currentX, newY = currentY;
		switch (direction) {
		case 0:
			newY--;
			break;
		case 1:
			newX++;
			break;
		case 2:
			newY++;
			break;
		case 3:
			newX--;
			break;
		default:
			throw new RuntimeException("Wrong direction: " + direction);
		}
		if (isCovered(newX, newY) && walls[newY][newX]) {
			return false;
		}
		currentX = newX;
		currentY = newY;
		return true;
	}

	@Override
	public boolean[] wallsAround() {
		boolean[] around = new boolean[4];
		around[0] = isCovered(currentX, currentY - 1) ? walls[currentY - 1][currentX]
				: false;
		around[1] = isCovered(currentX + 1, currentY) ? walls[currentY][currentX + 1]
				: false;
		around[2] = isCovered(currentX, currentY + 1) ? walls[currentY + 1][currentX]
				: false;
		around[3] = isCovered(currentX - 1, currentY) ? walls[currentY][currentX - 1]
				: false;
		return around;
	}

	@Override
	public int getCurrentX() {
		// TODO Auto-generated method stub
		return currentX;
	}

	@Override
	public int getCurrentY() {
		// TODO Auto-generated method stub
		return currentY;
	}
	
	
}
