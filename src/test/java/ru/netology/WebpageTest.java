package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class WebpageTest {
    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999/");
        $("[data-test-id=city] .input__control").setValue("Москва");
        LocalDate date = LocalDate.now();
        String dateForTest = date.plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=date] [placeholder=\"Дата встречи\"]").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("input[placeholder=\"Дата встречи\"]").setValue(dateForTest);
        $("[data-test-id=name] [name=name]").setValue("Иван Сидоров");
        $("[data-test-id=phone] [name=phone]").setValue("+79200000011");
        $("[data-test-id=agreement]>.checkbox__box").click();
        $("button>.button__content").click();
        $("[data-test-id=notification]").waitUntil(visible, 15000).shouldHave(exactText("Успешно! Встреча успешно забронирована на " + dateForTest));
    }

//    @Test
//    void shouldSubmitComplexElementRequest() {
//        open("http://localhost:9999/");
//        $("[data-test-id=city] .input__control").setValue("Мо");
//        $$(".menu-item__control").findBy(text("Москва")).click();
//        $("[data-test-id=date] [placeholder=\"Дата встречи\"]").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE, when(false), Keys.CONTROL + "A", Keys.DELETE);
//        $$(".calendar__day").findBy(text(when(true))).click();
//        $("[data-test-id=name] [name=name]").setValue("Иван Сидоров");
//        $("[data-test-id=phone] [name=phone]").setValue("+79200000011");
//        $("[data-test-id=agreement]>.checkbox__box").click();
//        $("button>.button__content").click();
//        $("[data-test-id=notification]").waitUntil(visible, 15000).shouldHave(exactText("Успешно! Встреча успешно забронирована на "));
//    }
}
