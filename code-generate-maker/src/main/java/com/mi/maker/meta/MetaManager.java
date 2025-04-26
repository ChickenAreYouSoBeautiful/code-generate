package com.mi.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;
import com.mi.maker.meta.Meta.FileConfig;

/**
 * @author mi
 * @data 2025/4/22 17:15
 * @version 1.0
 */

public class MetaManager {

    private static volatile Meta meta;

    private MetaManager() {
    }

    public static Meta getMetaObj() {
        if (meta == null){
            synchronized (MetaManager.class){
                if (meta == null){
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    private static  Meta initMeta() {

        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        FileConfig fileConfig = newMeta.getFileConfig();
        //校验file配置

        return newMeta;
    }
}
