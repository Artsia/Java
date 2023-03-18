import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

public class AdviceApp {
    static class Advice {
        int id;
        String advice;

        public Advice(int id, String advice) {
            this.id = id;
            this.advice = advice;
        }

        public String toString() {
            return "Advice #" + id + ": " + advice;
        }
    }

    static class Node {
        Advice advice;
        Node next;

        public Node(Advice advice) {
            this.advice = advice;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;

        public LinkedList() {
            head = null;
        }

        public void add(Advice advice) {
            Node newNode = new Node(advice);

            if (head == null) {
                head = newNode;
            } else {
                Node curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = newNode;
            }
        }

        public void display() {
            Node curr = head;
            while (curr != null) {
                System.out.println(curr.advice);
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        String apiUrl = "https://api.adviceslip.com/advice";
        LinkedList adviceList = new LinkedList();

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse the JSON response and add each advice to the linked list
            // Assume that the JSON response is in the following format:
            // {
            //   "slip": {
            //     "id": 123,
            //     "advice": "Example advice text"
            //   }
            // }
            String json = response.toString();
            JSONObject jsonObject = new JSONObject(json);
            JSONObject slipObject = jsonObject.getJSONObject("slip");
            int id = slipObject.getInt("id");
            String adviceText = slipObject.getString("advice");
            Advice advice = new Advice(id, adviceText);
            adviceList.add(advice);
        } catch (IOException | JSONException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        adviceList.display();
    }
}
