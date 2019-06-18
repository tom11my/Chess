import java.awt.Image;

import javax.swing.ImageIcon;

public class Pawn extends Piece {
	
	private boolean hasMoved;
	
	public Pawn (String img) {
		super(img);
		super.setWhite(img.equals("WhitePawn.png"));
		hasMoved = false;
	}


	public static Image setUpImage () {
		return null;
	}
	@Override
	public boolean isValid (Loc start, Loc end, Piece[][] pieces) {
		int sum = 1;
		int sum2 = 2;
		if(isWhite()) {
			sum = -1;
			sum2 = -2;
		}
		if(end.getY()-start.getY() == sum && end.getX() == start.getX() && pieces[start.getY()+sum][start.getX()] == null) {
			hasMoved = true;
			return true;
		}
		if(end.getY()-start.getY() == sum && Math.abs(end.getX() - start.getX()) == 1 && pieces[end.getY()][end.getX()].isWhite() != isWhite())
			return true;
		if(!hasMoved && end.getY()-start.getY() == sum2 && end.getX() == start.getX() && pieces[start.getY()+sum2][start.getX()] == null) {
			hasMoved = true;
			return true;
		}
		return false;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Pawn";
	}
}