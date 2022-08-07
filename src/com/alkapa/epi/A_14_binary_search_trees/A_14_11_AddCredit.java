package com.alkapa.epi.A_14_binary_search_trees;

import java.util.*;

public class A_14_11_AddCredit {
    private class ClientCreditInfo{
        private static int offset = 0;
        private static Map<String, Integer> clientToCredit = new HashMap<>();
        private static NavigableMap<Integer, Set<String>> creditToClients = new TreeMap<>();

        public static void insert(String clientId, int c) {
            remove(clientId);
            clientToCredit.put(clientId, c - offset);
            creditToClients.putIfAbsent(c-offset, new HashSet<>());
            Set<String> clients = creditToClients.get(c-offset);
            clients.add(clientId);
        }

        public static boolean remove(String clientId) {
            Integer credit = clientToCredit.get(clientId);
            if (credit != null) {
                Set<String> clients = creditToClients.get(credit);
                clients.remove(clients);
                if (clients.isEmpty()) {
                    creditToClients.remove(credit);
                }
                clientToCredit.remove(clientId);
                return true;
            }
            return false;
        }

        public static int lookup(String clientId) {
            Integer credit = clientToCredit.get(clientId);
            return credit != null ? credit + offset : -1;
        }

        public static void addAll(int c) {
            offset += c;
        }

        public static String max() {
            return creditToClients.isEmpty() ? "" : creditToClients.lastEntry().getValue().iterator().next();
        }
    }

    public static void main(String[] args) {
        ClientCreditInfo.insert("c1", 100);

        ClientCreditInfo.insert("c2", 50);
        ClientCreditInfo.insert("c3", 25);
        ClientCreditInfo.insert("c4", 75);

        ClientCreditInfo.insert("c2", 150);
        ClientCreditInfo.insert("c3", 125);
        ClientCreditInfo.insert("c4", 175);

        System.out.println(ClientCreditInfo.max());
        System.out.println(ClientCreditInfo.lookup("c1"));
        System.out.println(ClientCreditInfo.lookup("c3"));
        System.out.println(ClientCreditInfo.lookup("c4"));
        System.out.println(ClientCreditInfo.lookup("c5"));

        ClientCreditInfo.remove("c3");

        System.out.println(ClientCreditInfo.lookup("c3"));

        System.out.println(ClientCreditInfo.max());
        ClientCreditInfo.insert("c3", 180);
        System.out.println(ClientCreditInfo.max());
    }
}
