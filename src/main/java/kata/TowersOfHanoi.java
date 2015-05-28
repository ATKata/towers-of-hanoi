package kata;

import java.util.ArrayList;
import java.util.List;

public class TowersOfHanoi {
	private static final int[][] POSSIBLE_MOVES = new int[][] { {1,2}, {1,3}, {2,3}, {2,1}, {3,2}, {3,1}};

	private Peg peg1;
	private Peg peg2;
	private Peg peg3;

	private int MAX_MOVE_COUNT = (int)Math.pow(2,3) - 1;

	public TowersOfHanoi() {
		reset();
	}

	private void reset() {
		this.peg1 = new Peg();
		this.peg2 = new Peg();
		this.peg3 = new Peg();

		peg1.addDisk(Disk.SIZE_3);
		peg1.addDisk(Disk.SIZE_2);
		peg1.addDisk(Disk.SIZE_1);
	}

	public Peg getPeg(int pegIndex) {
		switch (pegIndex) {
		case 1:
			return peg1;
		case 2:
			return peg2;
		case 3:
			return peg3;
		default:
			return null;
		}

	}

	public Peg getPeg1() {
		return peg1;
	}

	public Peg getPeg2() {
		return peg2;
	}

	public Peg getPeg3() {
		return peg3;
	}

	@Override
	public String toString() {
		return peg1.toString() + " " + peg2.toString() + " " + peg3.toString();
	}

	public boolean move(int fromPegIndex, int toPegIndex) {
		Peg fromPeg = getPeg(fromPegIndex);
		if (fromPeg.isEmpty()) {
			return false;
		}
		Disk disk = fromPeg.removeDisk();
		if (!getPeg(toPegIndex).addDisk(disk)) {
			fromPeg.addDisk(disk);
			return false;
		}
		return true;
	}

	public boolean isSuccess() {
		return peg1.isEmpty() && peg2.isEmpty();
	}

	public boolean solve(){
		for(String movesString:generateMoves()){
			StringBuilder movesMadeThisTime = new StringBuilder();
			for(char moveId:movesString.toCharArray()){
				int[] move = POSSIBLE_MOVES[Character.getNumericValue(moveId)];
				movesMadeThisTime.append(move[0] + "->" + move[1] + " ");
				move(move[0], move[1]);
			}

			if(isSuccess()){
				System.out.println(movesMadeThisTime);
				return true;
			} else {
				reset();
			}

		}
		return false;
	}

	private List<String> generateMoves() {
		List<String> result = new ArrayList<>();
		for(int i=0; i<Math.pow(POSSIBLE_MOVES.length,MAX_MOVE_COUNT); i++){
			result.add(String.format("%"+MAX_MOVE_COUNT+"s", Integer.toString(i, POSSIBLE_MOVES.length) ).replace(' ', '0'));
		}
		return result;
	}
}
