package kata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TowersOfHanoiTest {

	private TowersOfHanoi puzzle;

	@Before
	public void setUp() {
		this.puzzle = new TowersOfHanoi();
	}

	@Test
	public void shouldInitializeWithAllDisksOnFirstPegInAscendingOrder() {
		Peg peg1 = puzzle.getPeg1();

		assertThat(peg1.removeDisk(), equalTo(Disk.SIZE_1));
		assertThat(peg1.removeDisk(), equalTo(Disk.SIZE_2));
		assertThat(peg1.removeDisk(), equalTo(Disk.SIZE_3));
	}

	@Test
	public void shouldInitiallyNotHaveAnyDisksOnPegs2Or3() {
		assertTrue(puzzle.getPeg2().isEmpty());
		assertTrue(puzzle.getPeg3().isEmpty());
	}

	@Test
	public void shouldMovePegFromPeg1ToPeg2() {

		puzzle.move(1, 2);
		Peg peg2 = puzzle.getPeg2();
		assertThat(peg2.removeDisk(), equalTo(Disk.SIZE_1));
	}

	@Test
	public void shouldDisallowMovingALargerDiskOnTopOfASmallerDisk() {

		assertTrue(puzzle.move(1, 2));
		assertFalse(puzzle.move(1, 2));
	}

	@Test
	public void shouldDisallowedMoveDoesntMoveDisk() {
		Peg peg1 = puzzle.getPeg1();
		Peg peg2 = puzzle.getPeg2();

		puzzle.move(1, 2);
		puzzle.move(1, 2);

		assertThat(peg1.removeDisk(), equalTo(Disk.SIZE_2));
		assertThat(peg2.removeDisk(), equalTo(Disk.SIZE_1));
	}

	@Test
	public void shouldDisallowRemovingDiskFromEmptyPeg() {
		assertFalse(puzzle.move(2, 3));
	}

	@Test
	public void shouldDetectCorrectSolution(){
		puzzle.move(1,3);
		puzzle.move(1,2);
		puzzle.move(3,2);
		puzzle.move(1,3);
		puzzle.move(2,1);
		puzzle.move(2,3);
		puzzle.move(1,3);
		assertThat(puzzle.isSuccess(), is(true));
	}

	@Test
	public void testBruteForceSolver(){
		puzzle.bruteForceSolve();
		assertThat(puzzle.isSuccess(), is(true));
	}

	@Test
	public void testRecursiveBacktrackingSolver(){
		puzzle.recursiveBackTrackingSolve();
		assertThat(puzzle.isSuccess(), is(true));
	}
}
