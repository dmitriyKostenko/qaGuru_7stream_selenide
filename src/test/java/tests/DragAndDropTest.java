package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @Test
    public void tryDragAndDrop() {

        // Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#content").shouldHave(Condition.text("Drag and Drop"));

        // Проверим, что прямоугольники действительно на находятся на своих местах
        $("#column-a").shouldHave(Condition.text("A"));
        $("#column-b").shouldHave(Condition.text("B"));

        // Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));

        // Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(Condition.text("B"));

    }

}
