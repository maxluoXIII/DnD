import java.util.Random;

public class DiceRoller
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		for(int i = 0; i < 2; i++)
		{
			int num = rand.nextInt(10);
			System.out.print(num+" ");
		}
	}
}