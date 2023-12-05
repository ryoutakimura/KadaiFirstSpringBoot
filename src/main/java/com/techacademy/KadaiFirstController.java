package com.techacademy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    //val1に指定した日付の曜日を表示する
    @GetMapping("/dayofweek/{val1}")
    public String dispDayOfWeek(@PathVariable int val1) {
        int y = val1 / 10000; //年の取得
        int m = (val1 % 10000) /100; //月の取得
        int s = val1 % 100; //秒の取得

        //入力された日付からLocalDateのインスタンス生成
        LocalDate Date = LocalDate.of(y, m, s);
        //入力された日付の曜日を取得
        DayOfWeek dayOfWeek = Date.getDayOfWeek();
        //英語表記で曜日を表示
        return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    //val1とval2の加算を表示する
    @GetMapping("/plus/{val1}/{val2}")
    public int calcPlus(@PathVariable int val1,@PathVariable int val2) {
        int result = val1 + val2;
        return result;
    }

    //val1とval2の減算を表示する
    @GetMapping("/minus/{val1}/{val2}")
    public int calcMinus(@PathVariable int val1,@PathVariable int val2) {
        int result = val1 - val2;
        return result;
    }

    //val1とval2の乗算を表示する
    @GetMapping("/times/{val1}/{val2}")
    public int calcTimes(@PathVariable int val1,@PathVariable int val2) {
        int result = val1 * val2;
        return result;
    }

    //val1とval2の除算を表示する
    @GetMapping("/divide/{val1}/{val2}")
    public float calcDivide(@PathVariable int val1,@PathVariable int val2) {
        float result = (float)val1 / val2;
        return result;
    }


}
