/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miagem1;

import java.util.ArrayList;
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
public class QuestionAChoixMultipleTest {
    
    private QuestionAChoixMultiple question;
    private List<Integer> reponses ;
    
    public QuestionAChoixMultipleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        reponses = new ArrayList<>();
        reponses.add(1);
        reponses.add(4);
        //given : un objet de type QuestionAChoixMultiple
        this.question = new QuestionAChoixMultiple("un énoncé",reponses);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEnonce method, of class QuestionAChoixMultiple.
     */
    @Test
    public void testGetEnonce() {
        //when : on demande l'énoncé à la question
        String resultEnonce = question.getEnonce();
        //then : l'enonce est non null
        assertNotNull(resultEnonce);
        //and : l'enonce est bien celui fourni à la construction
        assertEquals(resultEnonce,"un énoncé");
    }

    /**
     * Test of getScoreForIndice method, of class QuestionAChoixMultiple.
     */
    @Test
    public void testGetScoreForIndice() {
        // when : un étudiant fourni un indice correspondant à une bonne réponse
        int indice = 4;
        // and : on demande le calcul du score
        Float score = question.getScoreForIndice(indice);
        // then : le score obtenu est de 50
        assertEquals(new Float(100f/reponses.size()),score);
        //when : un étudiant fourni un indice correspondant à une mauvaise réponse 
        indice = 3;
        // and : on demande le calcul du score 
        score = question.getScoreForIndice(indice);
        //then : le score obtenu est de 0
        assertEquals(new Float(0f),score);
    }
    
}
