package me.godspunky.skyblock.util;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import java.net.InetSocketAddress;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class BungeeChannel {
    private static WeakHashMap<Plugin, BungeeChannel> registeredInstances = new WeakHashMap<>();

    private final PluginMessageListener messageListener;

    private final Plugin plugin;

    private final Map<String, Queue<CompletableFuture<?>>> callbackMap;

    private Map<String, ForwardConsumer> forwardListeners;

    private ForwardConsumer globalForwardListener;

    public static synchronized BungeeChannel of(Plugin plugin) {
        return registeredInstances.compute(plugin, (k, v) -> {
            if (v == null)
                v = new BungeeChannel(plugin);
            return v;
        });
    }

    public BungeeChannel(Plugin plugin) {
        this.plugin = Objects.<Plugin>requireNonNull(plugin, "plugin cannot be null");
        this.callbackMap = new HashMap<>();
        synchronized (registeredInstances) {
            registeredInstances.compute(plugin, (k, oldInstance) -> {
                if (oldInstance != null)
                    oldInstance.unregister();
                return this;
            });
        }
        this.messageListener = this::onPluginMessageReceived;
        Messenger messenger = Bukkit.getServer().getMessenger();
        messenger.registerOutgoingPluginChannel(plugin, "BungeeCord");
        messenger.registerIncomingPluginChannel(plugin, "BungeeCord", this.messageListener);
    }

    public void registerForwardListener(ForwardConsumer globalListener) {
        this.globalForwardListener = globalListener;
    }

    public void registerForwardListener(String channelName, ForwardConsumer listener) {
        if (this.forwardListeners == null)
            this.forwardListeners = new HashMap<>();
        synchronized (this.forwardListeners) {
            this.forwardListeners.put(channelName, listener);
        }
    }

    public CompletableFuture<Integer> getPlayerCount(String serverName) {
        Player player = getFirstPlayer();
        CompletableFuture<Integer> future = new CompletableFuture<>();
        synchronized (this.callbackMap) {
            this.callbackMap.compute("PlayerCount-" + serverName, computeQueueValue(future));
        }
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("PlayerCount");
        output.writeUTF(serverName);
        player.sendPluginMessage(this.plugin, "BungeeCord", output.toByteArray());
        return future;
    }

    public CompletableFuture<List<String>> getPlayerList(String serverName) {
        Player player = getFirstPlayer();
        CompletableFuture<List<String>> future = new CompletableFuture<>();
        synchronized (this.callbackMap) {
            this.callbackMap.compute("PlayerList-" + serverName, computeQueueValue(future));
        }
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("PlayerList");
        output.writeUTF(serverName);
        player.sendPluginMessage(this.plugin, "BungeeCord", output.toByteArray());
        return future;
    }

    public CompletableFuture<List<String>> getServers() {
        Player player = getFirstPlayer();
        CompletableFuture<List<String>> future = new CompletableFuture<>();
        synchronized (this.callbackMap) {
            this.callbackMap.compute("GetServers", computeQueueValue(future));
        }
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("GetServers");
        player.sendPluginMessage(this.plugin, "BungeeCord", output.toByteArray());
        return future;
    }

    public void connect(Player player, String serverName) {
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("Connect");
        output.writeUTF(serverName);
        player.sendPluginMessage(this.plugin, "BungeeCord", output.toByteArray());
    }

    public void connectOther(String playerName, String server) {
        Player player = getFirstPlayer();
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("ConnectOther");
        output.writeUTF(playerName);
        output.writeUTF(server);
        player.sendPluginMessage(this.plugin, "BungeeCord", output.toByteArray());
    }

    public CompletableFuture<InetSocketAddress> getIp(Player player) {
        CompletableFuture<InetSocketAddress> future = new CompletableFuture<>();
        synchronized (this.callbackMap) {
            this.callbackMap.compute("IP", computeQueueValue(future));
        }
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("IP");
        player.sendPluginMessage(this.plugin, "BungeeCord", output.toByteArray());
        return future;
    }

    public void sendMessage(String playerName, String message) {
        Player player = getFirstPlayer();
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("Message");
        output.writeUTF(playerName);
        output.writeUTF(message);
        player.sendPluginMessage(this.plugin, "BungeeCord", output.toByteArray());
    }

    public CompletableFuture<String> getServer() {
        Player player = getFirstPlayer();
        CompletableFuture<String> future = new CompletableFuture<>();
        synchronized (this.callbackMap) {
            this.callbackMap.compute("GetServer", computeQueueValue(future));
        }
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("GetServer");
        player.sendPluginMessage(this.plugin, "BungeeCord", output.toByteArray());
        return future;
    }

    public CompletableFuture<String> getUUID(Player player) {
        CompletableFuture<String> future = new CompletableFuture<>();
        synchronized (this.callbackMap) {
            this.callbackMap.compute("UUID", computeQueueValue(future));
        }
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("UUID");
        player.sendPluginMessage(this.plugin, "BungeeCord", output.toByteArray());
        return future;
    }

    public CompletableFuture<String> getUUID(String playerName) {
        Player player = getFirstPlayer();
        CompletableFuture<String> future = new CompletableFuture<>();
        synchronized (this.callbackMap) {
            this.callbackMap.compute("UUIDOther-" + playerName, computeQueueValue(future));
        }
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("UUIDOther");
        output.writeUTF(playerName);
        player.sendPluginMessage(this.plugin, "BungeeCord", output.toByteArray());
        return future;
    }

    public CompletableFuture<InetSocketAddress> getServerIp(String serverName) {
        Player player = getFirstPlayer();
        CompletableFuture<InetSocketAddress> future = new CompletableFuture<>();
        synchronized (this.callbackMap) {
            this.callbackMap.compute("ServerIP-" + serverName, computeQueueValue(future));
        }
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("ServerIP");
        output.writeUTF(serverName);
        player.sendPluginMessage(this.plugin, "BungeeCord", output.toByteArray());
        return future;
    }

    public void kickPlayer(String playerName, String kickMessage) {
        Player player = getFirstPlayer();
        CompletableFuture<InetSocketAddress> future = new CompletableFuture<>();
        synchronized (this.callbackMap) {
            this.callbackMap.compute("KickPlayer", computeQueueValue(future));
        }
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("KickPlayer");
        output.writeUTF(playerName);
        output.writeUTF(kickMessage);
        player.sendPluginMessage(this.plugin, "BungeeCord", output.toByteArray());
    }

    public void forward(String server, String channelName, byte[] data) {
        Player player = getFirstPlayer();
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("Forward");
        output.writeUTF(server);
        output.writeUTF(channelName);
        output.writeShort(data.length);
        output.write(data);
        player.sendPluginMessage(this.plugin, "BungeeCord", output.toByteArray());
    }

    public void forwardToPlayer(String playerName, String channelName, byte[] data) {
        Player player = getFirstPlayer();
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("ForwardToPlayer");
        output.writeUTF(playerName);
        output.writeUTF(channelName);
        output.writeShort(data.length);
        output.write(data);
        player.sendPluginMessage(this.plugin, "BungeeCord", output.toByteArray());
    }

    private void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equalsIgnoreCase("BungeeCord"))
            return;
        ByteArrayDataInput input = ByteStreams.newDataInput(message);
        String subchannel = input.readUTF();
        synchronized (this.callbackMap) {
            if (subchannel.equals("PlayerCount") || subchannel.equals("PlayerList") || subchannel
                    .equals("UUIDOther") || subchannel.equals("ServerIP")) {
                String identifier = input.readUTF();
                Queue<CompletableFuture<?>> queue = this.callbackMap.get(subchannel + "-" + identifier);
                if (queue == null || queue.isEmpty())
                    return;
                CompletableFuture<Integer> completableFuture = (CompletableFuture<Integer>) queue.poll();
                try {
                    String ip;
                    int port;
                    switch (subchannel) {
                        case "PlayerCount":
                            completableFuture.complete(Integer.valueOf(input.readInt()));
                            break;
                        case "PlayerList":
                            List<String> playerList = Arrays.asList(input.readUTF().split(", "));
                            int playerCount = playerList.size();
                            completableFuture.complete(playerCount);
                            break;
                        case "UUIDOther":
                            completableFuture.complete(Integer.valueOf(input.readUTF()));
                            break;
                        case "ServerIP":
                            ip = input.readUTF();
                            port = input.readUnsignedShort();
                            completableFuture.complete(new InetSocketAddress(ip, port).getPort());
                            break;
                    }
                } catch (Exception ex) {
                    completableFuture.completeExceptionally(ex);
                }
                return;
            }
            Queue<CompletableFuture<?>> callbacks = this.callbackMap.get(subchannel);
            if (callbacks == null) {
                short dataLength = input.readShort();
                byte[] data = new byte[dataLength];
                input.readFully(data);
                if (this.globalForwardListener != null)
                    this.globalForwardListener.accept(subchannel, player, data);
                if (this.forwardListeners != null)
                    synchronized (this.forwardListeners) {
                        ForwardConsumer listener = this.forwardListeners.get(subchannel);
                        if (listener != null)
                            listener.accept(subchannel, player, data);
                    }
                return;
            }
            if (callbacks.isEmpty())
                return;
            CompletableFuture<List<String>> callback = (CompletableFuture<List<String>>) callbacks.poll();
            try {
                String ip;
                int port;
                switch (subchannel) {
                    case "GetServers":
                        callback.complete(Arrays.asList(input.readUTF().split(", ")));
                        break;
                    case "GetServer":
                    case "UUID":
                        callback.complete(Collections.singletonList(input.readUTF()));
                        break;
                    case "IP":
                        ip = input.readUTF();
                        port = input.readInt();
                        callback.complete((List<String>) new InetSocketAddress(ip, port));
                        break;
                }
            } catch (Exception ex) {
                callback.completeExceptionally(ex);
            }
        }
    }

    public void unregister() {
        Messenger messenger = Bukkit.getServer().getMessenger();
        messenger.unregisterIncomingPluginChannel(this.plugin, "BungeeCord", this.messageListener);
        messenger.unregisterOutgoingPluginChannel(this.plugin);
        this.callbackMap.clear();
    }

    private BiFunction<String, Queue<CompletableFuture<?>>, Queue<CompletableFuture<?>>> computeQueueValue(CompletableFuture<?> queueValue) {
        return (key, value) -> {
            if (value == null)
                value = new ArrayDeque<>();
            value.add(queueValue);
            return value;
        };
    }

    private Player getFirstPlayer() {
        Player firstPlayer = getFirstPlayer0(Bukkit.getOnlinePlayers());
        if (firstPlayer == null)
            throw new IllegalArgumentException("Bungee Messaging Api requires at least one player to be online.");
        return firstPlayer;
    }

    private Player getFirstPlayer0(Player[] playerArray) {
        return (playerArray.length > 0) ? playerArray[0] : null;
    }

    private Player getFirstPlayer0(Collection<? extends Player> playerCollection) {
        return (Player)Iterables.getFirst(playerCollection, null);
    }

    @FunctionalInterface
    public static interface ForwardConsumer {
        void accept(String param1String, Player param1Player, byte[] param1ArrayOfbyte);
    }
}


/* Location:              C:\Users\Administrator\Downloads\legacy-2022-05-build143.jar!\vn\giakhanhvn\skysi\\util\BungeeChannel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */