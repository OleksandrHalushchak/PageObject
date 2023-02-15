package main.components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class Products  {
    private WebElement image;
    private WebElement nameWeb;
    private String name;
    private String description;
    private String priceNew;
    private String priceOld;
    private String priceTax;
    private WebElement AddToCart;
    private WebElement AddToWisList;
    private WebElement CompareThisProduct;

      public Products(WebElement container) {
        this.image = container.findElement(By.xpath(".//div[@class='image']//img"));
        this.nameWeb = container.findElement(By.xpath(".//div[@class='description']//a"));
        this.name = nameWeb.getText();
        this.description = container.findElement(By.xpath(".//div[@class='description']//p")).getText();
        this.priceNew = container.findElement(By.xpath(".//span[@class='price-new']")).getText();
        this.priceTax = container.findElement(By.xpath(".//span[@class='price-tax']")).getText();
        this.AddToCart = container.findElement(By.xpath(".//div[@class='button-group']//i[@class='fas fa-shopping-cart']"));
        this.AddToWisList = container.findElement(By.xpath(".//div[@class='button-group']//i[@class='fas fa-heart']"));
        this.CompareThisProduct = container.findElement(By.xpath(".//div[@class='button-group']//i[@class='fas fa-exchange-alt']"));

          try {
              this.priceOld = container.findElement(By.xpath(".//span[@class='price-old']"))
                      .getText();
          } catch (NoSuchElementException e) {
              this.priceOld = null;
          }

      }
}
