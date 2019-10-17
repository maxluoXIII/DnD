import java.util.Random;
import java.util.ArrayList;

/**
	Creates a character with stats and modifiers, an inventory, and gold.
*/
public class DnDCharacter {

	public DnDCharacter() {

	}

	public DnDCharacter(String n, int s, int d, int co, int i, int w, int ch) {
		name = n;
		strength = s;
		dexterity = d;
		constitution = co;
		intelligence = i;
		wisdom = w;
		charisma = ch;
	}

	public DnDCharacter(String n) {
		name = n;
	}

	/**
		Rolls a single stat, based on the explicit parameter, and changes the modifier afterward.
	*/
	public void rollStat(int whichStat) {
		Random generator = new Random();
		int[] roll = new int[4];
		int least = 0;
		switch(whichStat) {
			case 1:
				int strength = 0;
				for(int i = 0; i < 4; i++) {
					roll[i] = generator.nextInt(6) + 1;
				}
				least = Math.min(roll[0], Math.min(roll[1], Math.min(roll[2], roll[3])));
				strength = roll[0] + roll[1] + roll[2] + roll[3] - least;
				this.strength = strength;
				if(this.strength <= 10) {
					st = (this.strength - 11) / 2;
				}
				else if(this.strength >= 11) {
					st = (this.strength - 10) / 2;
				}
			break;

			case 2:
				int dexterity = 0;
				roll = new int[4];
				for(int i = 0; i < 4; i++) {
					roll[i] = generator.nextInt(6) + 1;
				}
				least = Math.min(roll[0], Math.min(roll[1], Math.min(roll[2], roll[3])));
				dexterity = roll[0] + roll[1] + roll[2] + roll[3] - least;
				this.dexterity = dexterity;
				if(this.dexterity <= 10) {
				de = (this.dexterity - 11) / 2;
				}
				else if(this.dexterity >= 11) {
					de = (this.dexterity - 10) / 2;
				}
			break;

			case 3:
				int constitution = 0;
				roll = new int[4];
				for(int i = 0; i < 4; i++) {
					roll[i] = generator.nextInt(6) + 1;
				}
				least = Math.min(roll[0], Math.min(roll[1], Math.min(roll[2], roll[3])));
				constitution = roll[0] + roll[1] + roll[2] + roll[3] - least;
				this.constitution=constitution;
				if(this.constitution <= 10) {
					co = (this.constitution - 11) / 2;
				}
				else if(this.constitution >= 11) {
					co = (this.constitution - 10) / 2;
				}
			break;

			case 4:
				int intelligence = 0;
				roll = new int[4];
				for(int i = 0; i < 4; i++) {
					roll[i] = generator.nextInt(6) + 1;
				}
				least = Math.min(roll[0], Math.min(roll[1], Math.min(roll[2], roll[3])));
				intelligence = roll[0] + roll[1] + roll[2] + roll[3] - least;
				this.intelligence = intelligence;
				if(this.intelligence <= 10) {
					in = (this.intelligence - 11) / 2;
				}
				else if(this.intelligence >= 11) {
					in = (this.intelligence - 10) / 2;
				}
			break;

			case 5:
				int wisdom = 0;
				roll = new int[4];
				for(int i = 0; i < 4; i++) {
					roll[i] = generator.nextInt(6) + 1;
				}
				least = Math.min(roll[0], Math.min(roll[1], Math.min(roll[2], roll[3])));
				wisdom = roll[0] + roll[1] + roll[2] + roll[3] - least;
				this.wisdom = wisdom;
				if(this.wisdom <= 10) {
					wi = (this.wisdom - 11) / 2;
				}
				else if(this.wisdom >= 11) {
					wi = (this.wisdom - 10) / 2;
				}
			break;

			case 6:
				int charisma = 0;
				roll = new int[4];
				for(int i = 0; i < 4; i++) {
					roll[i] = generator.nextInt(6) + 1;
				}
				least = Math.min(roll[0], Math.min(roll[1], Math.min(roll[2], roll[3])));
				charisma = roll[0] + roll[1] + roll[2] + roll[3] - least;
				this.charisma = charisma;
				if(this.charisma <= 10) {
					ch = (this.charisma - 11) / 2;
				}
				else if(this.charisma >= 11) {
					ch = (this.charisma - 10) / 2;
				}
			break;
			default:
			break;
		}
	}

