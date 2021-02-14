package rscvanilla.cjci.updater.core.matcher.classes.mudclient.interceptors;

import rscvanilla.cjci.model.annotations.YamlClassMemberKey;
import rscvanilla.cjci.updater.core.matcher.ClassMemberNameBaseMatcher;
import rscvanilla.cjci.updater.core.matcher.classes.mudclient.MudClientClassInterceptorNameMatcher;

import java.util.regex.Pattern;

@YamlClassMemberKey("game_settings")
public class GameSettingsInterceptorNameMatcher extends ClassMemberNameBaseMatcher implements MudClientClassInterceptorNameMatcher {

    public GameSettingsInterceptorNameMatcher() {
        pattern = Pattern.compile(
                "(?<pre>private void )(?<fieldName>[a-zA-Z])(?<post>\\(com\\.rsc\\.f\\.a var1, int var2, int var3\\))",
            Pattern.MULTILINE
        );
    }
}