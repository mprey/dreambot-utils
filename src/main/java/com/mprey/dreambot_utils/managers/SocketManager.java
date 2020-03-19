package com.mprey.dreambot_utils.managers;

import com.mprey.dreambot_utils.DreambotUtils;
import com.mprey.dreambot_utils.statics.Endpoint;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.net.URISyntaxException;

public class SocketManager {

    private static Socket socket;

    public static void connect() {
        try {
            socket = IO.socket(DreambotUtils.getEnvironment().getSocketURI() + Endpoint.Socket.SCRIPTS);
        } catch (URISyntaxException e) {
            DreambotUtils.log("Error connecting to socket: " + e.getMessage());
        }
    }

    public static Socket on(String event, Emitter.Listener listener) {
        socket.on(event, listener);
        return socket;
    }

}
