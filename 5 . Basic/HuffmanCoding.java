import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        left = null;
        right = null;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}

public class HuffmanCoding {

    public static Map<Character, String> buildHuffmanCodeMap(HuffmanNode root) {
        Map<Character, String> huffmanCodeMap = new HashMap<>();
        buildCodeMap(root, "", huffmanCodeMap);
        return huffmanCodeMap;
    }

    private static void buildCodeMap(HuffmanNode node, String code, Map<Character, String> codeMap) {
        if (node.isLeaf()) {
            codeMap.put(node.character, code);
            return;
        }

        buildCodeMap(node.left, code + "0", codeMap);
        buildCodeMap(node.right, code + "1", codeMap);
    }

    public static HuffmanNode buildHuffmanTree(char[] characters, int[] frequencies) {
        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>();

        for (int i = 0; i < characters.length; i++) {
            HuffmanNode node = new HuffmanNode(characters[i], frequencies[i]);
            minHeap.add(node);
        }

        while (minHeap.size() > 1) {
            HuffmanNode left = minHeap.poll();
            HuffmanNode right = minHeap.poll();
            HuffmanNode merged = new HuffmanNode('\0', left.frequency + right.frequency);
            merged.left = left;
            merged.right = right;
            minHeap.add(merged);
        }

        return minHeap.poll();
    }

    public static void main(String[] args) {
        char[] characters = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] frequencies = {5, 9, 12, 13, 16, 45};

        HuffmanNode root = buildHuffmanTree(characters, frequencies);
        Map<Character, String> huffmanCodeMap = buildHuffmanCodeMap(root);

        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
