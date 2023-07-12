package com.delivery.store;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StoreService {
    private static String storeURL = "https://www.mangoplate.com/search/%EA%B0%95%EC%84%9C%EA%B5%AC%20%ED%99%94%EA%B3%A1%EB%8F%99%20%ED%94%BC%EC%9E%90%20";
    private static String storeDetailURL = "https://www.mangoplate.com/restaurants/QPr6GVIc4Y";

    public List<StoreVO> getStoreList() throws IOException {
        List<StoreVO> storeList = new ArrayList<>();
        Document document = Jsoup.connect(storeURL).get();
        Elements contents = document.select("figure.restaurant-item");

        for (Element content : contents) {
            StoreVO storeVO = StoreVO.builder()
                    .title(content.select("div.info a h2.title").text()) //제목
                    .image(content.select("a div img").attr("abs:data-original")) // 이미지
                    .subdivision(content.select("p.etc").text()) //위치
                    .build();
            storeList.add(storeVO);
        }

        return storeList;
    }
    public List<StoreVO> getStoreDetail() throws IOException {
        List<StoreVO> storeList = new ArrayList<>();
        Document document = Jsoup.connect(storeDetailURL).get();
        Elements contents = document.select("figure.restaurant-item");
        log.error("::::{}::::::",document);
        for (Element content : contents) {
            StoreVO storeVO = StoreVO.builder()
                    .title(content.select("h1.restaurant_name").text()) //제목
                    .image(content.select("figure.restaurant-photos-item img").attr("abs:data-original")) // 이미지
                    .address(content.select("table").text())
//                    .phoneNumber(content.select(""))
                    .build();
            storeList.add(storeVO);
        }

        return storeList;
    }
















//    public List<StoreVO> getStoreList() throws Exception {
//        //drvier 설정 뒷쪽 내 크롬드라이버exe 위치
//        System.setProperty("webdriver.chrome.driver","C:\\win\\chromedriver_win32\\chromedriver.exe");
//
//        //옵션 생성
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);
//        WebDriver driver = new ChromeDriver();
        //창 숨기는 옵션 추가
//        options.addArguments("headless");
//
//        WebDriver driver = null;

        //크롬실행 객체 만들기
//        driver = new ChromeDriver(options);

        //URL 접속(접속할 곳 적어주기)
//        driver.get("https://www.diningcode.com/list.dc?query=%EA%B0%95%EC%84%9C%EA%B5%AC%20%ED%99%94%EA%B3%A1%EB%8F%99%20%ED%94%BC%EC%9E%90");
        //창이 뜨고 바로 꺼지지 않게 5초정도 대기
//        List<StoreVO> storeVOList = new ArrayList<>();
        //조건이 성립할때까지 기다림 조건이 성립하지 않으면 설정된 시간만큼 기다림
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        //액션 추가 (움직이게 하는 기능)
//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.className("sc-hhyLtv jVyekH Poi__List__Wrap"))).click();
//        actions.sendKeys(Keys.END).perform();
//        Thread.sleep(2000);
//        actions.sendKeys(Keys.END).perform();
//        Thread.sleep(2000);
//        actions.sendKeys(Keys.END).perform();
//        Thread.sleep(2000);

        //클릭이가능할때까지 대기
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-sync")));
//        log.error("::::::::::{}:::::::::::", driver.getPageSource());
//        System.out.println(driver);
//        Thread.sleep(5000);
//
//        //click
//        driver.findElement(By.xpath("//*[@id=\"btn-sync\"]")).click();
//
//        //텍스트가 "최신정보"가 될때까지 대기
//        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        wait.until(ExpectedConditions.textToBe(By.id("btn-sync"), "최신정보"));
//
//        WebElement element =  driver.findElement(By.className("col-lg-8"));	//ID 정보

        // 드라이버 종료
//        driver.quit();

//        return storeVOList;
//        return storeVOList;
//    }
}
