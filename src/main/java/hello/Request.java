package hello;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Request {
        @Id
        public String id;

        public String reqTime;
        public String ip;

        public Request() {}

        public Request(String reqTime, String ip) {
            this.reqTime = reqTime;
            this.ip = ip;
        }

        @Override
        public String toString() {
            return String.format(
                    "Request[id: %s%n ip: %s%n request time: %s%n]",
                    id.substring(id.length() - 4), ip, reqTime);
        }


}
