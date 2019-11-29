/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miagem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author charleneturbe
 */
public class ScoreCalculateurTest {
    
    private ScoreCalculateur calculateur;
    private QuestionAChoixMultiple question;
    public ScoreCalculateurTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.calculateur = new ScoreCalculateur();
        this.question = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)),5);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculeScore method, of class ScoreCalculateur.
     */
    @Test
    public void testCalculeScore() {
      // when : un étudiant fourni toutes les bonnes réponses 
     List<Integer> reponses = new ArrayList<>(Arrays.asList(2,3,5));
     // and : on calcul le score total 
     Float score = calculateur.calculeScore(reponses, question);
     // then : le score est égal à 100
     assertEquals(new Float(100f),score,0.1f);
     //when : un étudiant fourni une partie des bonnes reponses
     reponses = new ArrayList<>(Arrays.asList(2,3));
     // and : on calcul le score total
     score = calculateur.calculeScore(reponses, question);
     // then : le score est égal 
     assertEquals(new Float(2*100f/3),score,0.1f);
     // when : un étudient fourni que des mauvaises reponses
     reponses = new ArrayList<>(Arrays.asList(1,4));
     // and : on calcul le score total
     score = calculateur.calculeScore(reponses, question);
     // then : le score est égal à 0
     assertEquals(new Float(0f), score);
     // when : un étudiant fourni les reponses 1,2,3,4,5
     reponses = new ArrayList<>(Arrays.asList(1,2,3,4,5));
     // and : on calcul le score total
     score = calculateur.calculeScore(reponses, question);
     // then : le score est égal à 0 
     assertEquals(new Float(0f),score);
     // when : un étudiant fourni les reponses 1,2,3
     reponses = new ArrayList<>(Arrays.asList(1,2,3));
     // and : on calcul le score total
     score = calculateur.calculeScore(reponses,question);
     // then : le score est égal à 16,66
     assertEquals(new Float(16.66f),score,0.01f);
     }
}
