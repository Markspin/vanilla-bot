package rscvanilla.hook.updater.core.matcher.classes.mudclient.fields;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rscvanilla.hook.updater.core.matcher.classes.BaseTests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class MidRegionBaseYFieldNameMatcherTests extends BaseTests {

    private MidRegionBaseYFieldNameMatcher matcher;

    @BeforeEach
    public void setMatcher() {
        matcher = new MidRegionBaseYFieldNameMatcher();
    }

    @Test
    public void testMatchField() {
        var mudClient = readClassMudClient();

        var match = new StringBuilder()
                .append("   public int oo = 0;").append(lineSeparator)
                .append("   public int op;").append(lineSeparator)
                .append("   public int ***oq***;").append(lineSeparator)
                .append("   public com.rsc.b.e or;")
                .toString();

        var result = matcher.match(mudClient);
        assertThat(result.getMemberName(), equalTo("oq"));
        assertThat(result.getMatch(), equalTo(match));
    }
}
