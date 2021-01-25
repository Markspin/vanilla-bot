package rscvanilla.hook.model.classes.mudclient;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import rscvanilla.hook.model.annotations.YamlClassInfo;
import rscvanilla.hook.model.annotations.YamlClassMemberKey;
import rscvanilla.hook.model.contracts.WithClassMembers;

@JsonPropertyOrder(alphabetic = true)
@YamlClassInfo("methods")
public class MudClientClassMethods implements WithClassMembers {
    @YamlClassMemberKey("login") public String login;
    @YamlClassMemberKey("logout") public String logout;
    @YamlClassMemberKey("send_chat_message") public String sendChatMessage;
    @YamlClassMemberKey("send_walk_to_ground_item") public String sendWalkToGroundItem;
    @YamlClassMemberKey("show_login_screen") public String showLoginScreen;
    @YamlClassMemberKey("walk_to_area") public String walkToArea;
    @YamlClassMemberKey("walk_to_object") public String walkToObject;
    @YamlClassMemberKey("walk_to_wall") public String walkToWall;

}

