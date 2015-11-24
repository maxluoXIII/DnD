/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DnDClass;

/**
 * The abstract parent class for all DnD classes.
 * @author gutha_000
 */
public abstract class DnDClass {
    
    public int calcGoodSave() {
        return level / 2 + 1;
    }
    
    public int calcBadSave() {
        return level / 3;
    }
    
    protected static final AbilityScore[] ABILITY_SCORES = 
        {new AbilityScore("Strength"),
         new AbilityScore("Dexterity"),
         new AbilityScore("Constitution"),
         new AbilityScore("Intelligence"),
         new AbilityScore("Wisdom"),
         new AbilityScore("Charisma")};
    
    protected int level;
    protected boolean willSave, reflexSave, fortSave;
    
}
