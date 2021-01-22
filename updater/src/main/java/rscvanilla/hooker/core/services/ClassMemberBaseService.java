package rscvanilla.hooker.core.services;

import org.slf4j.Logger;
import rscvanilla.hooker.contracts.WithClassMemberGroups;
import rscvanilla.hooker.contracts.WithClassMembers;
import rscvanilla.hooker.contracts.WithMethodGroup;
import rscvanilla.hooker.services.ConsoleService;
import rscvanilla.hooker.contracts.WithFieldGroup;
import rscvanilla.hooker.core.searcher.ClassMemberSearcher;
import rscvanilla.hooker.services.SourceFileService;
import rscvanilla.hooker.utils.ClassMemberSearchResultUtil;

public class ClassMemberBaseService<TFieldSearcher extends ClassMemberSearcher, TMethodSearcher extends ClassMemberSearcher> {

    protected TFieldSearcher fieldSearcher;
    protected TMethodSearcher methodSearcher;

    protected final SourceFileService sourceFileService;
    protected final ConsoleService console;

    private final Logger logger;

    protected ClassMemberBaseService(TFieldSearcher fieldSearcher,
                                     TMethodSearcher methodSearcher,
                                     SourceFileService sourceFileService,
                                     ConsoleService consoleService,
                                     Logger logger) {
        this.fieldSearcher = fieldSearcher;
        this.methodSearcher = methodSearcher;
        this.sourceFileService = sourceFileService;
        this.console = consoleService;
        this.logger = logger;
    }

    public void setValuesToClassMembers(WithClassMemberGroups clazz) {
        var qualifiedName = clazz.getQualifiedName();

        var newFile = sourceFileService.readNewFile(qualifiedName);
        var oldFile = sourceFileService.readOldFile(qualifiedName);

        if (clazz instanceof WithFieldGroup) {
            setValuesToClassMembers(((WithFieldGroup)clazz).getFields(), clazz, fieldSearcher, newFile, oldFile);
        }

        if (clazz instanceof WithMethodGroup) {
            setValuesToClassMembers(((WithMethodGroup)clazz).getMethods(), clazz, methodSearcher, newFile, oldFile);
        }
    }

    private void setValuesToClassMembers(WithClassMembers withClassMembers,
                                         WithClassMemberGroups withClassMemberGroups,
                                         ClassMemberSearcher classMemberSearcher,
                                         String newFileContent,
                                         String oldFileContent) {

        classMemberSearcher.setSearchableFileContent(newFileContent, oldFileContent);
        classMemberSearcher.setSearchableClassMembers(withClassMembers);

        for (var searchResult : classMemberSearcher.searchMembers()) {
            var outputString = ClassMemberSearchResultUtil.createOutputString(searchResult, withClassMembers, withClassMemberGroups);

            if (searchResult.isSingleMatch()) {
                logger.info(System.lineSeparator() + outputString);
            } else {
                logger.warn(System.lineSeparator() + outputString);
            }
            //console.pressEnterToContinue();
        }
    }

}
