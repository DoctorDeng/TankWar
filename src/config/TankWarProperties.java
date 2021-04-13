package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 坦克大战配置类.
 *
 * @author <a href="http://doctordeng.github.io">DoctorDeng</a>
 * @date 2021/4/13 12:53
 * @since 1.0.0
 */
public class TankWarProperties {
    private static final String CONFIG_FILE = "conf/tankwar.properties";
    private static final Logger LOGGER = Logger.getLogger("config.TankWarProperties");
    /**
     * 是否开启登陆认证, true 开启, false 不开启(默认).
     */
    private Boolean loginAuthEnabled = false;

    {
        Properties properties = new Properties();
        try (FileInputStream fileStream = new FileInputStream(CONFIG_FILE)) {
            properties.load(fileStream);
            init(properties);
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.WARNING, "配置文件不存在", e);
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "无法读取配置文件", e);
        }
    }
    private void init(Properties properties) {
        if (properties == null || properties.isEmpty()) {
            return;
        }
        String loginAuthEnabled = properties.getProperty("login.auth.enabled", "false");
        this.loginAuthEnabled = Boolean.valueOf(loginAuthEnabled);
    }

    public Boolean getLoginAuthEnabled() {
        return loginAuthEnabled;
    }

    public void setLoginAuthEnabled(Boolean loginAuthEnabled) {
        this.loginAuthEnabled = loginAuthEnabled;
    }
}
