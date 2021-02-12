package rscvanilla.hook.updater.core.matcher.classes.rsentity.fields;

import rscvanilla.hook.model.annotations.YamlClassMemberKey;
import rscvanilla.hook.updater.core.matcher.ClassMemberNameBaseMatcher;
import rscvanilla.hook.updater.core.matcher.classes.rsentity.RSEntityClassFieldNameMatcher;

import java.util.regex.Pattern;

@YamlClassMemberKey("server_index")
public class ServerIndexFieldNameMatcher extends ClassMemberNameBaseMatcher implements RSEntityClassFieldNameMatcher {

    public ServerIndexFieldNameMatcher() {
        pattern = Pattern.compile(
            "(?<pre>public abstract class d \\{\\R" +
            " {3}protected int [a-zA-Z]{2};\\R" +
            " {3}protected int [a-zA-Z]{2};\\R" +
            " {3}protected int )(?<fieldName>[a-zA-Z]{2})(?<post>;\\R" +
            " {3}protected int [a-zA-Z]{2};\\R" +
            " {3}protected int [a-zA-Z]{2};\\R" +
            " {3}protected int [a-zA-Z]{2};\\R" +
            " {3}protected int [a-zA-Z]{2};\\R" +
            " {3}private boolean [a-zA-Z]{2};\\R)",
            Pattern.MULTILINE
        );
    }
}