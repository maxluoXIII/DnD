/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dndcharacterviewer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import src.*;

/**
 *
 * @author Home
 */
public class DnDCharacterViewer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final JFrame frame = new JFrame();
        //frame.setSize(JFrame.MAXIMIZED_HORIZ, 125);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //DnDCharacterComponent statComponent = new DnDCharacterComponent();
        final DnDCharacter character = new DnDCharacter();
        character.chooseFile();
        frame.setTitle(character.getFileName());
        //statComponent.setDnDCharacter(character);

        try {
            character.readFromFile();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        final JLabel healthLabel = new JLabel("Health: " + character.getCurrentHealth() + "/" + character.getTotalHealth());
        final JTextField healthField = new JTextField(10);

        class HealthFieldListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                character.addHealth(Double.parseDouble(healthField.getText()));
                try {
                    character.updateFile();
                } catch (FileNotFoundException exception) {
                    exception.printStackTrace();
                } catch (InputMismatchException exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Formatting of data file is incorrect.");
                }

                healthLabel.setText("Health: " + character.getCurrentHealth() + "/" + character.getTotalHealth());
                healthField.setText("");
            }
        }

        final JButton updateHealth = new JButton("Update Health");
        ActionListener healthFieldListener = new HealthFieldListener();
        healthField.addActionListener(healthFieldListener);
        updateHealth.addActionListener(healthFieldListener);

        final JLabel goldLabel = new JLabel("Gold: " + character.getGold());
        final JTextField goldField = new JTextField(10);

        class GoldFieldListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                character.addGold(Integer.parseInt(goldField.getText()));
                try {
                    character.updateFile();
                } catch (FileNotFoundException exception) {
                    exception.printStackTrace();
                } catch (InputMismatchException exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Formatting of data file is incorrect.");
                }

                goldLabel.setText("Gold: " + character.getGold());
                goldField.setText("");
            }
        }

        final JButton updateGold = new JButton("Update Gold");
        ActionListener goldFieldListener = new GoldFieldListener();
        goldField.addActionListener(goldFieldListener);
        updateGold.addActionListener(goldFieldListener);

        final JLabel silverLabel = new JLabel("Silver: " + character.getSilver());
        final JTextField silverField = new JTextField(10);

        class SilverFieldListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                character.addSilver(Integer.parseInt(silverField.getText()));
                while (character.getSilver() < 0) {
                    character.subtractGold(1);
                    character.addSilver(10);
                }

                try {
                    character.updateFile();
                } catch (FileNotFoundException exception) {
                    exception.printStackTrace();
                } catch (InputMismatchException exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Formatting of data file is incorrect.");
                }

                silverLabel.setText("Silver: " + character.getSilver());
                goldLabel.setText("Gold: " + character.getGold());
                silverField.setText("");
            }
        }

        final JButton updateSilver = new JButton("Update Silver");
        ActionListener silverFieldListener = new SilverFieldListener();
        silverField.addActionListener(silverFieldListener);
        updateSilver.addActionListener(silverFieldListener);

        final JLabel copperLabel = new JLabel("Copper: " + character.getCopper());
        final JTextField copperField = new JTextField(10);

        class CopperFieldListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                character.addCopper(Integer.parseInt(copperField.getText()));
                while (character.getCopper() < 0) {
                    character.subtractSilver(1);
                    character.addCopper(10);
                }
                while (character.getSilver() < 0) {
                    character.subtractGold(1);
                    character.addSilver(10);
                }

                try {
                    character.updateFile();
                } catch (FileNotFoundException exception) {
                    exception.printStackTrace();
                } catch (InputMismatchException exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Formatting of data file is incorrect.");
                }

                goldLabel.setText("Gold: " + character.getGold());
                silverLabel.setText("Silver: " + character.getSilver());
                copperLabel.setText("Copper: " + character.getCopper());
                copperField.setText("");
            }
        }

        final JButton updateCopper = new JButton("Update Copper");
        ActionListener copperFieldListener = new CopperFieldListener();
        copperField.addActionListener(copperFieldListener);
        updateCopper.addActionListener(copperFieldListener);

        final JLabel expLabel = new JLabel("Experience: " + character.getExperience());
        final JTextField expField = new JTextField(10);

        class ExpFieldListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                character.addExperience(Double.parseDouble(expField.getText()));
                try {
                    character.updateFile();
                } catch (FileNotFoundException exception) {
                    exception.printStackTrace();
                } catch (InputMismatchException exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Formatting of data file is incorrect.");
                }

                expLabel.setText("Experience: " + character.getExperience());
                expField.setText("");
            }
        }

        final JButton updateExp = new JButton("Update Experience");
        ActionListener expFieldListener = new ExpFieldListener();
        expField.addActionListener(expFieldListener);
        updateExp.addActionListener(expFieldListener);

        final JLabel[] skillLabels = new JLabel[39];
        for (int i = 0; i < skillLabels.length; i++) {
            skillLabels[i] = new JLabel();
            String text;
            text = character.getSkill(i).getName() + ": ";
            String abilityScoreText = "";
            switch (character.getSkill(i).getScoreType()) {
                case 0:
                    abilityScoreText = character.getStrengthMod() + " + ";
                    character.getSkill(i).setAbilityScore(character.getStrengthMod());
                    break;
                case 1:
                    abilityScoreText = character.getDexterityMod() + " + ";
                    character.getSkill(i).setAbilityScore(character.getDexterityMod());
                    break;
                case 2:
                    abilityScoreText = character.getConstitutionMod() + " + ";
                    character.getSkill(i).setAbilityScore(character.getConstitutionMod());
                    break;
                case 3:
                    abilityScoreText = character.getIntelligenceMod() + " + ";
                    character.getSkill(i).setAbilityScore(character.getIntelligenceMod());
                    break;
                case 4:
                    abilityScoreText = character.getWisdomMod() + " + ";
                    character.getSkill(i).setAbilityScore(character.getWisdomMod());
                    break;
                case 5:
                    abilityScoreText = character.getCharismaMod() + " + ";
                    character.getSkill(i).setAbilityScore(character.getCharismaMod());
                    break;
            }
            text += character.getSkill(i).getTotal() + " = ";
            text += abilityScoreText;
            text += character.getSkill(i).getRanks() + " + ";
            text += character.getSkill(i).getMisc();
            skillLabels[i].setText(text);
        }

        final JTextField[][] skillFields = new JTextField[39][2];
        for (int row = 0; row < skillFields.length; row++) {
            for (int col = 0; col < skillFields[row].length; col++) {
                skillFields[row][col] = new JTextField(5);
            }
        }

        class SkillFieldListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                boolean isEmpty;
                for (int row = 0; row < skillFields.length; row++) {
                    for (int col = 0; col < skillFields[row].length; col++) {
                        if (!(skillFields[row][col].getText().equals(""))) {
                            if (col == 0) {
                                character.addSkillRanks(row, Integer.parseInt(skillFields[row][col].getText()));
                            } else {
                                character.addSkillMisc(row, Integer.parseInt(skillFields[row][col].getText()));
                            }
                        }
                        skillFields[row][col].setText("");
                    }
                }
                try {
                    character.updateFile();
                } catch (FileNotFoundException exception) {
                    exception.printStackTrace();
                } catch (InputMismatchException exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Formatting of data file is incorrect.");
                }

                for (int i = 0; i < skillLabels.length; i++) {
                    String text;
                    text = character.getSkill(i).getName() + ": ";
                    String abilityScoreText = "";
                    switch (character.getSkill(i).getScoreType()) {
                        case 0:
                            abilityScoreText = character.getStrengthMod() + " + ";
                            character.getSkill(i).setAbilityScore(character.getStrengthMod());
                            break;
                        case 1:
                            abilityScoreText = character.getDexterityMod() + " + ";
                            character.getSkill(i).setAbilityScore(character.getDexterityMod());
                            break;
                        case 2:
                            abilityScoreText = character.getConstitutionMod() + " + ";
                            character.getSkill(i).setAbilityScore(character.getConstitutionMod());
                            break;
                        case 3:
                            abilityScoreText = character.getIntelligenceMod() + " + ";
                            character.getSkill(i).setAbilityScore(character.getIntelligenceMod());
                            break;
                        case 4:
                            abilityScoreText = character.getWisdomMod() + " + ";
                            character.getSkill(i).setAbilityScore(character.getWisdomMod());
                            break;
                        case 5:
                            abilityScoreText = character.getCharismaMod() + " + ";
                            character.getSkill(i).setAbilityScore(character.getCharismaMod());
                            break;
                    }
                    text += character.getSkill(i).getTotal() + " = ";
                    text += abilityScoreText;
                    text += character.getSkill(i).getRanks() + " + ";
                    text += character.getSkill(i).getMisc();
                    skillLabels[i].setText(text);
                }
            }
        }

        JButton updateSkills = new JButton("Update Skills");
        ActionListener skillFieldListener = new SkillFieldListener();
        updateSkills.addActionListener(skillFieldListener);

        JLabel nameLabel = new JLabel("Name: " + character.getName());
        //JLabel classLabel = new JLabel("Class: " + character.getClassName());
        JLabel strengthLabel = new JLabel("Strength: " + character.getStrength() + " (+" + character.getStrengthMod() + ")");
        JLabel dexterityLabel = new JLabel("Dexterity: " + character.getDexterity() + " (+" + character.getDexterityMod() + ")");
        JLabel constitutionLabel = new JLabel("Constitution: " + character.getConstitution() + " (+" + character.getConstitutionMod() + ")");
        JLabel intelligenceLabel = new JLabel("Intelligence: " + character.getIntelligence() + " (+" + character.getIntelligenceMod() + ")");
        JLabel wisdomLabel = new JLabel("Wisdom: " + character.getWisdom() + " (+" + character.getWisdomMod() + ")");
        JLabel charismaLabel = new JLabel("Charisma: " + character.getCharisma() + " (+" + character.getCharismaMod() + ")");

        JPanel namePanel = new JPanel();
        namePanel.add(nameLabel);
        //panel.add(classLabel);

        JPanel statPanel = new JPanel();
        statPanel.add(strengthLabel);
        statPanel.add(dexterityLabel);
        statPanel.add(constitutionLabel);
        statPanel.add(intelligenceLabel);
        statPanel.add(wisdomLabel);
        statPanel.add(charismaLabel);

        JPanel healthPanel = new JPanel();
        healthPanel.add(healthLabel);
        healthPanel.add(healthField);
        healthPanel.add(updateHealth);

        JPanel goldPanel = new JPanel();
        goldPanel.add(goldLabel);
        goldPanel.add(goldField);
        goldPanel.add(updateGold);

        JPanel silverPanel = new JPanel();
        silverPanel.add(silverLabel);
        silverPanel.add(silverField);
        silverPanel.add(updateSilver);

        JPanel copperPanel = new JPanel();
        copperPanel.add(copperLabel);
        copperPanel.add(copperField);
        copperPanel.add(updateCopper);

        JPanel moneyPanel = new JPanel();
        moneyPanel.setLayout(new BoxLayout(moneyPanel, BoxLayout.Y_AXIS));
        moneyPanel.add(goldPanel);
        moneyPanel.add(silverPanel);
        moneyPanel.add(copperPanel);

        JPanel expPanel = new JPanel();
        expPanel.add(expLabel);
        expPanel.add(expField);
        expPanel.add(updateExp);

        JPanel skillsPanel = new JPanel();
        skillsPanel.setLayout(new GridLayout(39, 3));
        for (int i = 0; i < 39; i++) {
            skillsPanel.add(skillLabels[i]);
            skillsPanel.add(skillFields[i][0]);
            skillsPanel.add(skillFields[i][1]);
            /*
            JPanel sPanel = new JPanel();
            sPanel.add(skillLabels[i]);
            sPanel.add(skillFields[i][0]);
            sPanel.add(skillFields[i][1]);
            skillsPanel.add(sPanel);
            */
        }
        skillsPanel.add(updateSkills);

        JPanel northPanel = new JPanel();
        northPanel.add(namePanel);
        northPanel.add(statPanel);

        JPanel westPanel = new JPanel();
        //westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
        westPanel.add(healthPanel);
        westPanel.add(moneyPanel);
        westPanel.add(expPanel);

        JPanel eastPanel = new JPanel();
        skillsPanel.setPreferredSize(new Dimension(500, 750));
        JScrollPane skillScrollPane = new JScrollPane(skillsPanel);
        eastPanel.add(skillScrollPane);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(westPanel, BorderLayout.WEST);
        panel.add(eastPanel, BorderLayout.EAST);

        frame.add(panel);
        frame.setVisible(true);

    }

}
