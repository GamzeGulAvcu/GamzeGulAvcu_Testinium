package com.network.testrun;

import com.network.driver.TestBase;
import com.network.pages.AnaSayfa;
import com.network.pages.Urun;
import org.junit.Test;

public class UrunTest extends TestBase {

    @Test
    public void productSearchTest(){
        AnaSayfa anaSayfa = new AnaSayfa();
        Urun urun = new Urun();
        anaSayfa.anaSayfaTest();
        urun.UrunTest();
    }




}
