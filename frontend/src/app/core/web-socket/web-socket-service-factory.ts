import { webSocketConfig } from "./web-socket.config";
import { WebSocketService } from "./web-socket.service";

export function webSocketServiceFactory() {
    const webSocket = new WebSocketService();
    webSocket.configure(webSocketConfig);
    webSocket.activate();
    return webSocket;
  }