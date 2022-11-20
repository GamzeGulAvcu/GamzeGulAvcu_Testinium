package com.network.pages;

import com.network.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Urun {
    Methods methods;
    Logger logger = LogManager.getLogger(Urun.class);

    public Urun() {
        methods = new Methods();
    }

    public void UrunTest() {

        methods.waitBySecond(3);
        methods.hoverElement(By.xpath("(//*[@class='product__title'])[1]"), "Ilk Urun");
        methods.waitBySecond(1);
        methods.click(By.xpath("(//*[@class='product__title'])[1]"), "Ilk Urun");
        methods.waitBySecond(3);
        methods.randomSelect("Beden Secimi");
        methods.waitBySecond(1);
        methods.click(By.xpath("//*[@class='product__button -addToCart btn -black']"),"Sepete Ekle Buton");
        methods.waitBySecond(3);
        methods.click(By.xpath("//*[text()='Sepete Git']"),"Sepete Git Buton");
        methods.waitBySecond(1);
        methods.elementControl(By.xpath("//*[@class='cartItem__price -old -labelPrice']"),"Eski Fiyat");
        methods.click(By.xpath("//*[@class='continueButton n-button large block text-center -primary']"),"Devam Et Buton");
        methods.waitBySecond(3);
        methods.sendKeys(By.id("n-input-email"),"gamzegul.avcu@hotmail.com","Eposta Adı Girisi");
        methods.sendKeys(By.id("n-input-password"),"gamzegulavcu","Sifre Adı Girisi");
        methods.click(By.xpath("//*[@class='headerCheckout__logo']"),"Network Logosu");
        methods.waitBySecond(3);
        methods.click(By.xpath("(//*[@class='header__icon -shoppingBag'])[1]"),"Çanta Logosu");
        methods.waitBySecond(3);
        methods.click(By.xpath("//*[@class='header__basketProductBtn header__basketModal -remove']"),"Urun Sil Buton");
        methods.waitBySecond(1);
        methods.click(By.xpath("//*[@class='btn -black o-removeCartModal__button']"),"Çıkart Buton");
        methods.waitBySecond(1);
        methods.click(By.xpath("(//*[@class='header__icon -shoppingBag'])[1]"),"Çanta Logosu");
        methods.waitBySecond(1);
        methods.elementControl(By.xpath("//*[@class='header__emptyBasketText']"), "Boş Sepet");
        methods.waitBySecond(10);







    }


}


