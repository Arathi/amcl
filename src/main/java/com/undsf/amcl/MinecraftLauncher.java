package com.undsf.amcl;

import com.undsf.amcl.configs.Configuration;
import com.undsf.amcl.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Slf4j
public class MinecraftLauncher {
    public MinecraftLauncher() {
    }

    public boolean launch(String name, Map<String, String> params) {
        StringBuilder cmd = new StringBuilder();

        try {
            String path = "D:\\Games\\Minecraft\\1.18\\.minecraft\\versions\\1.18.2\\1.18.2.json";
            File versionFile = new File(path);
            String json = FileUtils.readFileToString(versionFile, StandardCharsets.UTF_8);
            Configuration config = JsonUtil.readValue(json, Configuration.class);
            log.info("版本配置文件{}读取成功", path);
        }
        catch (IOException ex) {
            log.info("启动时发生IO异常", ex);
        }

        return false;
    }
}
