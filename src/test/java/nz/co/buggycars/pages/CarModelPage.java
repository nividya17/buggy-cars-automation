package nz.co.buggycars.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CarModelPage {

    private static By specification = By.xpath("//*/div[@class='card-block']/h4[contains(text(),'Specification')]");
    private static By votes = By.xpath("//*/div[@class='card-block']/h4[contains(text(),'Votes: ')]");
    private static By numberOfVotes = By.xpath("//*/div[@class='card-block']/h4[contains(text(),'Votes: ')]/strong");
    private static By votingSummaryTableHeader = By.xpath("//*/table[@class ='table']/thead[@class='thead-inverse']");
    private static By messageForVoting = By.xpath("//*/div[@class='card-block']/p[@class='card-text']");
    private static By voteButton = By.xpath("//button[@class='btn btn-success']");
    private static By commentBox = By.id("comment");
    private static By commentInTheTable = By.xpath("//*/table[@class='table']/tbody/tr[1]/td[3]");
    private static By thanksMessage = By.xpath("//*/div[@class='card-block']/p[@class='card-text']");

    public static CarModelPage expect() {
        CarModelPage carModelPage = new CarModelPage();
        carModelPage.loadCarModelPage();
        return carModelPage;
    }

    private void loadCarModelPage() {
        $(specification).shouldBe(visible);
        $(votes).shouldBe(visible);
        $(votingSummaryTableHeader).shouldBe(visible);
    }

    public void displayVotingMessage() {
        $(messageForVoting).shouldBe(visible).getText().equals("You need to be logged in to vote.");
    }

    public void voteButtonVisible() {
        $(voteButton).shouldBe(visible);
    }

    public void clickVote() {
        $(voteButton).shouldBe(visible).click();
    }

    public Integer getNumberOfVotes() {
        return Integer.valueOf($(numberOfVotes).getText().trim());
    }

    public void enterComment(String value) {
        $(commentBox).shouldBe(visible).setValue(value);
    }

    public String getUserComment() {
        $(votingSummaryTableHeader).scrollIntoView(true).shouldBe(visible);
        return $(commentInTheTable).shouldBe(visible).getText();
    }

    public String thanksMessageShouldBeDisplayed() {
        return $(thanksMessage).shouldBe(visible).getText();
    }
}
