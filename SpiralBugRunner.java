import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

import java.awt.*;

public class SpiralBugRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		Bug d = new SpiralBug(5, Color.RED);
		world.add(new Location(0, 0), d);

		world.show();
	}
}
