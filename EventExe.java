package com.vyzern.core.library.events;

import com.vyzern.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;

public class EventExe<T> implements EventExecutor, Listener {

    private EventStart start;

    public EventExe(EventStart start) {
        this.start = start;
    }

    public void dispatch() {
        Bukkit.getPluginManager().registerEvent(start.getClazz(), this, start.getPriority(), this, Main.getInstance());
    }

    @Override
    public void execute(Listener listener, Event event) throws EventException {
        T type = (T)start.getClazz().cast(event);
        start.getConsumer().accept(type);
    }
}
