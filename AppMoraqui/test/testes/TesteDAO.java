/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import dao.UsuarioDao;
import junit.framework.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 *
 * @author Marcello
 */
public class TesteDAO {
    UsuarioDao dao;
    public TesteDAO() {
        dao=new UsuarioDao();                
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testeLoginLocator() {
        assertEquals(true,dao.LoginLocator("222.222.222-22","222222"));
        assertEquals(false,dao.LoginLocator("222.222.222-22","222221"));
        assertEquals(false,dao.LoginLocator("222.222.222-21","222222"));
    }
    
    @Test
    public void testeLoginLocatario() {
        assertEquals(true,dao.LoginLocatario("111.111.111-11","123456"));
        assertEquals(false,dao.LoginLocatario("111.111.111-11","222221"));
        assertEquals(false,dao.LoginLocatario("222.222.222-21","123456"));
    }
    
    @Test
    public void testeLoginGerenciador() {
        assertEquals("Wagner",dao.LoginGerenciador("333.777.222-99","112233"));
        assertEquals(null,dao.LoginGerenciador("333.777.222-99","222221"));
        assertEquals(null,dao.LoginGerenciador("222.222.222-21","112233"));
    }
    
}
