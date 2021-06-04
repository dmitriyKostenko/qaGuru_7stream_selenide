package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class FindJUnit5ExampleTest {

    @Test
    public void shouldFindJUnit5Example() {

        //Откройте страниц Selenide в Github
        open("https://github.com/");
        $("[name=q]").val("selenide").pressEnter();
        $("ul.repo-list a").click();
        $("h1").shouldHave(text("selenide / selenide"));

        // - Перейдите в раздел Wiki проекта
        $(byText("Wiki")).click();
        $("#wiki-wrapper").shouldHave(text("Welcome to the selenide wiki!"));

        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").val("SoftAssertions");
        $(byText("SoftAssertions")).click();

        // - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));

    }

}
