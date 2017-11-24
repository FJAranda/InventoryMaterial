package com.example.inventoryMVP;

import com.example.inventoryMVP.utils.CommonUtils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void signIn_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        //1. El usuario introduce usuario y contraseña
        //2. El usuario existe en la base de datos
        //3. La contraseña tiene al menos 6 caracteres
        //3. La contraseña es correcta
        //4.
    }

    @Test
    public void signUp_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        //1. El usuario introduce usuario y contraseña
        //2. El usuario existe en la base de datos
        //3. La contraseña tiene al menos 6 caracteres
        //4. La contraseña es correcta
        //5. El email no existe en la base de datos
        //6. EL usuario no existe en la base de datos
    }

    @Test
    public void passwordPattern_isCorrect() throws Exception{
        assertTrue(CommonUtils.isPasswordValid("1Aammm"));
        assertTrue(CommonUtils.isPasswordValid("mmm1Aa"));
        assertFalse(CommonUtils.isPasswordValid("1Aamm"));
        assertFalse(CommonUtils.isPasswordValid("1ammmm"));
        assertFalse(CommonUtils.isPasswordValid("Aammmm"));
    }

}