	/**
		Rolls the stats of the character and sets them, as well as their modifiers.
		@return the roll
	*/
	public void rollAllStats() {
		Random generator = new Random();
		int[] roll = new int[4];
		int least = 0;
		int strength = 0;
		for(int i = 0; i < 4; i++) {
			roll[i] = generator.nextInt(6) + 1;
		}
		least = Math.min(roll[0], Math.min(roll[1], Math.min(roll[2], roll[3])));
		strength = roll[0] + roll[1] + roll[2] + roll[3] - least;
		this.strength = strength;
		if(this.strength <= 10) {
			st = (this.strength - 11) / 2;
		}
		else if(this.strength >= 11) {
			st = (this.strength - 10) / 2;
		}

		int dexterity = 0;
		roll = new int[4];
		for(int i = 0; i < 4; i++) {
			roll[i] = generator.nextInt(6) + 1;
		}
		least = Math.min(roll[0], Math.min(roll[1], Math.min(roll[2], roll[3])));
		dexterity = roll[0] + roll[1] + roll[2] + roll[3] - least;
		this.dexterity = dexterity;
		if(this.dexterity <= 10) {
			de = (this.dexterity - 11) / 2;
		}
		else if(this.dexterity >= 11) {
			de = (this.dexterity - 10) / 2;
		}

		int constitution = 0;
		roll = new int[4];
		for(int i = 0; i < 4; i++) {
			roll[i] = generator.nextInt(6) + 1;
		}
		least = Math.min(roll[0], Math.min(roll[1], Math.min(roll[2], roll[3])));
		constitution = roll[0] + roll[1] + roll[2] + roll[3] - least;
		this.constitution=constitution;
		if(this.constitution <= 10) {
			co = (this.constitution - 11) / 2;
		}
		else if(this.constitution >= 11) {
			co = (this.constitution - 10) / 2;
		}

		int intelligence = 0;
		roll = new int[4];
		for(int i = 0; i < 4; i++) {
			roll[i] = generator.nextInt(6) + 1;
		}
		least = Math.min(roll[0], Math.min(roll[1], Math.min(roll[2], roll[3])));
		intelligence = roll[0] + roll[1] + roll[2] + roll[3] - least;
		this.intelligence = intelligence;
		if(this.intelligence <= 10) {
			in = (this.intelligence - 11) / 2;
		}
		else if(this.intelligence >= 11) {
			in = (this.intelligence - 10) / 2;
		}

		int wisdom = 0;
		roll = new int[4];
		for(int i = 0; i < 4; i++) {
			roll[i] = generator.nextInt(6) + 1;
		}
		least = Math.min(roll[0], Math.min(roll[1], Math.min(roll[2], roll[3])));
		wisdom = roll[0] + roll[1] + roll[2] + roll[3] - least;
		this.wisdom = wisdom;
		if(this.wisdom <= 10) {
			wi = (this.wisdom - 11) / 2;
		}
		else if(this.wisdom >= 11) {
			wi = (this.wisdom - 10) / 2;
		}

		int charisma = 0;
		roll = new int[4];
		for(int i = 0; i < 4; i++) {
			roll[i] = generator.nextInt(6) + 1;
		}
		least = Math.min(roll[0], Math.min(roll[1], Math.min(roll[2], roll[3])));
		charisma = roll[0] + roll[1] + roll[2] + roll[3] - least;
		this.charisma = charisma;
		if(this.charisma <= 10) {
			ch = (this.charisma - 11) / 2;
		}
		else if(this.charisma >= 11) {
			ch = (this.charisma - 10) / 2;
		}
	}
	//return strength+" "+dexterity+" "+constitution+" "+intelligence+" "+

	/**
		Sets the strength of the character, then changes the modifier to match.
		@param s the amount to set to
	*/
	public void setStrength(int s) {
		strength = s;
		if(strength <= 10) {
			st = (strength - 11) / 2;
		}
		else if(strength >= 11) {
			st = (strength - 10) / 2;
		}
	}

	/**
		Sets the dexterity of the character, then changes the modifier to match.
		@param d the amount to set to
	*/
	public void setDexterity(int d) {
		dexterity = d;
		if(dexterity <= 10) {
			de = (dexterity - 11) / 2;
		}
		else if(dexterity >= 11) {
			de = (dexterity - 10) / 2;
		}
	}

	/**
		Sets the constitution of the character, then changes the modifier to match.
		@param c the amount to set to
	*/
	public void setConstitution(int c) {
		constitution = c;
		if(constitution <= 10) {
			co = (constitution - 11) / 2;
		}
		else if(constitution >= 11) {
			co = (constitution - 10) / 2;
		}
	}

	/**
		Sets the intelligence of the character, then changes the modifier to match.
		@param i the amount to set to
	*/
	public void setIntelligence(int i) {
		intelligence = i;
		if(intelligence <= 10) {
			in = (intelligence - 11) / 2;
		}
		else if(intelligence >= 11) {
			in = (intelligence - 10) / 2;
		}
	}

