import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class MybatisGenerateRun {

    public static void main(String[] args) throws Exception {

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //加载generatorConfig文件
        File configFile = new File(
            MybatisGenerateRun.class.getClassLoader().getResource("generatorConfig.xml").getPath());
        //加载数据库信息，例如username,password,url等
        Properties extraProperties = PropertiesLoaderUtils.loadAllProperties("application.properties");

        String root = configFile.getParentFile().getParentFile().getParentFile().getPath();
        System.err.println(root);

        extraProperties.setProperty("root", root);
        try {
            Properties dao = PropertiesLoaderUtils.loadAllProperties("dao.properties");
            if (dao.isEmpty()) {
                return;
            }
            dao.stringPropertyNames().forEach(name -> {
                extraProperties.setProperty(name, dao.getProperty(name));
            });
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }


        ConfigurationParser cp = new ConfigurationParser(extraProperties, warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        if (!warnings.isEmpty()) {
            for (String warn : warnings) {
                System.out.println(warn);
            }
        }
        System.out.println("生成成功！");
    }

}
