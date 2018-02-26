package com.endava.entities;

/**
 * This class define a client and his information.
 * Every client is identify by a unique id.
 */
public class Client {
        private int id;

        public Client(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


}
