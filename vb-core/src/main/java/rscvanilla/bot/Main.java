package rscvanilla.bot;

import com.google.inject.Guice;
import rscvanilla.bot.infrastructure.BotException;
import rscvanilla.bot.infrastructure.di.BotModule;
import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String [] args) {

        try {
            Guice.createInjector(new BotModule(getCaptchaDirPath(), getScriptsDirectoryPath())).getInstance(VanillaBot.class).load();
        } catch (BotException e) {
            logger.error("BOT FAILED:", e);
        }
    }

    private static String getUserDir() {
        return System.getProperty("user.dir") + File.separator;
    }

    //TODO: Injectable
    public static String getAntiBanSoundPath() {
        return getUserDir() + "res" + File.separator + "antiban" + File.separator + "notify.wav";
    }

    private static String getCaptchaDirPath() {
        return getUserDir() + File.separator + "res" + File.separator + "captcha";
    }

    private static String getScriptsDirectoryPath() {
        return getUserDir() + File.separator + "scripts";
    }
}