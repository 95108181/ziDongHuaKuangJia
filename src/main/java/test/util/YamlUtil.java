package test.util;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;

/**
 * name:wq
 * date:2020年6月16日16:06:54
 */
public class YamlUtil {
    /**
     * 读取yam文件
     *
     * @param address
     * @return
     */
    public static HashMap<String, String> readYaml(String address) {
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            Yaml yaml = new Yaml();
            URL url = YamlUtil.class.getClassLoader().getResource(address);
            if (url != null) {
                //获取test.yaml文件中的配置数据，然后转换为obj，
                Object obj = yaml.load(new FileInputStream(url.getFile()));
                //也可以将值转换为Map
                map = (HashMap<String, String>) yaml.load(new FileInputStream(url.getFile()));
                System.out.println(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return map;
    }
}
