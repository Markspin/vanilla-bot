import rscvanilla.hooker.matchers.mudclient.NpcListIndexFieldMatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NpcListIndexFieldMatcherTests extends BaseTests {

    private NpcListIndexFieldMatcher matcher;

    @BeforeEach
    public void setMatcher() {
        matcher = new NpcListIndexFieldMatcher();
    }

    @Test
    public void testMatchField() {
        var mudClient = readClassMudClient();

        var match = new StringBuilder()
                .append("   private com.rsc.b.c qp;").append(lineSeparator)
                .append("   private int qq;").append(lineSeparator)
                .append("   private final int[] qr;").append(lineSeparator)
                .append("   private final int[] qs;").append(lineSeparator)
                .append("   private int qt;")
                .toString();

        var result = matcher.match(mudClient);
    }
}
