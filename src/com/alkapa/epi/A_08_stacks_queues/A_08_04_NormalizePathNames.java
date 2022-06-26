package com.alkapa.epi.A_08_stacks_queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class A_08_04_NormalizePathNames {
    public static String shortestEquivalentPath(String path) {
        if (path.equals("")) {
            throw new IllegalArgumentException("Empty string is not a legal path");
        }

        Deque<String> pathName = new ArrayDeque<>();

        if (path.startsWith("/")) {
            pathName.push("/");
        }

        for (String token : path.split("/")) {
            if (token.equals("..")) {
                if (pathName.isEmpty()) {
                    pathName.push(token);
                } else {
                    if (pathName.peek().equals("/")) {
                        throw new IllegalArgumentException("Path error. trying to go up root " + path);
                    }
                    pathName.pop();
                }
            } else if (!token.equals(".") && !token.isEmpty()) {
                pathName.push(token);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (!pathName.isEmpty()) {
            Iterator<String> it = pathName.descendingIterator();
            String prev = it.next();
            sb.append(prev);
            while (it.hasNext()) {
                if (!prev.equals("/")) {
                    sb.append("/");
                }
                prev = it.next();
                sb.append(prev);
            }
        }
        return sb.toString();
    }

    public static void test(String path) {
        String shortened = shortestEquivalentPath(path);
        System.out.println(String.format("%s -> %s", path, shortened));
    }

    public static void main(String[] args) {
        test("sc//./../tc/awk/././");
    }
}
