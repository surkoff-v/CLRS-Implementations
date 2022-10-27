package com.company.dataStructures;

public class ThreeArrayLinkedList {
    private static final int empty_list = -1;

    public static final int MAX_SIZE = 100;

    private int[] prev = new int[MAX_SIZE];
    private int[] next = new int[MAX_SIZE];
    private int[] keys = new int[MAX_SIZE];

    private int freeListTop;

    private ThreeArrayLinkedList() {
        int i;
        for (i = 0; i < MAX_SIZE - 1; i++) {
            next[i] = i + 1;
        }

        next[i] = empty_list;
        freeListTop = 0;
    }

    private int allocate_object() {
        if (freeListTop == empty_list) {
            throw new RuntimeException("Storage is full\n");
        }

        int new1 = freeListTop;
        freeListTop = next[freeListTop];
        return new1;
    }

    private void free_object(int pointer) {
        next[pointer] = freeListTop;
        freeListTop = pointer;
    }

    private int consume(int key, int pointer) {
        int new1 = allocate_object();

        next[new1] = pointer;
        prev[new1] = empty_list;
        keys[new1] = key;

        if (pointer != empty_list) {
            prev[pointer] = new1;
        }

        return new1;
    }

    private void delete(int pointer) {
        if (prev[pointer] != empty_list) {
            next[prev[pointer]] = next[pointer];
        }

        if (next[pointer] != empty_list) {
            prev[next[pointer]] = prev[pointer];
        }

        free_object(pointer);
    }

    private int get(int pointer) {
        if (pointer == empty_list) {
            return empty_list;
        }
        return keys[pointer];
    }

    private int next_obj(int pointer) {
        if (pointer == empty_list) {
            return empty_list;
        }
        return next[pointer];
    }

    private int compatify_list(int pointer) {
        int left;
        int right;
        int i;

        if (freeListTop == empty_list) {
            return pointer;
        }

        i = freeListTop;
        /**
         * tag -2 for all empty list prev field
         */
        while (i != empty_list) {
            prev[i] = -2;
            i = next[i];
        }

        left = 0;
        right = MAX_SIZE - 1;
        while (true) {
            while (prev[left] != -2) {
                left++;
            }
            /**
             * left index is first empty from left to right
             */

            while (prev[right] == -2) {
                right--;
            }
            /**
             * right index is first active from right to left
             */

            if (left >= right) {
                break;
            }

            /**
             *  set first empty from left to right to first not empty from right to left
             */
            prev[left] = prev[right];
            next[left] = next[right];
            keys[left] = keys[right];

            /**
             * set left as next field of the first not empty from rigth to left
             */
            next[right] = left;

            right--;
            left++;
        }

        right++;

        for (int j = 0; j < right; j++) {
            if (prev[j] >= right) {
                prev[j] = next[prev[j]];
            }

            if (next[j] >= right) {
                next[j] = next[next[j]];
            }
        }

        if (pointer >= right) {
            pointer = next[pointer];
        }

        for (i = right; i < MAX_SIZE - 1; i++) {
            next[i] = i + 1;
        }
        next[i] = empty_list;

        freeListTop = right;

        return pointer;
    }


}
