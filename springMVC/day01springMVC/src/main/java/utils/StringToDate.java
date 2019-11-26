package utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把字符串转换为日期
 */
public class StringToDate  implements Converter<String,Date> {
    /**
     *
     * @param s --传过来的值
     * @return
     */
    @Override
    public Date convert(String s) {
        if(s==null){
            throw new RuntimeException("请您传入参数.....");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
           return df.parse(s);
        } catch (Exception e) {
            throw new RuntimeException("类型转换错误...");
        }
    }
}
