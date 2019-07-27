package Part1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PrintTest {

    private Tree tree;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void buildTree() {
        tree = new Tree();
        Tree.TreeNode leftChild = tree.new TreeNode(6, null, null);
        Tree.TreeNode rightChild = tree.new TreeNode(3, null, null);
        Tree.TreeNode left = tree.new TreeNode(7, null, null);
        Tree.TreeNode right = tree.new TreeNode(17, leftChild, rightChild);
        Tree.TreeNode root = tree. new TreeNode(1, left, right);
        tree = new Tree(root);
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    //checks for proper system.out.print setup for testing environment
    @Test
    public void out() {
        System.out.print("hello");
        System.out.print("world");
        assertEquals("helloworld", outContent.toString());
    }

    @Test
    public void testPreOrder() {
        tree.preOrderPrint(tree.root);

        assertEquals("1 7 17 6 3 ", outContent.toString());
    }

    @Test
    public void testInOrder() {
        tree.inOrderPrint(tree.root);

        assertEquals("7 1 6 17 3 ", outContent.toString());
    }

    @Test
    public void testPostOrder() {
        tree.postOrderPrint(tree.root);

        assertEquals("7 6 3 17 1 ", outContent.toString());
    }
}