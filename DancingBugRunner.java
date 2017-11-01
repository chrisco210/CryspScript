import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class DancingBugRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		DancingBug d = new DancingBug(new int[] {0, 6, 4 ,9, 10, 3});
		world.add(new Location(0, 0), d);

		world.show();
	}
}
