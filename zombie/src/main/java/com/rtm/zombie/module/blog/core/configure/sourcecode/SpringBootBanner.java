/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: SpringBootBanner
 * Author:   Dell
 * Date:     2018/10/7 13:51
 * Description: 用于测试修改默认的springboot 启动图像
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rtm.zombie.module.blog.core.configure.sourcecode;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

/**
 * 〈Coding never to stop〉<br> 
 * 〈用于测试修改默认的springboot 启动图像〉
 *
 * @author zombie
 * @create 2018/10/7
 * @since 1.0.0
 */
@Component
public class SpringBootBanner implements Banner {

    private static final String[] BANNER = { "",
            "  .   ____          _            __ _ _",
            " /\\\\ / ___'_ __ _ _(_)_ __  __ _ \\ \\ \\ \\",
            "( ( )\\___ | '_ | '_| | '_ \\/ _` | \\ \\ \\ \\",
            " \\\\/  ___)| |_)| | | | | || (_| |  ) ) ) )",
            "  '  |____| .__|_| |_|_| |_\\__, | / / / /",
            " =========|_|==============|___/=/_/_/_/" };

    private static final String SPRING_BOOT = " :: Spring Boot :: ";

    private static final String AUTHOR = " :: Zombie :: ";

    private static final int STRAP_LINE_SIZE = 42;

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream printStream) {
        for (String line : BANNER) {
            printStream.println(line);
        }
        String version = SpringBootVersion.getVersion();
        version = (version != null) ? " (v" + version + ")" : "";
        StringBuilder padding = new StringBuilder();
        while (padding.length() < STRAP_LINE_SIZE
                - (version.length() + SPRING_BOOT.length())) {
            padding.append(" ");
        }

        printStream.println(AnsiOutput.toString(AnsiColor.GREEN, SPRING_BOOT,
                AnsiColor.BRIGHT_RED, padding.toString(), AnsiStyle.FAINT, version));
        printStream.println();
    }
}
