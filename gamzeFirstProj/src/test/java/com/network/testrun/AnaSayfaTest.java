package com.network.testrun;

import com.network.driver.TestBase;
import com.network.pages.AnaSayfa;
import org.junit.Test;

public class AnaSayfaTest extends TestBase {

    @Test
    public void anasayfaTesti(){
        AnaSayfa anaSayfa = new AnaSayfa();
        anaSayfa.anaSayfaTest();
    }
}
