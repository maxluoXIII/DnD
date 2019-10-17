import java.util.Random;
import java.util.ArrayList;
import javax.swing.JFrame;

public class DnDCharacterTester {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setTitle("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DnDComponent component = new DnDComponent();
		frame.add(component);

		DnDCharacter character = new DnDCharacter("Name");
		character.rollAllStats();
		System.out.println("Strength: " + character.getStrength());
		System.out.println("Dexterity: " + character.getDexterity());
		System.out.println("Constitution: " + character.getConstitution());
		System.out.println("Intelligence: " + character.getIntelligence());
		System.out.println("Wisdom: " + character.getWisdom());
		System.out.println("Charisma: " + character.getCharisma());
		//character.addItem("Bedroll");
		//character.addItem("Tent");
		//character.addItem("Trail Rations");
		frame.setVisible(true);

	}

}