package rscvanilla.hooker.core.searcher;

import rscvanilla.hooker.core.matcher.ClassMemberNameMatch;
import rscvanilla.hooker.core.matcher.ClassMemberNameMatchStatus;

public class ClassMemberSearchResult {

    private final String classMemberYamlKey;
    private final ClassMemberNameMatch oldFileMatch;
    private final ClassMemberNameMatch newFileMatch;

    public ClassMemberSearchResult(String classMemberYamlKey, ClassMemberNameMatch oldFileMatch, ClassMemberNameMatch newFileMatch) {
        this.classMemberYamlKey = classMemberYamlKey;
        this.oldFileMatch = oldFileMatch;
        this.newFileMatch = newFileMatch;
    }

    public ClassMemberNameMatch getNewFileMatch() { return newFileMatch; }
    public ClassMemberNameMatch getOldFileMatch() { return oldFileMatch; }
    public String getClassMemberYamlKey() { return classMemberYamlKey; }

    public boolean isSingleMatch() {
        return newFileMatch.getStatus() == ClassMemberNameMatchStatus.SINGLE;
    }
}
