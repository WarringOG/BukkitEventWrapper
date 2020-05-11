package com.vyzern.core.library.events;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.*;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.function.Consumer;

@Getter
public class EventStart<T> implements Listener {

    private Class<T> clazz;
    private Consumer<T> consumer;
    private JavaPlugin pl;
    private EventPriority priority;
    private EventExe eventExe;

    private EventStart(Class<T> clazz, Consumer<T> consumer, JavaPlugin plugin, EventPriority priority) {
        this.clazz = clazz;
        this.consumer = consumer;
        this.pl = plugin;
        this.priority = priority;
        eventExe = new EventExe(this);
    }

    
    public static <T extends Event> void register(Class<T> clazz, Consumer<T> consumer, JavaPlugin plugin) {
       register(clazz, consumer, plugin, EventPriority.NORMAL);
    }
    
    public static <T extends Event> void register(Class<T> clazz, Consumer<T> consumer, JavaPlugin plugin, EventPriority priority) {
       EventStart start = new EventStart(clazz, consumer, plugin, priority);
       start.getEventExe().dispatch();
    }
}
