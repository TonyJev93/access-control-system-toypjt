package com.toy.accesscontrol.user.adapter.global.p6spy;

import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.hibernate.engine.jdbc.internal.FormatStyle;
import org.springframework.util.ObjectUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class P6spyPrettySqlFormatter implements MessageFormattingStrategy {
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        var formattedSql = formatSql(category, sql);
        var currentDate = new Date();
        var dateFormat = new SimpleDateFormat("yy.MM.dd HH:mm:ss");

        return String.format("[%s] %s | %dms %s", category.toUpperCase(), dateFormat.format(currentDate), elapsed, formattedSql);
    }

    private String formatSql(String category, String sql) {
        if (ObjectUtils.isEmpty(sql)) {
            return sql;
        }

        if (Category.STATEMENT.getName().equals(category)) {
            String tempSql = sql.trim().toLowerCase(Locale.ROOT);
            if (tempSql.startsWith("create") || tempSql.startsWith("alter") || tempSql.startsWith("comment")) {
                sql = FormatStyle.DDL.getFormatter().format(sql);
            } else {
                sql = FormatStyle.BASIC.getFormatter().format(sql);
            }

            sql = "|\nHeFormatSql(P6Spy sql,Hibernate format):" + sql;
        }

        return sql;
    }
}
