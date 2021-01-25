package rscvanilla.hook.model.classes.mudclient;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import rscvanilla.hook.model.annotations.YamlClassInfo;
import rscvanilla.hook.model.annotations.YamlClassMemberKey;
import rscvanilla.hook.model.contracts.WithClassMembers;

@JsonPropertyOrder(alphabetic = true)
@YamlClassInfo("interceptors")
public class MudClientClassInterceptors implements WithClassMembers {
    @YamlClassMemberKey("game_captcha") public String gameCaptcha;
    @YamlClassMemberKey("game_message") public String gameMessage;
    @YamlClassMemberKey("game_settings") public String gameSettings;
}