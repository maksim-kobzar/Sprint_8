package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@DisplayName("Позитивные проверки")
public class AccountTest {

    @Test
    @DisplayName("Валидное значение")
    public void checkNameToEmboss() {
        Account account = new Account("Maksim Kobzar");
        Assert.assertTrue("Метод отработал не правильн", account.checkNameToEmboss());
    }

    @Test
    @DisplayName("В строке не меньше 3")
    public void checkNameToEmbossMax3() {
        Account account = new Account("Mak");
        Assert.assertTrue("Ошибка граничных значений <= 3", account.checkNameToEmboss());
    }

    @Test
    @DisplayName("В строке не меньше 3")
    public void checkNameToEmbossMax4() {
        Account account = new Account("Ma");
        Assert.assertFalse("Ошибка граничных значений >= 3", account.checkNameToEmboss());
    }

    @Test
    @DisplayName("В строке 19 символов")
    public void checkNameToEmbossMax5() {
        Account account = new Account("Maksim KobzarKobzar");
        Assert.assertTrue("Ошибка граничных значений = 19", account.checkNameToEmboss());
    }

    @Test
    @DisplayName("В строке больш 19 символов")
    public void checkNameToEmbossMax6() {
        Account account = new Account("Maksim KobzarKobzare");
        Assert.assertFalse("Ошибка граничных значений - в строке больше 19 значений", account.checkNameToEmboss());
    }

    @Test
    @DisplayName("Пробел в начале")
    public void checkNameToEmbossMax7() {
        Account account = new Account(" Maksim Kobzar");
        Assert.assertFalse("Ошибка - пробел в начале", account.checkNameToEmboss());
    }

    @Test
    @DisplayName("Пробел в конце")
    public void checkNameToEmbossMax() {
        Account account = new Account("Maksim Kobzar ");
        Assert.assertFalse("Ошибка - пробел в конце", account.checkNameToEmboss());
    }
}