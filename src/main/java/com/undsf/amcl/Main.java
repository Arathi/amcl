package com.undsf.amcl;

import org.apache.commons.cli.*;

import java.util.Map;

public class Main {
    public static void printHelp() {
        System.out.println("amcl v0.1.0");

        // 安装本体
        System.out.println("amcl install minecraft 1.16.5");
        System.out.println("amcl install minecraft 1.18.2 --name=1.18");

        // 安装MOD加载器
        System.out.println("amcl install forge 40.0.40");
        System.out.println("amcl install forge 36.2.24 --name=1.16.5");
        System.out.println("amcl install fabric");

        // 更新本体
        System.out.println("amcl upgrade");
        System.out.println("amcl upgrade --name=1.16.5");

        // 查看已安装版本
        System.out.println("amcl versions");

        System.out.println("amcl launch");
        System.out.println("amcl launch --name=1.18");
    }

    public static void launch(String name, Map<String, String> params) {
        MinecraftLauncher mcl = new MinecraftLauncher();
        mcl.launch(name, params);
    }

    public static void main(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("h", "help", false, "显示帮助");
        options.addOption("v", "version", false, "显示版本");
        options.addOption("n", "name", true, "指定名称");

        CommandLineParser parser = new DefaultParser();
        CommandLine cli = parser.parse(options, args);

        if (cli.hasOption("h")) {
            printHelp();
            return;
        }

        if (cli.hasOption("v")) {
            printHelp();
            return;
        }

        launch("1.18.2", null);
    }
}
