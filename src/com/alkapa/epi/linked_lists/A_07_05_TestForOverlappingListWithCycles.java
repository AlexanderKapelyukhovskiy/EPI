package com.alkapa.epi.linked_lists;

public class A_07_05_TestForOverlappingListWithCycles {
    public ListNode<Integer> overlappingList(ListNode<Integer> L1, ListNode<Integer> L2) {
        ListNode<Integer> l1CycleRoot = A_07_03_TestForCyclicity.hasCycle(L1);
        ListNode<Integer> l2CycleRoot = A_07_03_TestForCyclicity.hasCycle(L2);

        if (l1CycleRoot == null && l2CycleRoot == null) {
            return A_07_04_TestForOverlappingLists.overlapping(L1, L2);
        } if (l1CycleRoot != null && l2CycleRoot == null || l1CycleRoot == null && l2CycleRoot != null) {
            return null;
        } else {
            ListNode<Integer> temp = l2CycleRoot;
            do {
                temp = temp.next;
            } while (l1CycleRoot != temp && l2CycleRoot != temp);

            return temp == l2CycleRoot ? l1CycleRoot : null;
        }
    }
}
