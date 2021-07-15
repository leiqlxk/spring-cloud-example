package org.lql;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Title: Test <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/15 11:04 <br>
 */
public class Test {

    public static void main(String[] args) {
        String minTime = ZonedDateTime.now().plusHours(1).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
        System.out.println(minTime);
    }
}
