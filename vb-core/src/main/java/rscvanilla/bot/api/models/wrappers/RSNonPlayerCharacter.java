package rscvanilla.bot.api.models.wrappers;

import rscvanilla.bot.api.models.Position;
import rscvanilla.bot.mc.MudClientHooker;

public class RSNonPlayerCharacter extends RSEntity<com.rsc.e.j> {

    public RSNonPlayerCharacter(com.rsc.e.j object, MudClientHooker hooks) {
        super(object, hooks);
    }

    public Position getLocalPosition() { return getDynamicLocalPosition(); }
}