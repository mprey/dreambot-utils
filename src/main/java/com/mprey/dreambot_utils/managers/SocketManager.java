package com.mprey.dreambot_utils.managers;

import com.mprey.dreambot_utils.DreambotUtils;
import com.mprey.dreambot_utils.statics.Endpoint;
import io.socket.client.Ack;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.net.URISyntaxException;

public class SocketManager {

    private static Socket socket;

    public static void connect() {
        String uri = DreambotUtils.getEnvironment().getSocketURI() + Endpoint.Socket.SCRIPTS;
        try {
            DreambotUtils.log("Trying to connect to socket: " + uri);
            IO.Options options = new IO.Options();
            options.query = "uuid=" + DreambotUtils.getScript().getParams().getUUID();
            socket = IO.socket(uri, options);
            socket.connect();
        } catch (URISyntaxException e) {
            DreambotUtils.log("Error connecting to socket: " + e.getMessage());
        }
    }

    public static Socket on(String event, Emitter.Listener listener) {
        socket.on(event, listener);
        return socket;
    }

    public static void registerDefaultListeners() {
        socket.on("SHUTDOWN", (objects -> {
            DreambotUtils.log("Got request to shutdown");
            if (objects.length > 0) {
                Ack ack = (Ack) objects[0];
                ack.call();
            }
            ScriptManager.shutdown("Request by socket");
        }));
//
//        socket.on("GET_UUID", (objects -> {
//            DreambotUtils.log("Got request for UUID");
//            Ack ack = (Ack) objects[0];
//            ack.call(DreambotUtils.getScript().getParams().getUUID());
//        }));
    }

}
