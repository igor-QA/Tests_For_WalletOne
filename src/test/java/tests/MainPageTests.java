package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
@Owner("Igor Pavlov")
public class MainPageTests extends TestBase {

    @Test
    @Story("Пользователь должен перейти на страницу Тарифы с основной страницы сайта")
    @DisplayName("Проверить раздел Тарифы")
    public void checkTariffPage() {
    step("Открыть Страницу и перейти в раздел Тарифы", () -> {
        open("merchant/");
        $(byText("Тарифы")).scrollIntoView(true).click(); });

    step("Проверить успешность выпонения теста", () ->
        $("#pricing h1").shouldBe(visible));
    }

    @Test
    @Story("Пользователь должен успешно перейти в раздел 'O Wallet One'")
    @DisplayName("Проверить раздел 'O Wallet One'")
    public void checkAboutWalletPage(){
    step("Открыть страницу и перейти в раздел 'O Wallet One' ", () -> {
        open("merchant/");
        $(byText("О Wallet One")).scrollIntoView(true).click(); });

    step("Проверить успешность выпонения теста", () ->
        $(".slogan").should(text("Лучший платежный сервис")));
    }
    @Test
    @Story("Пользователь должен успешно воспользоваться оплатой без регистрации")
    @DisplayName("Проверить оплату без ригистрации")
    public void checkPayWithoutRegistration(){
    step("Открыть страницу и перейти к Оплате без регистрации", () -> {
        open("wallet/");
        $(byText("Оплатить без регистрации")).scrollTo(); });

    step("Выбрать оплату 'ВКонтакте' ", () -> {
        $(byText("ВКонтакте")).click();
        switchTo().window(1); });

    step("Проверить успешность выпонения теста", () ->
        $("#master-content").should(text("Провайдер временно недоступен"))); //TODO Не реализован метод
    }

    @Test
    @Story("Пользователь должен успешно перейти в раздел Франшиза")
    @DisplayName("Проверить раздел Франшиза")
    public void checkFranchisePage() {
    step("Открыть страницу и перейти в раздел Франшиза", () -> {
        open("wallet/");
        $(byText("Франшиза")).scrollIntoView(true).click(); });

    step("Проверить успешность выпонения теста", () ->
        $(".haction").should(text(("Вход для партнёров"))));
    }
}