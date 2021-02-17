package rscvanilla.cjci.updater.core.services;

import org.slf4j.LoggerFactory;
import rscvanilla.cjci.updater.core.searcher.classes.NullClassFieldSearcher;
import rscvanilla.cjci.updater.core.searcher.classes.NullClassInterceptorSearcher;
import rscvanilla.cjci.updater.core.searcher.classes.packetbuilder.PacketBuilderClassMethodSearcher;
import rscvanilla.cjci.updater.infrastructure.AppParameters;
import rscvanilla.cjci.updater.services.ConsoleService;
import rscvanilla.cjci.updater.services.SourceFileService;

import javax.inject.Inject;

public class PacketBuilderClassMemberService extends ClassMemberBaseService<NullClassFieldSearcher,
    PacketBuilderClassMethodSearcher,
    NullClassInterceptorSearcher> {

    @Inject
    public PacketBuilderClassMemberService(NullClassFieldSearcher fieldSearcher,
                                           PacketBuilderClassMethodSearcher methodSearcher,
                                           NullClassInterceptorSearcher interceptorSearcher,
                                           SourceFileService sourceFileService,
                                           ConsoleService consoleService,
                                           AppParameters parameters) {
        super(fieldSearcher, methodSearcher, interceptorSearcher, sourceFileService, consoleService, parameters, LoggerFactory.getLogger(PacketBuilderClassMemberService.class));
    }
}