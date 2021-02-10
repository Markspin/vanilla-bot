package rscvanilla.bot.api.models.wrappers;

import rscvanilla.bot.api.models.Position;
import rscvanilla.bot.mc.MudClientHooker;

public class RSGroundObject extends RSEntity<com.rsc.e.e> {

    public RSGroundObject(com.rsc.e.e object, MudClientHooker hooks) {
        super(object, hooks);
    }

    public Position getLocalPosition() { return getStaticLocalPosition(); }
}