package com.rscvanilla.bot.script.template;

public interface RunnableScriptStatusChangeListener {
    void onStatusChanging(RunnableScriptStatus newState);
}
