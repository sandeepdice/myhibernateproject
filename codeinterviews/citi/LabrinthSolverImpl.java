package citi;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Position;

public class LabrinthSolverImpl implements LabyrinthSolver {

	public int[] oldMove = new int[]{2,3,0,1};
	public class position {
		int x,y;
		public position (int x, int y){
			this.x = x;
			this.y = y;
		}		
	}
	
	@Override
	public boolean exitExists(Labyrinth l) {
		return check(l,999);
	}
	
	public boolean check (Labyrinth l, int premov){
		System.out.println(l.getCurrentX() + " " + l.getCurrentY() + " " + premov);
		boolean ret = false;
		if (l.isOutside())
			return true;
		boolean[] newMoves = l.wallsAround();
		for (int i=0;i<newMoves.length;i++){
			newMoves[i] = !newMoves[i];
		}
		for (int i=0;i<newMoves.length;i++){
			if(i != premov)
				ret = ret || newMoves[i];
		}
		for (boolean b : newMoves){
			ret = ret || b;
		}
		if (!ret)
			return false;
		Labyrinth tmp = l;
		for (int i=0; i<newMoves.length; i++){
			tmp = l;
			if (newMoves[i] && (i != premov)) {
				tmp.tryMove(i);
				 if (!check(tmp, oldMove[i])){
					 continue;
				 }
				 else{
					 ret = true;
					 break;
				}
			}
		}
		return ret;
	}
	public static void main(String[] args) {
		Labyrinth lab = new LabyrinthImpl();
		LabrinthSolverImpl impl = new LabrinthSolverImpl();
		System.out.println(impl.exitExists(lab));
	}
}
