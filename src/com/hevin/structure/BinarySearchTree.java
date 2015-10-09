package com.hevin.structure;

/**
 * 二叉查找树
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    public Node root;

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.N;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.leftChild, key);
        } else if (cmp > 0) {
            return get(x.rightChild, key);
        } else {
            return x.value;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.leftChild = put(x.leftChild, key, val);
        } else if (cmp > 0) {
            x.rightChild = put(x.rightChild, key, val);
        } else {
            x.value = val;
        }
        x.N = size(x.leftChild) + size(x.rightChild) + 1;
        return x;
    }

    public void del(Key key) {
        del(root, key);
    }

    private Node del(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.leftChild = del(x.leftChild, key);
        } else if (cmp > 0) {
            x.rightChild = del(x.rightChild, key);
        } else {
            if (x.leftChild == null) {
                return x.rightChild;
            }
            if (x.rightChild == null) {
                return x.leftChild;
            }
            Node t = x;
            x = min(t.rightChild);
            x.rightChild = delMin(t.rightChild);
            x.leftChild = t.leftChild;
        }
        x.N = size(x.leftChild) + size(x.rightChild) + 1;
        return x;
    }

    public void delMin() {
        root = delMin(root);
    }

    private Node delMin(Node x) {
        if (x.leftChild == null) {
            return x.rightChild;
        }
        x.leftChild = delMin(x.leftChild);
        x.N = size(x.leftChild) + size(x.rightChild) + 1;
        return x;
    }

    public Node min() {
        return min(root);
    }

    private Node min(Node x) {
        if (x.leftChild == null) {
            return x;
        }
        return min(x.leftChild);
    }

    public Node max() {
        return max(root);
    }

    private Node max(Node x) {
        if (x.rightChild == null) {
            return x;
        }
        return max(x.rightChild);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.leftChild, key);
        }
        Node t = floor(x.rightChild, key);
        if (t == null) {
            return x;
        } else {
            return t;
        }
    }

    /**
     * 查找树中排名为k的键
     *
     * @param k
     * @return
     */
    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.leftChild);
        if (t > k) {
            return select(x.leftChild, k);
        } else if (t < k) {
            return select(x.rightChild, k - t - 1);
        }
        return x;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(x.leftChild, key);
        } else if (cmp > 0) {
            return 1 + size(x.leftChild) + rank(x.rightChild, key);
        } else {
            return size(x.leftChild);
        }
    }

    /**
     * 按顺序输出所有的结点
     */
    public void print(Node x) {
        if (x == null) {
            return;
        }
        print(x.leftChild);
        System.out.print(x.key + " ");
        print(x.rightChild);
    }

    class Node {
        public Key key;    // 键
        public Value value; // 值
        public Node leftChild;
        public Node rightChild;
        public int N;   // 以该结点为根的子树中的结点总数

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }
}
