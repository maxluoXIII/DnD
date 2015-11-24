/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DnDClass;

/**
 * Represents an ability score of a character.
 * @author gutha_000
 */
public class AbilityScore {
    
    public AbilityScore() {
        
    }
    
    public AbilityScore(String n, int s) {
        name = n;
        score = s;
        calculateModifier();
    }
    
    /**
     * Calculates the modifier based on the current score.
     */
    private void calculateModifier() {
        if(score >= 10)
            modifier = (score - 10) / 2;
        else
            modifier = (score - 11) / 2;
    }
    
    /**
     * Sets score to a new value; Adjusts the modifier accordingly.
     * @param newScore the new value of the score
     */
    public void setScore(int newScore) {
        score = newScore;
        calculateModifier();
    }
    
    /**
     * Returns the name of the ability score.
     * @return name of the ability score
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the score.
     * @return the score
     */
    public int getScore() {
        return score;
    }
    
    /**
     * Returns the modifier.
     * @return the modifier
     */
    public int getModifier() {
        return modifier;
    }
    
    private String name;
    private int score;
    private int modifier;
    
}
