package com.network.pages;

import com.network.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class AnaSayfa {
    Methods methods;

    public AnaSayfa(){
        methods = new Methods();
    }

    public void anaSayfaTest(){
        methods.waitBySecond(5);
        methods.goUrl("https://www.network.com.tr/");
        methods.checkUrlCont("www.network.com.tr");
        methods.click(By.id("search"),"Arama Sekmesi");
        methods.sendKeys(By.id("search"),"Ceket","Arama Sekmesi");
        methods.sendEnter(By.id("search"),"Arama Sekmesi");
        methods.waitBySecond(5);
        methods.scrollTo(By.xpath("//*[@class='button -secondary -sm relative']"), "Daha Fazla Goster Butonu");
        methods.waitBySecond(3);
        methods.click(By.xpath("//*[@class='button -secondary -sm relative']"), "Daha Fazla Goster Butonu");
        methods.waitBySecond(3);
        methods.checkUrlCont("page=2");
        methods.click(By.id("go-to-top"),"Ilk Urune Gıt Buton");

    }











}
