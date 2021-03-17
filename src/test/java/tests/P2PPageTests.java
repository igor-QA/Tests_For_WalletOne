package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("Igor Pavlov")
public class P2PPageTests extends TestBase {

    @Test
    @Story("Пользователь должен успешно отправить заполненную форму")
    @DisplayName("Проверить форму в разделе 'Сделка Без Риска' ")
    public void checkFormOnPageDealWithoutRisk(){
        step("Открыть страницу и перейти к заполнению формы", () -> {
            open("p2p/");
            $(byText("Отправить заявку")).click(); });

        step("Заполнить и отправить форму", () -> {
            $(byName("fullname")).setValue("Test").pressTab();
            $(byName("tel")).setValue("89111111111").pressTab();
            $(byName("email")).setValue("test@test.ru").pressEnter(); });

        step("Проверить успешность отправки формы", () ->
            $("div.form-success").should(text("Спасибо! Мы свяжемся с вами для уточнения деталей.")));
    }
}