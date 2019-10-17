import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class DnDComponent extends JComponent {

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		DnDCharacter character = new DnDCharacter("Name");
		character.rollAllStats();
		g2.drawString("Name: " + character.getName(), 100, 10);
		g2.drawString("Strength: " + character.getStrength(), 0, 10);
		g2.drawString("Dexterity: " + character.getDexterity(), 0, 20);
		g2.drawString("Constitution: " + character.getConstitution(), 0, 30);
		g2.drawString("Intelligence: " + character.getIntelligence(), 0, 40);
		g2.drawString("Wisdom: " + character.getWisdom(), 0, 50);
		g2.drawString("Charisma: " + character.getCharisma(), 0, 60);

	}

}