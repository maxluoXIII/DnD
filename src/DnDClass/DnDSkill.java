/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DnDClass;

/**
 * 
 * @author gutha_000
 */
public class DnDSkill {
    
    public DnDSkill() {
        
    }
    
    public DnDSkill(boolean iCS, AbilityScore aS, int sR, int m) {
        isClassSkill = iCS;
        abilityScore = aS;
        skillRanks = sR;
        miscellaneous = m;
    }
    
    public int getTotalScore() {
        int output = abilityScore.getModifier() + skillRanks + miscellaneous;
        if(isClassSkill)
            output += 3;
        return output;
    }
    
    public void setSkillRanks() {
        
    }
    
    private boolean isClassSkill;
    private AbilityScore abilityScore;
    private int skillRanks;
    private int miscellaneous;
    
}
