/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miagem1;

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
public class QuestionAChoixExclusifTest {
    private QuestionAChoixExclusif question;
    
    public QuestionAChoixExclusifTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // given : un objet de type QuestionAChoixExclusif
        this.question = new QuestionAChoixExclusif("un énoncé", 2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEnonce method, of class QuestionAChoixExclusif.
     */
    @org.junit.Test
    public void testGetEnonce() {
        // when : on demande l'ennoncé à la question
        String resultatEnonce = question.getEnonce();
        //then : l'énoncé est non null
        assertNotNull(resultatEnonce);
        //and : l'enoncé est bien celui fourni à la construction
        assertEquals(resultatEnonce,"un énoncé");
    }

    /**
     * Test of getScoreForIndice method, of class QuestionAChoixExclusif.
     */
    @org.junit.Test
    public void testGetScoreForIndice() {
      // when : un étudiant fourni l'indice correspondant à la bonne réponse
      int indiceEtudiant = 2; 
      // and : on demande le calcul du score
      Float res = question.getScoreForIndice(indiceEtudiant);
      // then : le score obtenu est de 100
      assertEquals(new Float(100f),res);
      // when : un etudiant fourni l'indice correspondant à une mauvaise réponse
      indiceEtudiant = 3;
      //and : on demande le calcul du score
      res = question.getScoreForIndice(indiceEtudiant);
      //then : le score obtenu est de 0 
      assertEquals(new Float(0f), res);
    }
    
}
