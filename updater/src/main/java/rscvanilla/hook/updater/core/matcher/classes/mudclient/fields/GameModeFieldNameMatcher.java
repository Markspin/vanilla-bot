package rscvanilla.hook.updater.core.matcher.classes.mudclient.fields;

import rscvanilla.hook.model.annotations.YamlClassMemberKey;
import rscvanilla.hook.updater.core.matcher.ClassMemberNameBaseMatcher;
import rscvanilla.hook.updater.core.matcher.classes.mudclient.MudClientClassFieldNameMatcher;

import java.util.regex.Pattern;

@YamlClassMemberKey("game_mode")
public class GameModeFieldNameMatcher extends ClassMemberNameBaseMatcher implements MudClientClassFieldNameMatcher {

    public GameModeFieldNameMatcher() {
        pattern = Pattern.compile(
            "(?<pre> {3}private int [a-zA-Z]{2};\\R" +
            " {3}private f )(?<fieldName>[a-zA-Z]{2})(?<post>;\\R" +
            " {3}private int [a-zA-Z]{2};)",
            Pattern.MULTILINE
        );
    }
}
