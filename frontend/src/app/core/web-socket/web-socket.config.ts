import { RxStompConfig } from '@stomp/rx-stomp';
import { environment } from '../../../environments/environment';

export const webSocketConfig: RxStompConfig = {
  brokerURL: environment.ws.base,

  connectHeaders: {
    login: 'guest',
    passcode: 'guest',
  },

  heartbeatIncoming: 0, 
  heartbeatOutgoing: 20000, 

  reconnectDelay: 200,
};