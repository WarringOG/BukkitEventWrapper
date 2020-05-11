# BukkitEventWrapper
CreeperCry and Warring Collabed
Credit: CreeperCry

Usage:
```java
EventStart.register(BlockBreakEvent.class, event -> {
event.getPlayer().sendMessage("Block broken");
}, Main.getInstance(), EventPriority.NORMAL);
```