	/**
		Sets the wisdom of the character, then changes the modifier to match.
		@param w the amount to set to
	*/
	public void setWisdom(int w) {
		wisdom = w;
		if(wisdom <= 10) {
			wi = (wisdom - 11) / 2;
		}
		else if(wisdom >= 11) {
			wi = (wisdom - 10) / 2;
		}
	}

	/**
		Sets the charisma of the character, then changes the modifier to match.
		@param c the amount to set to
	*/
	public void setCharisma(int c) {
		charisma = c;
		if(charisma <= 10) {
			ch = (charisma - 11) / 2;
		}
		else if(charisma >= 11) {
			ch = (charisma - 10) / 2;
		}
	}

	/**
		Rolls the health of the character.
		@param maxRoll the maximum roll possible
	*/
	public void rollHealth(int maxRoll) {
		Random generator = new Random();
		health = generator.nextInt(maxRoll);
		health = health + co;
	}

	/**
		Adds to the gold of the character.
		@param amount the amount to be added
	*/
	public void addGold(int amount) {
		gold = gold + amount;
	}

	/**
		Adds to the silver of the character.
		@param amount the amount to be added
	*/
	public void addSilver(int amount) {
		silver = silver + amount;
	}

	/**
		Adds to the copper of the character.
		@param amount the amount to be added
	*/
	public void addCopper(int amount) {
		copper = copper + amount;
	}

	/**
		Subtracts from the gold of the character.
		@param amount the amount to be subtracted
	*/
	public void subtractGold(int amount) {
		if(amount <= gold) {
			gold = gold - amount;
		}
		else {
			System.out.println("Insufficient gold");
		}
	}

	/**
		Subtracts from the silver of the character.
		@param amount the amount to be subtracted
	*/
	public void subtractSilver(int amount) {
		if(amount <= silver) {
			silver = silver - amount;
		}
		else {
			System.out.println("Insufficient silver");
		}
	}

	/**
		Subtracts from the copper of the character.
		@param amount the amount to be subtracted
	*/
	public void subtractCopper(int amount) {
		if(amount <= copper) {
			copper = copper - amount;
		}
		else {
			System.out.println("Insufficient copper");
		}
	}

	/**
		Adds an item to the inventory of the character.
		@param itemName is the name of the item
	*/
	public void addItem(String itemName) {
		inventory.add(new Item(itemName));
	}

	/**
		Returns the name of the character.
		@return the name of the character
	*/
	public String getName() {
		return name;
	}

	/**
		Returns the value of the strength stat.
		@return the value of the stat
	*/
	public int getStrength() {
		return strength;
	}

	/**
		Returns the value of the dexterity stat.
		@return the value of the stat
	*/
	public int getDexterity() {
		return dexterity;
	}

	/**
		Returns the value of the constitution stat.
		@return the value of the stat
	*/
	public int getConstitution() {
		return constitution;
	}

	/**
		Returns the value of the intelligence stat.
		@return the value of the stat
	*/
	public int getIntelligence() {
		return intelligence;
	}

	/**
		Returns the value of the wisdom stat.
		@return the value of the stat
	*/
	public int getWisdom() {
		return wisdom;
	}

	/**
		Returns the value of the charisma stat.
		@return the value of the stat
	*/
	public int getCharisma() {
		return charisma;
	}

	/**
		Returns the value of the stat chosen by the parameter.
		@param whichStat chooses which stat to return
		@return the value of the stat chosen
	*/
	public int getStat(int whichStat) {
		int stat = 0;
		switch(whichStat) {
			case 1:
				stat = strength;
				break;
			case 2:
				stat = dexterity;
				break;
			case 3:
				stat = constitution;
				break;
			case 4:
				stat = intelligence;
				break;
			case 5:
				stat = wisdom;
				break;
			case 6:
				stat = charisma;
				break;
		}
		return stat;
	}

	/**
		Gives the values of the instance fields of the character.
		@return the values in each instance field, excluding the inventory
	*/
	public String toString() {
		return "Name: "+name+"\nStrength: "+strength+"\nDexterity: "+dexterity+"\nConstitution: "+constitution+
		"\nIntelligence: "+intelligence+"\nWisdom: "+wisdom+"\nCharisma: "+charisma+"\nGold: "+gold+"\nSilver: "
		+silver+"\nCopper: "+copper;
	}

	private String name;
	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;
	private double health;
	private int gold;
	private int silver;
	private int copper;
	private int st;
	private int de;
	private int co;
	private int in;
	private int wi;
	private int ch;
	private ArrayList<Item> inventory;

}