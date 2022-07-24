package com.alkapa.epi.A_13_sorting;

import java.util.List;
import java.util.stream.Collectors;

public class A_13_10_TeamPhotoDay {
    private static class Player implements Comparable<Player> {
        public Integer height;

        public Player(Integer height) {
            this.height = height;
        }

        @Override
        public int compareTo(Player that) {
            return Integer.compare(this.height, that.height);
        }
    }

    public static boolean validPlacementEsixts (List<Player> team0, List<Player> team1) {
        team0.sort((a ,b) -> Integer.compare(a.height, b.height));
        team1.sort((a ,b) -> Integer.compare(a.height, b.height));
        if (team1.get(0).height > team0.get(0).height) {
            List<Player> temp = team1;
            team1 = team0;
            team0 = temp;
        }
        for(int i = 0; i < team0.size() && i < team1.size(); ++i) {
            if (team0.get(i).height < team1.get(i).height) {
                return false;
            }
        }
        return true;
    }

    class Team {
        private static class Player implements Comparable<Player> {
            public Integer height;

            public Player(Integer height) {
                this.height = height;
            }

            @Override
            public int compareTo(Player that) {
                return Integer.compare(this.height, that.height);
            }
        }
        private List<Player> players;
        public Team(List<Integer> height) {
            players = height.stream().map(h -> new Player(h)).collect(Collectors.toList());
        }

        private List<Player> sortPlayersByHeight() {
            return players.stream().sorted().collect(Collectors.toList());
        }

        public static boolean validPlacementExists(Team team0, Team team1) {
            List<Player> team0Sorted = team0.sortPlayersByHeight();
            List<Player> team1Sorted = team1.sortPlayersByHeight();
            for (int i = 0; i < team0Sorted.size() && i < team1Sorted.size(); ++i) {
                if (team0Sorted.get(i).compareTo(team1Sorted.get(i)) >= 0) {
                    return false;
                }
            }
            return true;
        }

//        public  class IsArrayDominated {
//            public static void validPlacementExistsWrapper(
//                    TimedExecutor executor,
//                    List<Integer> team0, List<Integer> team1,
//                    boolean expected01, boolean expected10) throws Exception {
//
//                Team t0 = new Team(team0), t1 = new Team(team1);
//                boolean result01 = executor.run( () -> Team.validPlacementExists(t0, t1));
//                boolean result10 = executor.run( () -> Team.validPlacementExists(t1, t0));
//                if (result01 != expected01 || result10 != expected10) {
//                    throw new TestFailure("");
//                }
//            }
//        }
    }
}
